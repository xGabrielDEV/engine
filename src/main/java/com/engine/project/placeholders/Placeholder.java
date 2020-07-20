package com.engine.project.placeholders;

import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class Placeholder {

    @NotNull
    private final String name;
    @NotNull
    private final Consumer<PlaceholderContext> callback;

    public Placeholder(@NotNull String name, @NotNull Consumer<PlaceholderContext> callback) {
        this.name = name;
        this.callback = callback;
    }

    @NotNull
    public String getName() {
        return name;
    }

    @NotNull
    public Consumer<PlaceholderContext> getCallback() {
        return callback;
    }
}
