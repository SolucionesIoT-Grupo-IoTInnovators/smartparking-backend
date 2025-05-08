package com.smartparking.backend.v1.parkingManagement.application.acl;

import com.smartparking.backend.v1.parkingManagement.domain.model.commands.UpdateAvailableParkingSpotCountCommand;
import com.smartparking.backend.v1.parkingManagement.domain.model.commands.UpdateParkingRatingCommand;
import com.smartparking.backend.v1.parkingManagement.domain.model.commands.UpdateParkingRatingCountCommand;
import com.smartparking.backend.v1.parkingManagement.domain.model.commands.UpdateParkingSpotAvailabilityCommand;
import com.smartparking.backend.v1.parkingManagement.domain.model.queries.GetParkingByIdQuery;
import com.smartparking.backend.v1.parkingManagement.domain.services.ParkingCommandService;
import com.smartparking.backend.v1.parkingManagement.domain.services.ParkingQueryService;
import com.smartparking.backend.v1.parkingManagement.interfaces.acl.ParkingSpotContextFacade;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ParkingSpotContextFacadeImpl implements ParkingSpotContextFacade {
    private final ParkingCommandService parkingCommandService;
    private final ParkingQueryService parkingQueryService;

    public ParkingSpotContextFacadeImpl(ParkingCommandService parkingCommandService, ParkingQueryService parkingQueryService) {
        this.parkingCommandService = parkingCommandService;
        this.parkingQueryService = parkingQueryService;
    }

    @Override
    public Float getParkingRatePerHour(Long parkingId) {
        var parking = parkingQueryService.handle(new GetParkingByIdQuery(parkingId));
        if (parking.isEmpty()) {
            throw new IllegalStateException("Parking not found");
        }
        return parking.get().getRatePerHour();
    }

    @Override
    public String getParkingName(Long parkingId) {
        var parking = parkingQueryService.handle(new GetParkingByIdQuery(parkingId));
        if (parking.isEmpty()) {
            throw new IllegalStateException("Parking not found");
        }
        return parking.get().getName();
    }

    @Override
    public void updateAvailableParkingSpotCount(Long parkingId, Integer numberAvailable, String operation) {
        var command = new UpdateAvailableParkingSpotCountCommand(parkingId, numberAvailable, operation);
        var parking = parkingCommandService.handle(command);
        if (parking.isEmpty()) {
            throw new IllegalStateException("Parking not found");
        }
    }

    @Override
    public void updateParkingSpotAvailability(Long parkingId, UUID parkingSpotId, String availability) {
        var command = new UpdateParkingSpotAvailabilityCommand(parkingId, parkingSpotId, availability);
        var parkingSpot = parkingCommandService.handle(command);
        if (parkingSpot.isEmpty()) {
            throw new IllegalStateException("Parking spot not found");
        }
    }

    @Override
    public void updateParkingRating(Long parkingId, Float rating) {
        var command = new UpdateParkingRatingCommand(parkingId, rating);
        var parking = parkingCommandService.handle(command);
        if (parking.isEmpty()) {
            throw new IllegalStateException("Parking not found");
        }
    }

    @Override
    public void updateParkingRatingCount(Long parkingId, Float ratingCount) {
        var command = new UpdateParkingRatingCountCommand(parkingId, ratingCount);
        var parking = parkingCommandService.handle(command);
        if (parking.isEmpty()) {
            throw new IllegalStateException("Parking not found");
        }
    }
}
