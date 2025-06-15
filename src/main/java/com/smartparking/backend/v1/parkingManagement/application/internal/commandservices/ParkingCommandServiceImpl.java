package com.smartparking.backend.v1.parkingManagement.application.internal.commandservices;

import com.smartparking.backend.v1.parkingManagement.application.internal.outboundservices.acl.ExternalDeviceService;
import com.smartparking.backend.v1.parkingManagement.domain.model.aggregates.Parking;
import com.smartparking.backend.v1.parkingManagement.domain.model.commands.*;
import com.smartparking.backend.v1.parkingManagement.domain.model.entities.ParkingSpot;
import com.smartparking.backend.v1.parkingManagement.domain.services.ParkingCommandService;
import com.smartparking.backend.v1.parkingManagement.infrastructure.persistence.jpa.repositories.ParkingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParkingCommandServiceImpl implements ParkingCommandService {

    private final ParkingRepository parkingRepository;
    private final ExternalDeviceService externalDeviceService;

    public ParkingCommandServiceImpl(ParkingRepository parkingRepository, ExternalDeviceService externalDeviceService) {
        this.parkingRepository = parkingRepository;
        this.externalDeviceService = externalDeviceService;
    }

    @Override
    public Optional<Parking> handle(CreateParkingCommand command) {
        var parking = new Parking(command);
        var createdParking = parkingRepository.save(parking);
        return Optional.of(createdParking);
    }

    @Override
    public Optional<ParkingSpot> handle(AddParkingSpotCommand command) {
        var parking = this.parkingRepository.findById(command.parkingId())
                .orElseThrow(() -> new IllegalArgumentException("Parking not found"));

        var spot = parking.addParkingSpot(command);
        var updatedParking = parkingRepository.save(parking);
        // Create a device for the new parking spot
        externalDeviceService.createDevice(command.parkingId(), spot.getId(), spot.getStatus(), spot.getLabel());
        return updatedParking.getParkingSpots().stream()
                .filter(parkingSpot -> parkingSpot.getParkingId().equals(command.parkingId()))
                .findFirst();
    }

    @Override
    public Optional<String> handle(UpdateParkingSpotAvailabilityCommand command) {
        var parking = this.parkingRepository.findById(command.parkingId())
                .orElseThrow(() -> new IllegalArgumentException("Parking not found"));

        var parkingSpot = parking.getParkingSpot(command.parkingSpotId());

        if (parkingSpot == null) {
            throw new IllegalArgumentException("Parking spot not found");
        }

        parkingSpot.updateStatus(command.availability());

        parkingRepository.save(parking);

        return Optional.of("Parking spot with ID " + command.parkingSpotId() + " availability updated to " + command.availability());
    }

    @Override
    public Optional<String> handle(UpdateAvailableParkingSpotCountCommand command) {
        var parking = this.parkingRepository.findById(command.parkingId())
                .orElseThrow(() -> new IllegalArgumentException("Parking not found"));

        parking.updateAvailableSpotsCount(command.numberAvailable(), command.operation());

        parkingRepository.save(parking);

        var newAvailableCount = parking.getAvailableSpots();

        return Optional.of("Available parking spots count updated to " + newAvailableCount);
    }

    @Override
    public Optional<String> handle(UpdateParkingRatingCommand command) {
        var parking = this.parkingRepository.findById(command.parkingId())
                .orElseThrow(() -> new IllegalArgumentException("Parking not found"));

        parking.setRating(command.rating());

        var updatedParking = parkingRepository.save(parking);

        return Optional.of("Parking rating updated to " + updatedParking.getRating());
    }
}
