package com.smartparking.backend.v1.reservations.interfaces.rest.transform;

import com.smartparking.backend.v1.reservations.domain.model.commands.UpdateReservationStatusCommand;

public class UpdateReservationCommandFromResourceAssembler {
    public static UpdateReservationStatusCommand toCommandFromResource(Long reservationId, String status) {
        return new UpdateReservationStatusCommand(reservationId, status);
    }
}
