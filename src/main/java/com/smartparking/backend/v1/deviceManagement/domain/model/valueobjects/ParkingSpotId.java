package com.smartparking.backend.v1.deviceManagement.domain.model.valueobjects;
import java.util.UUID;

import jakarta.persistence.Embeddable;

@Embeddable
public record ParkingSpotId(UUID spotId) {
    public ParkingSpotId {
        if (spotId == null) {
            throw new IllegalArgumentException("Parking spot ID cannot be null");
        }
    }
}
