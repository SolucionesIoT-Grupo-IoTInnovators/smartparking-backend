package com.smartparking.backend.v1.deviceManagement.interfaces.rest.resources;

import java.time.LocalDateTime;

public record EdgeServerResource(
        Long id,
        String name,
        String ipAddress,
        String status,
        String lastHeartbeat,
        Integer connectedDevicesCount,
        Long parkingId
) {
}
