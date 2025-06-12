package com.smartparking.backend.v1.deviceManagement.interfaces.rest.transform;

import com.smartparking.backend.v1.deviceManagement.domain.model.aggregates.EdgeServer;
import com.smartparking.backend.v1.deviceManagement.interfaces.rest.resources.EdgeServerResource;

public class EdgeServerResourceFromEntityAssembler {

    public static EdgeServerResource toResourceFromEntity(EdgeServer entity) {
        return new EdgeServerResource(
                entity.getId(),
                entity.getName(),
                entity.getIpAddress(),
                entity.getStatus().name(),
                entity.getLastHeartBeat(),
                entity.getConnectedDevicesCount(),
                entity.getParkingId()
        );
    }
}
