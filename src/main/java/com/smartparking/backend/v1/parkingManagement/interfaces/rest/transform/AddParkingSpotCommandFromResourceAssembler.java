package com.smartparking.backend.v1.parkingManagement.interfaces.rest.transform;

import com.smartparking.backend.v1.parkingManagement.domain.model.commands.AddParkingSpotCommand;
import com.smartparking.backend.v1.parkingManagement.interfaces.rest.resources.AddParkingSpotResource;

public class AddParkingSpotCommandFromResourceAssembler {
    public static AddParkingSpotCommand toCommandFromResource(AddParkingSpotResource resource, Long parkingId) {
        return new AddParkingSpotCommand(
                resource.row(),
                resource.column(),
                resource.label(),
                parkingId
        );
    }
}