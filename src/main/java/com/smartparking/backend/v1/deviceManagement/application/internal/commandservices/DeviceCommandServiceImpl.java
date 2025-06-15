package com.smartparking.backend.v1.deviceManagement.application.internal.commandservices;

import com.smartparking.backend.v1.deviceManagement.domain.model.aggregates.Device;
import com.smartparking.backend.v1.deviceManagement.domain.model.commands.CreateDeviceCommand;
import com.smartparking.backend.v1.deviceManagement.domain.model.commands.UpdateDeviceCommand;
import com.smartparking.backend.v1.deviceManagement.domain.model.valueobjects.DeviceStatus;
import com.smartparking.backend.v1.deviceManagement.domain.services.DeviceCommandService;
import com.smartparking.backend.v1.deviceManagement.infrastructure.persistence.jpa.repositories.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DeviceCommandServiceImpl implements DeviceCommandService {

    private final DeviceRepository deviceRepository;

    public DeviceCommandServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public Optional<Device> handle(CreateDeviceCommand command) {
        Device device = new Device(command.parkingId(), command.parkingSpotId(), command.spotStatus(), command.spotLabel());
        return Optional.of(deviceRepository.save(device));
    }

    @Override
    public Optional<Device> handle(UpdateDeviceCommand command) {
        var device = deviceRepository.findByParkingSpotId_SpotId(command.deviceId())
                .orElseThrow(() -> new IllegalArgumentException("Device not found"));
        device.updateMissingFields(command);
        var updatedDevice = deviceRepository.save(device);
        return Optional.of(updatedDevice);
    }
}
