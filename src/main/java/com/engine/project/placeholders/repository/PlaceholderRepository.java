package com.engine.project.placeholders.repository;

import com.engine.project.placeholders.Placeholder;
import com.engine.project.utils.models.Repository;
import com.google.common.collect.Maps;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class PlaceholderRepository implements Repository<String, Placeholder> {

    private final Map<String, Placeholder> repository = Maps.newHashMap();

    @Override
    public void register(@NotNull Placeholder prototype) {
        repository.put(prototype.getName(), prototype);
    }

    @Override
    public Placeholder retrieve(@NotNull String identifier) {
        return repository.get(identifier);
    }

    @Override
    public void exclude(@NotNull Placeholder prototype) {
        repository.remove(prototype.getName(), prototype);
    }
}
