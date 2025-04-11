package com.smartparking.backend.v1.parkingManagment.domain.services;

import com.smartparking.backend.v1.parkingManagment.domain.model.aggregates.Parking;
import com.smartparking.backend.v1.parkingManagment.domain.model.commands.AddParkingSpotCommand;
import com.smartparking.backend.v1.parkingManagment.domain.model.commands.CreateParkingCommand;
import com.smartparking.backend.v1.parkingManagment.domain.model.entities.ParkingSpot;

import java.util.Optional;

public interface ParkingCommandService {

    Optional<Parking> handle(CreateParkingCommand command);

    Optional<ParkingSpot> handle(AddParkingSpotCommand command);
}
