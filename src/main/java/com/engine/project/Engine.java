package com.engine.project;

import com.engine.project.api.EngineAPI;
import com.engine.project.loader.ClassLoader;
import com.engine.project.modules.ModuleLoader;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

public final class Engine extends JavaPlugin {

    /**
     * Method will be called on plugin load
     */
    @Override
    public void onEnable() {
        saveDefaultConfig();
        saveResource("messages.yml", false);

        new ClassLoader(this).load();
        new ModuleLoader(this).load();

        getServer().getServicesManager().register(EngineAPI.class, new EngineAPI(), this, ServicePriority.Normal);

        getLogger().info("Plugin enabled successfully!");
    }

    /**
     * Method will be called on plugin disable
     */
    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled successfully!");
    }

    public static Engine getInstance() {
        return getPlugin(Engine.class);
    }

}
