package com.engine.project.integration.service;

import com.engine.project.integration.Integration;
import org.jetbrains.annotations.NotNull;

public interface IntegrationService {

    /**
     * @return The integration
     */
    @NotNull
    Integration getIntegration();

}
