package com.engine.project.integration;

import com.engine.project.integration.service.IntegrationService;
import org.bukkit.plugin.Plugin;

public interface Integration {

    Plugin getPlugin();

    IntegrationService getService();

    IntegrationType getType();

}
