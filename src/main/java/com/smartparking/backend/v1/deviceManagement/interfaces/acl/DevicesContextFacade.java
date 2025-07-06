package com.smartparking.backend.v1.deviceManagement.interfaces.acl;

import java.util.UUID;

public interface DevicesContextFacade {
    void createDevice(Long parkingId, UUID parkingSpotId, String spotStatus, String spotLabel, String edgeServerId);
}
