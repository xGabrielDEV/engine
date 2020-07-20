package com.engine.project.configuration.impl;

import com.engine.project.configuration.ConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;

public class MessageManager implements ConfigManager<String> {

    private final FileConfiguration configuration;



    public MessageManager(Plugin file) {
        this.configuration = YamlConfiguration.loadConfiguration(new File(file.getDataFolder() + "/" + "messages.yml"));
    }

    @Nullable
    @Override
    public String getEntry(@NotNull String path) {
        return ChatColor.translateAlternateColorCodes('&', configuration.getString(path));
    }

    @NotNull
    @Override
    public FileConfiguration getConfiguration() {
        return configuration;
    }

}
