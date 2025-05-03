package com.smartparking.backend.v1.parkingManagement.infrastructure.persistence.jpa.repositories;

import com.smartparking.backend.v1.parkingManagement.domain.model.aggregates.Parking;
import com.smartparking.backend.v1.parkingManagement.domain.model.valueobjects.OwnerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {
    List<Parking> findParkingsByOwnerId(OwnerId ownerId);
}
