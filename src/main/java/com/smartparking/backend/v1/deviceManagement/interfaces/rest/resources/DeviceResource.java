package com.smartparking.backend.v1.deviceManagement.interfaces.rest.resources;

import java.time.LocalDateTime;

public record DeviceResource(
        Long id,
        String macAddress,
        String type,
        String operationalStatus,
        String spotStatus,
        String spotLabel,
        String parkingSpotId,
        Long parkingId,
        String edgeServerId,
        String lastCommunication
) {
}
