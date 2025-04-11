package com.smartparking.backend.v1.parkingManagment.domain.model.commands;

public record AddParkingSpotCommand(
        Integer row,
        Integer column,
        String label,
        Long parkingId
) {
}
