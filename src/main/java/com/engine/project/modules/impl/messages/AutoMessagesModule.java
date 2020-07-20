package com.engine.project.modules.impl.messages;

import com.engine.project.modules.Module;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class AutoMessagesModule implements Module {

    @NotNull
    @Override
    public String getId() {
        return "auto-messages";
    }

    @Override
    public void init(JavaPlugin plugin) {
        new AutoMessagesExecutor(plugin).init();
    }

}
