package com.smartparking.backend.v1.deviceManagement.interfaces.rest.transform;

import com.smartparking.backend.v1.deviceManagement.domain.model.aggregates.Device;
import com.smartparking.backend.v1.deviceManagement.interfaces.rest.resources.DeviceResource;

public class DeviceResourceFromEntityAssembler {

    public static DeviceResource toResourceFromEntity(Device entity) {
        return new DeviceResource(
                entity.getId(),
                entity.getMacAddress(),
                entity.getType(),
                entity.getOperationalStatus(),
                entity.getSpotStatus(),
                entity.getSpotLabel(),
                entity.parkingSpotId(),
                entity.getParkingId(),
                entity.edgeServerId(),
                entity.getLastCommunication()
        );
    }
}
