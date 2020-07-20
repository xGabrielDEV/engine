package com.engine.project.modules;

import org.jetbrains.annotations.NotNull;

public interface Module {

    @NotNull
    String getName();

    ModuleExecutor getExecutor();

    void setEnabled(@NotNull Boolean enabled);

    @NotNull
    Boolean isEnabled();

}
