package com.engine.project.utils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface Repository<K, V> {

    void register(@NotNull V prototype);

    @Nullable
    V retrieve(@NotNull K identifier);

    void exclude(@NotNull V prototype);

}
