package com.smartparking.backend.v1.parkingManagement.application.internal.outboundservices.acl;

import com.smartparking.backend.v1.deviceManagement.interfaces.acl.DevicesContextFacade;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExternalDeviceService {
    private final DevicesContextFacade devicesContextFacade;

    public ExternalDeviceService(DevicesContextFacade devicesContextFacade) {
        this.devicesContextFacade = devicesContextFacade;
    }

    public void createDevice(Long parkingId, UUID parkingSpotId, String spotStatus, String spotLabel) {
        this.devicesContextFacade.createDevice(parkingId, parkingSpotId, spotStatus, spotLabel);
    }
}
