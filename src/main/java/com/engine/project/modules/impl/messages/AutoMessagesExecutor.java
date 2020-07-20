package com.engine.project.modules.impl.messages;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.List;

public class AutoMessagesExecutor {

    private final Plugin plugin;
    private final FileConfiguration file;

    public AutoMessagesExecutor(Plugin plugin) {
        this.plugin = plugin;
        this.file = plugin.getConfig();
    }

    public void init() {
        List<String> messages = file.getStringList("modules.auto-messages.messages");

        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> messages.forEach((message) -> {
            Bukkit.broadcastMessage("");
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
            Bukkit.broadcastMessage("");
        }));
    }

}
