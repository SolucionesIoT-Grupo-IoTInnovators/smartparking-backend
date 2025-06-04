package com.smartparking.backend.v1.payment.infrastructure.persistence.jpa.repositories;

import com.smartparking.backend.v1.payment.domain.model.aggregates.ReservationPayment;
import com.smartparking.backend.v1.payment.domain.model.valueobjects.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
