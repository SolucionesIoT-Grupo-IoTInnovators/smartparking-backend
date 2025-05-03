package com.smartparking.backend.v1.parkingManagement.domain.services;

import com.smartparking.backend.v1.parkingManagement.domain.model.aggregates.Parking;
import com.smartparking.backend.v1.parkingManagement.domain.model.commands.AddParkingSpotCommand;
import com.smartparking.backend.v1.parkingManagement.domain.model.commands.CreateParkingCommand;
import com.smartparking.backend.v1.parkingManagement.domain.model.commands.UpdateAvailableParkingSpotCountCommand;
import com.smartparking.backend.v1.parkingManagement.domain.model.commands.UpdateParkingSpotAvailabilityCommand;
import com.smartparking.backend.v1.parkingManagement.domain.model.entities.ParkingSpot;

import java.util.Optional;

public interface ParkingCommandService {

    Optional<Parking> handle(CreateParkingCommand command);

    Optional<ParkingSpot> handle(AddParkingSpotCommand command);

    Optional<String> handle(UpdateParkingSpotAvailabilityCommand command);

    Optional<String> handle(UpdateAvailableParkingSpotCountCommand command);
}
