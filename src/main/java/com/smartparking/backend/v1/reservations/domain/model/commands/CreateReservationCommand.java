package com.smartparking.backend.v1.reservations.domain.model.commands;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public record CreateReservationCommand(
        Long driverId,
        String vehiclePlate,
        Long parkingId,
        UUID parkingSpotId,
        LocalDate date,
        String startTime,
        String endTime
) {
}
