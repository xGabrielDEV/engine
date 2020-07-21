package com.engine.project.commands;

import com.engine.project.configuration.impl.MessageManager;

public class Command {

    private final MessageManager manager;

    public Command(MessageManager manager) {
        this.manager = manager;
    }

    public MessageManager getManager() {
        return manager;
    }
}
