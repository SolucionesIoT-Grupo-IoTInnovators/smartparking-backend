package com.smartparking.backend.v1.reviews.application.internal.outboundservices.acl;

import com.smartparking.backend.v1.parkingManagement.interfaces.acl.ParkingSpotContextFacade;

public class ExternalParkingService {
    private final ParkingSpotContextFacade parkingSpotContextFacade;

    public ExternalParkingService(ParkingSpotContextFacade parkingSpotContextFacade) {
        this.parkingSpotContextFacade = parkingSpotContextFacade;
    }

    public String getParkingName(Long parkingId) {
        return parkingSpotContextFacade.getParkingName(parkingId);
    }

    public void updateParkingRating(Long parkingId, Float rating) {
        parkingSpotContextFacade.updateParkingRating(parkingId, rating);
    }

    public void updateParkingRatingCount(Long parkingId, Float ratingCount) {
        parkingSpotContextFacade.updateParkingRatingCount(parkingId, ratingCount);
    }
}
