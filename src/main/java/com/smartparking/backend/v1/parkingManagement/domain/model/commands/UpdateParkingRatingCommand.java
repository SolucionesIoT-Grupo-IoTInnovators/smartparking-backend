package com.smartparking.backend.v1.parkingManagement.domain.model.commands;

public record UpdateParkingRatingCommand(Long parkingId, Float rating) {
}
