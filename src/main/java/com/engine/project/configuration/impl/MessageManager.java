package com.engine.project.configuration.impl;

import com.engine.project.configuration.ConfigManager;
import com.engine.project.placeholders.Placeholder;
import com.engine.project.placeholders.PlaceholderContext;
import com.google.common.collect.Lists;
import me.saiintbrisson.minecraft.command.Execution;
import me.saiintbrisson.minecraft.command.annotations.Command;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MessageManager implements ConfigManager<String> {

    private final FileConfiguration configuration;
    private final List<Placeholder> placeholders;

    public MessageManager(Plugin file) {
        this.configuration = YamlConfiguration.loadConfiguration(new File(file.getDataFolder() + "/" + "messages.yml"));
        this.placeholders = Lists.newArrayList();

        initPlaceholders();
    }

    private void initPlaceholders() {
        placeholders.add(new Placeholder("Online Players", (context) -> {
            context.apply("{online}", String.valueOf(Bukkit.getOnlinePlayers().size()));
        }));

        placeholders.add(new Placeholder("Player Name", (context) -> {
            context.apply("{name}", context.getPlayer().getName());
        }));
    }

    @Nullable
    @Override
    public String getEntry(@NotNull String path) {
        return ChatColor.translateAlternateColorCodes('&', configuration.getString(path));
    }

    @Nullable
    public String getEntry(@NotNull String path, @NotNull Execution execution) {
        String entry = ChatColor.translateAlternateColorCodes('&', configuration.getString(path));

        PlaceholderContext context = new PlaceholderContext(execution.getPlayer(), entry);
        placeholders.forEach((placeholder) -> {
            placeholder.getCallback().accept(context);
        });

        return entry;
    }

    @NotNull
    @Override
    public FileConfiguration getConfiguration() {
        return configuration;
    }

}
