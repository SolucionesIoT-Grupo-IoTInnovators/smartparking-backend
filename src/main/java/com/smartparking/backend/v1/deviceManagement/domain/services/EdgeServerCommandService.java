package com.smartparking.backend.v1.deviceManagement.domain.services;

import com.smartparking.backend.v1.deviceManagement.domain.model.aggregates.EdgeServer;
import com.smartparking.backend.v1.deviceManagement.domain.model.commands.CreateEdgeServerCommand;

import java.util.Optional;

public interface EdgeServerCommandService {
    Optional<EdgeServer> handle(CreateEdgeServerCommand command);
}
