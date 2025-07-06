package com.smartparking.backend.v1.deviceManagement.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record ParkingSpotId(UUID spotId) {
    public ParkingSpotId {
        if (spotId == null) {
            throw new IllegalArgumentException("Parking spot ID cannot be null");
        }
    }
}
