package com.engine.project.modules;

import com.engine.project.utils.models.Repository;
import com.google.common.collect.Maps;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class ModuleManager implements Repository<String, Module> {

    private final Map<String, Module> repository = Maps.newHashMap();

    private ModuleManager() {}
    private static ModuleManager instance;

    public static ModuleManager getInstance() {
        if (instance == null) instance = new ModuleManager();

        return instance;
    }

    @Override
    public void register(@NotNull Module prototype) {
        repository.put(prototype.getId(), prototype);
    }

    @Nullable
    @Override
    public Module retrieve(@NotNull String identifier) {
        return repository.get(identifier);
    }

    public Map<String, Module> getRepository() {
        return repository;
    }

    @Override
    public void exclude(@NotNull Module prototype) {
        repository.remove(prototype.getId(), prototype);
    }
}
