package com.smartparking.backend.v1.reservations.domain.model.aggregates;

import com.smartparking.backend.v1.reservations.domain.model.commands.CreateReservationCommand;
import com.smartparking.backend.v1.reservations.domain.model.valueobjects.DriverId;
import com.smartparking.backend.v1.reservations.domain.model.valueobjects.ParkingId;
import com.smartparking.backend.v1.reservations.domain.model.valueobjects.ParkingSpotId;
import com.smartparking.backend.v1.reservations.domain.model.valueobjects.ReservationStatus;
import com.smartparking.backend.v1.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
public class Reservation extends AuditableAbstractAggregateRoot<Reservation> {

    @Embedded
    private DriverId driverId;

    @Getter
    @NotNull
    private String vehiclePlate;

    @Embedded
    private ParkingId parkingId;

    @Embedded
    private ParkingSpotId parkingSpotId;

    @Getter
    private LocalDateTime startTime;

    @Getter
    private LocalDateTime endTime;

    @Getter
    private Float totalPrice;

    @Embedded
    private ReservationStatus status;

    protected Reservation() {}

    public Reservation(CreateReservationCommand command, Float pricePerHour) {
        this.driverId = new DriverId(command.driverId());
        this.vehiclePlate = command.vehiclePlate();
        this.parkingId = new ParkingId(command.parkingId());
        this.parkingSpotId = new ParkingSpotId(command.parkingSpotId());
        this.startTime = command.startTime();
        this.endTime = command.endTime();
        this.totalPrice = calculateTotalPrice(pricePerHour);
        this.status = ReservationStatus.PENDING;
    }

    private Float calculateTotalPrice(Float pricePerHour) {
        long hours = java.time.Duration.between(startTime, endTime).toHours();
        return hours * pricePerHour;
    }

    public void confirm() {
        this.status = ReservationStatus.CONFIRMED;
    }

    public void cancel() {
        this.status = ReservationStatus.CANCELED;
    }

    public void complete() {
        this.status = ReservationStatus.COMPLETED;
    }

    public Long getDriverId() {
        return driverId.driverId();
    }

    public Long getParkingId() {
        return parkingId.parkingId();
    }

    public String getParkingSpotId() {
        return parkingSpotId.parkingSpotId().toString();
    }

    public String getStatus() {
        return status.name();
    }
}
