package com.engine.project.modules;

import org.bukkit.event.Listener;

@FunctionalInterface
public interface ModuleExecutor extends Listener {

    Module getModule();

}
