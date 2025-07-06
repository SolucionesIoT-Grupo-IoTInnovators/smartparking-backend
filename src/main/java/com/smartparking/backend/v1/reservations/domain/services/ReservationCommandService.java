package com.smartparking.backend.v1.reservations.domain.services;

import com.smartparking.backend.v1.reservations.domain.model.aggregates.Reservation;
import com.smartparking.backend.v1.reservations.domain.model.commands.CreateReservationCommand;
import com.smartparking.backend.v1.reservations.domain.model.commands.UpdateReservationStatusCommand;

import java.io.IOException;
import java.util.Optional;

public interface ReservationCommandService {
    Optional<Reservation> handle(CreateReservationCommand command) throws IOException;
    Optional<Reservation> handle(UpdateReservationStatusCommand command) throws IOException;
}
