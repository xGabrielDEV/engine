package com.engine.project.commands;

import com.engine.project.configuration.impl.MessageManager;
import com.engine.project.utils.Title;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class AlertCommand implements CommandExecutor {

    private MessageManager manager;

    public AlertCommand(JavaPlugin plugin) {
        plugin.getCommand("alert").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("engine.commands.alert")) {
            sender.sendMessage(manager.getEntry("no-permission"));
            return false;
        }

        if (args.length == 0) {
            sender.sendMessage(manager.getEntry("not-enough-args"));
            return false;
        }

        new Title(
                manager.getEntry("alert.title"),
                "§" + manager.getEntry("alert.subtitle-color") + String.join(" ", args)
        ).direct(Bukkit.getOnlinePlayers());

        return false;
    }

}
