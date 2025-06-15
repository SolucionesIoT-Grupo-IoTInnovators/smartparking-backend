package com.smartparking.backend.v1.deviceManagement.interfaces.rest.resources;

public record CreateEdgeServerResource(
        String serverId,
        String apiKey,
        String name,
        String ipAddress,
        String status,
        Long parkingId
        ) {

}
