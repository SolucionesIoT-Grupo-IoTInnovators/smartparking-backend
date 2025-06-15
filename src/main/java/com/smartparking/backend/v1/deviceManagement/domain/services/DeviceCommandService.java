package com.smartparking.backend.v1.deviceManagement.domain.services;

import com.smartparking.backend.v1.deviceManagement.domain.model.aggregates.Device;
import com.smartparking.backend.v1.deviceManagement.domain.model.commands.CreateDeviceCommand;
import com.smartparking.backend.v1.deviceManagement.domain.model.commands.UpdateDeviceCommand;

import java.util.Optional;
import java.util.UUID;

public interface DeviceCommandService {
    Optional<Device> handle(CreateDeviceCommand command);
    Optional<Device> handle(UpdateDeviceCommand command);
}
