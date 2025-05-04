package com.smartparking.backend.v1.reservations.interfaces.rest.transform;

import com.smartparking.backend.v1.reservations.domain.model.commands.CreateReservationCommand;
import com.smartparking.backend.v1.reservations.interfaces.rest.resources.CreateReservationResource;

public class CreateReservationCommandFromResourceAssembler {
    public static CreateReservationCommand toCommandFromResource(CreateReservationResource resource) {
        return new CreateReservationCommand(
                resource.driverId(),
                resource.vehiclePlate(),
                resource.parkingId(),
                resource.parkingSpotId(),
                resource.startTime(),
                resource.endTime()
        );
    }
}
