package com.engine.project.integration;

import com.engine.project.integration.impl.ChatIntegration;
import com.engine.project.integration.service.IntegrationService;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public interface Integration {

    /**
     * Get the plugin!
     * @return Integration's plugin
     */
    @NotNull
    Plugin getPlugin();

    /**
     * Usually it's the [ChatIntegration]
     * @return The IntegrationService
     */
    @NotNull
    IntegrationService getService();

    /**
     * Get integration's type
     * @return The integration's type
     */
    @NotNull
    IntegrationType getType();

}
