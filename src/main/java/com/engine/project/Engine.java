package com.engine.project;

import com.engine.project.loader.ClassLoader;
import org.bukkit.plugin.java.JavaPlugin;

public final class Engine extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        saveResource("messages.yml", false);

        new ClassLoader(this).load();

        getLogger().info("Plugin enabled successfully!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled successfully!");
    }

    public static Engine getInstance() {
        return getPlugin(Engine.class);
    }

}
