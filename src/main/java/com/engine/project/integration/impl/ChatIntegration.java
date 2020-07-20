package com.engine.project.integration.impl;

import com.engine.project.integration.service.IntegrationService;
import com.engine.project.placeholders.Placeholder;

import java.util.Collection;

public abstract class ChatIntegration implements IntegrationService {

    public abstract void addPlaceholder(Placeholder placeholder);

    public abstract Collection<Placeholder> getPlaceholders();

    public abstract void removePlaceholder(Placeholder placeholder);

}
