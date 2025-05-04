package com.smartparking.backend.v1.reservations.infrastructure.persistence.jpa.repositories;

import com.smartparking.backend.v1.reservations.domain.model.aggregates.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findReservationsByParkingIdParkingId(Long parkingId);
    List<Reservation> findReservationsByDriverIdDriverId(Long driverId);
}
