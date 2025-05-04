package com.smartparking.backend.v1.reservations.interfaces.rest.resources;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateReservationResource(
        Long driverId,
        String vehiclePlate,
        Long parkingId,
        UUID parkingSpotId,
        LocalDateTime startTime,
        LocalDateTime endTime
) {
}
