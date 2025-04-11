package com.smartparking.backend.v1.parkingManagment.application.internal.queryservices;

import com.smartparking.backend.v1.parkingManagment.domain.model.aggregates.Parking;
import com.smartparking.backend.v1.parkingManagment.domain.model.entities.ParkingSpot;
import com.smartparking.backend.v1.parkingManagment.domain.model.queries.GetParkingByIdQuery;
import com.smartparking.backend.v1.parkingManagment.domain.model.queries.GetParkingSpotByIdQuery;
import com.smartparking.backend.v1.parkingManagment.domain.model.queries.GetParkingSpotsByParkingIdQuery;
import com.smartparking.backend.v1.parkingManagment.domain.services.ParkingQueryService;
import com.smartparking.backend.v1.parkingManagment.infrastructure.persistence.jpa.repositories.ParkingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingQueryServiceImpl implements ParkingQueryService {

    private final ParkingRepository parkingRepository;

    public ParkingQueryServiceImpl(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }


    @Override
    public Optional<Parking> handle(GetParkingByIdQuery query) {
        return this.parkingRepository.findById(query.parkingId());
    }

    @Override
    public List<ParkingSpot> handle(GetParkingSpotsByParkingIdQuery query) {
        var parking = this.parkingRepository.findById(query.parkingId());
        if (parking.isPresent()) {
            return parking.get().getParkingSpots();
        }
        return List.of();
    }

    @Override
    public Optional<ParkingSpot> handle(GetParkingSpotByIdQuery query) {
        var parking = this.parkingRepository.findById(query.parkingId());
        return parking.flatMap(value -> value.getParkingSpots().stream()
                .filter(parkingSpot -> parkingSpot.getId().equals(query.parkingSpotId()))
                .findFirst());
    }
}
