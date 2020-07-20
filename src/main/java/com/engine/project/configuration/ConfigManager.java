package com.engine.project.configuration;

import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ConfigManager<T> {

    @Nullable
    T getEntry(@NotNull String path);

    @NotNull
    FileConfiguration getConfiguration();

}
