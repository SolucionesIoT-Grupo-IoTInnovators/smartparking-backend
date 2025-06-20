package com.smartparking.backend.v1.deviceManagement.application.internal.commandservices;

import com.smartparking.backend.v1.deviceManagement.domain.model.aggregates.EdgeServer;
import com.smartparking.backend.v1.deviceManagement.domain.model.commands.CreateEdgeServerCommand;
import com.smartparking.backend.v1.deviceManagement.domain.model.valueobjects.EdgeServerStatus;
import com.smartparking.backend.v1.deviceManagement.domain.services.EdgeServerCommandService;
import com.smartparking.backend.v1.deviceManagement.infrastructure.persistence.jpa.repositories.EdgeServerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EdgeServerCommandServiceImpl implements EdgeServerCommandService {

    private final EdgeServerRepository edgeServerRepository;

    public EdgeServerCommandServiceImpl(EdgeServerRepository edgeServerRepository) {
        this.edgeServerRepository = edgeServerRepository;
    }

    @Override
    public Optional<EdgeServer> handle(CreateEdgeServerCommand command) {
        if (edgeServerRepository.existsByServerId(command.serverId())) {
            throw new IllegalArgumentException("Edge server with this serverId already exists");
        }
        EdgeServer edgeServer = new EdgeServer(command);
        return Optional.of(edgeServerRepository.save(edgeServer));
    }
}
