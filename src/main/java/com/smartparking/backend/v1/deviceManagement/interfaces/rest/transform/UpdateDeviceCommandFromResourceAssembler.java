package com.smartparking.backend.v1.deviceManagement.interfaces.rest.transform;

import com.smartparking.backend.v1.deviceManagement.domain.model.commands.UpdateDeviceCommand;
import com.smartparking.backend.v1.deviceManagement.interfaces.rest.resources.UpdateDeviceResource;

import java.util.UUID;

public class UpdateDeviceCommandFromResourceAssembler {
    public static UpdateDeviceCommand toCommandFromResource(UpdateDeviceResource resource, UUID deviceId) {
        return new UpdateDeviceCommand(
                deviceId,
                resource.edgeId(),
                resource.macAddress(),
                resource.type()
        );
    }
}
