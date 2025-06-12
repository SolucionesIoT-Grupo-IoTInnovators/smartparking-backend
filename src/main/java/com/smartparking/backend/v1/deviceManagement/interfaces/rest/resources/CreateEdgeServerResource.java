package com.smartparking.backend.v1.deviceManagement.interfaces.rest.resources;

public record CreateEdgeServerResource(
        String name,
        String ipAddress,
        Integer port,
        Long parkingId
        ) {

}
