package com.engine.project.commands.impl;

import com.engine.project.configuration.impl.MessageManager;
import me.saiintbrisson.minecraft.command.Execution;
import me.saiintbrisson.minecraft.command.annotations.Command;
import me.saiintbrisson.minecraft.command.annotations.CommandTarget;

public class EnderChestCommand extends com.engine.project.commands.Command {

    public EnderChestCommand(MessageManager manager) {
        super(manager);
    }

    @Command(
            name = "enderchest",
            aliases = { "ec" },
            permission = "engine.commands.enderchest",
            target = CommandTarget.PLAYER
    )
    public void command(Execution execution) {
        execution.getPlayer().openInventory(execution.getPlayer().getEnderChest());
        execution.getPlayer().sendMessage(getManager().getEntry("general.chest-opened"));
    }

}
