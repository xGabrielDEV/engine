package com.engine.project.commands.impl;

import com.engine.project.commands.Command;
import com.engine.project.configuration.impl.MessageManager;
import com.engine.project.utils.Title;
import me.saiintbrisson.minecraft.command.Execution;
import org.bukkit.Bukkit;

public class AlertCommand extends Command {

    public AlertCommand(MessageManager manager) {
        super(manager);
    }

    @me.saiintbrisson.minecraft.command.annotations.Command(
            name = "alert",
            aliases = { "alerta" },
            permission = "engine.commands.alert"
    )
    public boolean command(Execution execution) {
        if (execution.getArgs().length == 0) {
            execution.getSender().sendMessage(getManager().getEntry("general.not-enough-args", execution));
            return false;
        }
        new Title(
                getManager().getEntry("alert.title", execution),
                getManager().getEntry("alert.subtitle-prefix", execution) + " " + String.join(" ", execution.getArgs())
        ).direct(Bukkit.getOnlinePlayers());

        return false;
    }


}
