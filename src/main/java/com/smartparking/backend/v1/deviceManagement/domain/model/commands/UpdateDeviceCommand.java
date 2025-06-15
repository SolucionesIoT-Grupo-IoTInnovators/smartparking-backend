package com.smartparking.backend.v1.deviceManagement.domain.model.commands;

import java.util.UUID;

public record UpdateDeviceCommand(
        UUID deviceId,
        String edgeServerId,
        String macAddress,
        String type
) {
}
