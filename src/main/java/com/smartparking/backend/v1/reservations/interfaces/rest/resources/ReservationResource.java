package com.smartparking.backend.v1.reservations.interfaces.rest.resources;

public record ReservationResource(
        Long id,
        Long driverId,
        String vehiclePlate,
        Long parkingId,
        String parkingSpotId,
        String date,
        String startTime,
        String endTime,
        Float totalPrice,
        String status
) {
}
