package com.engine.project.loader;

import com.engine.project.commands.AlertCommand;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ClassLoader {

    private final JavaPlugin plugin;

    public ClassLoader(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void load() {
        // Commands

        new AlertCommand(plugin);
    }

}
