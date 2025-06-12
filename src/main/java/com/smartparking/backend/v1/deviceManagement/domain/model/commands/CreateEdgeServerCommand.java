package com.smartparking.backend.v1.deviceManagement.domain.model.commands;

public record CreateEdgeServerCommand(
        String name,
        String ipAddress,
        Long parkingId
        ) {

}
