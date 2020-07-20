package com.engine.project.modules;

import com.engine.project.Engine;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public interface Module {

    @NotNull
    String getId();

    void init(JavaPlugin plugin);

    default boolean isEnabled() {
        return Engine.getInstance().getConfig().getBoolean("modules." + getId() + ".enabled");
    }

}
