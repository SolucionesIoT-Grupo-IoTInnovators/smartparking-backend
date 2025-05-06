package com.smartparking.backend.v1.reservations.interfaces.rest.transform;

import com.smartparking.backend.v1.reservations.domain.model.aggregates.Reservation;
import com.smartparking.backend.v1.reservations.interfaces.rest.resources.ReservationResource;

public class ReservationResourceFromEntityAssembler {
    public static ReservationResource toResourceFromEntity(Reservation entity) {
        return new ReservationResource(
                entity.getId(),
                entity.getDriverId(),
                entity.getVehiclePlate(),
                entity.getParkingId(),
                entity.getParkingSpotId(),
                entity.getDate().toString(),
                entity.getStartTime().toString(),
                entity.getEndTime().toString(),
                entity.getTotalPrice(),
                entity.getStatus()
        );
    }
}
