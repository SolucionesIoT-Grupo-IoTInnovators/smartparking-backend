package com.smartparking.backend.v1.deviceManagement.interfaces.rest.resources;

public record UpdateDeviceResource(
        String edgeId,
        String macAddress,
        String type
) {
}
