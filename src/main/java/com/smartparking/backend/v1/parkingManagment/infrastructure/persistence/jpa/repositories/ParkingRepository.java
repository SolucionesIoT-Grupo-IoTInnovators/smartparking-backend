package com.smartparking.backend.v1.parkingManagment.infrastructure.persistence.jpa.repositories;

import com.smartparking.backend.v1.parkingManagment.domain.model.aggregates.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {
}
