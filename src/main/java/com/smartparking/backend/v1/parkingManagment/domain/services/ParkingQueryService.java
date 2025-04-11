package com.smartparking.backend.v1.parkingManagment.domain.services;

import com.smartparking.backend.v1.parkingManagment.domain.model.aggregates.Parking;
import com.smartparking.backend.v1.parkingManagment.domain.model.entities.ParkingSpot;
import com.smartparking.backend.v1.parkingManagment.domain.model.queries.GetParkingByIdQuery;
import com.smartparking.backend.v1.parkingManagment.domain.model.queries.GetParkingSpotByIdQuery;
import com.smartparking.backend.v1.parkingManagment.domain.model.queries.GetParkingSpotsByParkingIdQuery;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ParkingQueryService {

    Optional<Parking> handle(GetParkingByIdQuery query);

    List<ParkingSpot> handle(GetParkingSpotsByParkingIdQuery query);
    Optional<ParkingSpot> handle(GetParkingSpotByIdQuery query);
}