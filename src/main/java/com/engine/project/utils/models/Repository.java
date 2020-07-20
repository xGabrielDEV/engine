package com.engine.project.utils.models;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface Repository<K, V> {

    /**
     * Register a prototype
     * @param prototype The prototype
     */
    void register(@NotNull V prototype);

    /**
     * Get a prototype from the identifier
     * @param identifier Prototype's identifier
     * @return Prototype or null
     */
    @Nullable
    V retrieve(@NotNull K identifier);

    /**
     * Remove a prototype
     * @param prototype The prototype
     */
    void exclude(@NotNull V prototype);

}
