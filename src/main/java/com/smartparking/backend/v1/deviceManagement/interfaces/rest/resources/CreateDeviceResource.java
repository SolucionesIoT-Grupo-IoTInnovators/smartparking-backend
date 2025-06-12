package com.smartparking.backend.v1.deviceManagement.interfaces.rest.resources;

import com.smartparking.backend.v1.deviceManagement.domain.model.valueobjects.DeviceType;

import java.util.UUID;

public record CreateDeviceResource(
        String macAddress,
        DeviceType type,
        UUID parkingSpotId,
        Long edgeServerId
        ) {

}
