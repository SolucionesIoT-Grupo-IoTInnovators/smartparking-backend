package com.smartparking.backend.v1.deviceManagement.interfaces.rest.transform;

import com.smartparking.backend.v1.deviceManagement.domain.model.commands.CreateDeviceCommand;
import com.smartparking.backend.v1.deviceManagement.domain.model.valueobjects.DeviceType;
import com.smartparking.backend.v1.deviceManagement.interfaces.rest.resources.CreateDeviceResource;

import java.util.UUID;

public class CreateDeviceCommandFromResourceAssembler {

    public static CreateDeviceCommand toCommandFromResource(CreateDeviceResource resource) {
        return new CreateDeviceCommand(
                resource.macAddress(),
                resource.type(),
                resource.parkingSpotId(),
                resource.edgeServerId()
        );
    }
}
