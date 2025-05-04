package com.smartparking.backend.v1.parkingManagement.interfaces.acl;

import java.util.UUID;

public interface ParkingSpotContextFacade {

    Float getParkingRatePerHour(Long parkingId);
    void updateAvailableParkingSpotCount(Long parkingId, Integer numberAvailable, String operation);
    void updateParkingSpotAvailability(Long parkingId, UUID parkingSpotId, String availability);
}
