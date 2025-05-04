package com.smartparking.backend.v1.reservations.domain.model.commands;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateReservationCommand(
        Long driverId,
        String vehiclePlate,
        Long parkingId,
        UUID parkingSpotId,
        LocalDateTime startTime,
        LocalDateTime endTime
) {
    public CreateReservationCommand {
        if (startTime.isAfter(endTime)) {
            throw new IllegalArgumentException("Start time must be before end time");
        }
    }
}
