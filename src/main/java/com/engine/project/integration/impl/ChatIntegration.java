package com.engine.project.integration.impl;

import com.engine.project.integration.service.IntegrationService;
import com.engine.project.placeholders.Placeholder;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public abstract class ChatIntegration implements IntegrationService {

    /**
     * Add a placeholder
     * @param placeholder the placeholder
     */
    public abstract void addPlaceholder(@NotNull Placeholder placeholder);

    /**
     * Get all registered placeholders
     * @return Placeholders
     */
    @NotNull
    public abstract Collection<Placeholder> getPlaceholders();

    /**
     * Remove a placeholder
     * @param placeholder The placeholder
     */
    public abstract void removePlaceholder(@NotNull Placeholder placeholder);

}
