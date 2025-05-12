package com.smartparking.backend.v1.reviews.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ParkingId(Long parkingId) {
    public ParkingId {
        if (parkingId == null || parkingId <= 0) {
            throw new IllegalArgumentException("Parking ID must be a positive number");
        }
    }

    public ParkingId() {
        this(0L);
    }
}
