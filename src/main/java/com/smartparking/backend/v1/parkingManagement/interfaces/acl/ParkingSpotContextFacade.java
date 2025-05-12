package com.smartparking.backend.v1.parkingManagement.interfaces.acl;

import java.util.UUID;

public interface ParkingSpotContextFacade {

    Float getParkingRatePerHour(Long parkingId);
    String getParkingName(Long parkingId);
    void updateAvailableParkingSpotCount(Long parkingId, Integer numberAvailable, String operation);
    void updateParkingSpotAvailability(Long parkingId, UUID parkingSpotId, String availability);
    void updateParkingRating(Long parkingId, Float rating);
}
