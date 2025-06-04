package com.smartparking.backend.v1.reservations.domain.services;

import com.smartparking.backend.v1.reservations.domain.model.aggregates.Reservation;
import com.smartparking.backend.v1.reservations.domain.model.queries.GetAllReservationsByDriverIdQuery;
import com.smartparking.backend.v1.reservations.domain.model.queries.GetAllReservationsByParkingIdQuery;
import com.smartparking.backend.v1.reservations.domain.model.queries.GetAllReservationsByDriverIdAndStatusQuery;

import java.util.List;

public interface ReservationQueryService {
    List<Reservation> handle(GetAllReservationsByParkingIdQuery query);
    List<Reservation> handle(GetAllReservationsByDriverIdQuery query);
    List<Reservation> handle(GetAllReservationsByDriverIdAndStatusQuery query);
}
