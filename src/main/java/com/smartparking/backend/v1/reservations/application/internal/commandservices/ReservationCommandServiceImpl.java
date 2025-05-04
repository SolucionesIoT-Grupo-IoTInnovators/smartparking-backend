package com.smartparking.backend.v1.reservations.application.internal.commandservices;

import com.smartparking.backend.v1.reservations.application.internal.outboundservices.acl.ExternalParkingService;
import com.smartparking.backend.v1.reservations.domain.model.aggregates.Reservation;
import com.smartparking.backend.v1.reservations.domain.model.commands.CreateReservationCommand;
import com.smartparking.backend.v1.reservations.domain.services.ReservationCommandService;
import com.smartparking.backend.v1.reservations.infrastructure.persistence.jpa.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationCommandServiceImpl implements ReservationCommandService {
    private final ReservationRepository reservationRepository;
    private final ExternalParkingService externalParkingService;

    public ReservationCommandServiceImpl(ReservationRepository reservationRepository, ExternalParkingService externalParkingService) {
        this.reservationRepository = reservationRepository;
        this.externalParkingService = externalParkingService;
    }

    @Override
    public Optional<Reservation> handle(CreateReservationCommand command) {
        var parkingRatePerHour = externalParkingService.getParkingRatePerHour(command.parkingId());
        if (parkingRatePerHour == null) {
            return Optional.empty();
        }
        var reservation = new Reservation(command, parkingRatePerHour);
        var savedReservation = reservationRepository.save(reservation);
        externalParkingService.updateParkingSpotAvailability(command.parkingId(), command.parkingSpotId(), "RESERVED");
        externalParkingService.updateAvailableSpotsCount(command.parkingId(), 1, "subtract");
        return Optional.of(savedReservation);
    }
}
