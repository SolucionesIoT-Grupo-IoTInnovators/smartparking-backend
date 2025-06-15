package com.smartparking.backend.v1.deviceManagement.domain.model.commands;

import com.smartparking.backend.v1.deviceManagement.domain.model.valueobjects.DeviceType;

import java.util.UUID;

public record CreateDeviceCommand(
        Long parkingId, UUID parkingSpotId, String spotStatus, String spotLabel
) {
}
