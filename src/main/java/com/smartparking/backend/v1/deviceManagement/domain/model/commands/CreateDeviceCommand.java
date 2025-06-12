package com.smartparking.backend.v1.deviceManagement.domain.model.commands;

import com.smartparking.backend.v1.deviceManagement.domain.model.valueobjects.DeviceType;

import java.util.UUID;

public record CreateDeviceCommand(
        String macAddress,
        DeviceType type,
        UUID parkingSpotId,
        Long edgeServerId
) {
}
