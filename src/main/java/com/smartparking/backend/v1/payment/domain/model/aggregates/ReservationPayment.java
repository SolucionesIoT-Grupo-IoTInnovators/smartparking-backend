package com.smartparking.backend.v1.payment.domain.model.aggregates;

import com.smartparking.backend.v1.payment.domain.model.commands.CreatePaymentCommand;
import com.smartparking.backend.v1.payment.domain.model.valueobjects.Payment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("RESERVATION")
@NoArgsConstructor
@Getter
public class ReservationPayment extends Payment {

    @Column(name = "reservation_id")
    private Long reservationId;

    public ReservationPayment(CreatePaymentCommand command, Long reservationId) {
        super(command);
        this.reservationId = reservationId;
    }

    @Override
    public boolean isForSubscription() {
        return false;
    }

    @Override
    public boolean isForReservation() {
        return true;
    }
}