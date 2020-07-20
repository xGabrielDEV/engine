package com.engine.project.modules;

import com.engine.project.modules.impl.messages.AutoMessagesModule;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ModuleLoader {

    private final JavaPlugin plugin;
    private final FileConfiguration configuration;

    private final ModuleManager manager = ModuleManager.getInstance();

    public ModuleLoader(JavaPlugin plugin) {
        this.plugin = plugin;
        this.configuration = plugin.getConfig();
    }

    public void load() {
        manager.getRepository().clear();

        manager.register(new AutoMessagesModule());

        enable();
    }

    protected void enable() {
        manager.getRepository().values().forEach((module) -> {
            if (configuration.getBoolean("modules." + module.getId() + ".enabled")) {
                module.init(plugin);
            }
        });
    }

}
