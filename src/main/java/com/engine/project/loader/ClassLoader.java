package com.engine.project.loader;

import com.engine.project.commands.impl.AlertCommand;
import com.engine.project.commands.impl.EnderChestCommand;
import com.engine.project.configuration.impl.MessageManager;
import me.saiintbrisson.minecraft.command.CommandFrame;
import org.bukkit.plugin.java.JavaPlugin;

public class ClassLoader {

    private final JavaPlugin plugin;

    public ClassLoader(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void load() {
        MessageManager manager = new MessageManager(plugin);

        // Commands

        CommandFrame frame = new CommandFrame(plugin, true);

        frame.setLackPermMessage(manager.getEntry("general.no-permission"));
        frame.setIncorrectTargetMessage(manager.getEntry("general.wrong-sender"));

        frame.register(
                new AlertCommand(manager),
                new EnderChestCommand(manager)
        );
    }

}
