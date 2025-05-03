package com.smartparking.backend.v1.parkingManagement.interfaces.rest.transform;

import com.smartparking.backend.v1.parkingManagement.domain.model.commands.CreateParkingCommand;
import com.smartparking.backend.v1.parkingManagement.interfaces.rest.resources.CreateParkingResource;

public class CreateParkingCommandFromResourceAssembler {
    public static CreateParkingCommand toCommandFromResource(CreateParkingResource resource) {
        return new CreateParkingCommand(
                resource.ownerId(),
                resource.name(),
                resource.description(),
                resource.address(),
                resource.lat(),
                resource.lng(),
                resource.ratePerHour(),
                resource.totalSpots(),
                resource.availableSpots(),
                resource.totalRows(),
                resource.totalColumns(),
                resource.imageUrl()
        );
    }
}
