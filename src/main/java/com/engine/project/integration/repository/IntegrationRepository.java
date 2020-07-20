package com.engine.project.integration.repository;

import com.engine.project.integration.Integration;
import com.engine.project.integration.IntegrationType;
import com.engine.project.utils.models.Repository;
import com.google.common.collect.Maps;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public final class IntegrationRepository implements Repository<IntegrationType, Integration> {

    private static IntegrationRepository instance;
    public static IntegrationRepository getInstance() {
        if (instance == null) {
            instance = new IntegrationRepository();
        }
        return instance;
    }

    private IntegrationRepository() {}

    private final Map<IntegrationType, Integration> integrations = Maps.newHashMap();

    @Override
    public void register(@NotNull Integration prototype) {
        integrations.put(prototype.getType(), prototype);
    }

    @Override
    @Nullable
    public Integration retrieve(@NotNull IntegrationType identifier) {
        return integrations.get(identifier);
    }

    @Override
    public void exclude(@NotNull Integration prototype) {
        integrations.remove(prototype.getType(), prototype);
    }

}
