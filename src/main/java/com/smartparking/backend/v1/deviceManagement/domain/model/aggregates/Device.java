package com.smartparking.backend.v1.deviceManagement.domain.model.aggregates;

import com.smartparking.backend.v1.deviceManagement.domain.model.commands.CreateDeviceCommand;
import com.smartparking.backend.v1.deviceManagement.domain.model.valueobjects.DeviceStatus;
import com.smartparking.backend.v1.deviceManagement.domain.model.valueobjects.DeviceType;
import com.smartparking.backend.v1.deviceManagement.domain.model.valueobjects.EdgeServerId;
import com.smartparking.backend.v1.deviceManagement.domain.model.valueobjects.ParkingSpotId;
import com.smartparking.backend.v1.deviceManagement.domain.model.valueobjects.SpotStatus;
import com.smartparking.backend.v1.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
public class Device extends AuditableAbstractAggregateRoot<Device> {

    @Getter
    @NotNull
    @Column(unique = true)
    private String macAddress;

    @NotNull
    @Enumerated(EnumType.STRING)
    private DeviceType type;

    @NotNull
    @Enumerated(EnumType.STRING)
    private DeviceStatus operationalStatus;

    @NotNull
    @Enumerated(EnumType.STRING)
    private SpotStatus spotStatus;

    @Setter
    private LocalDateTime lastCommunication;

    @Embedded
    private ParkingSpotId parkingSpotId;

    @Embedded
    private EdgeServerId edgeServerId;

    protected Device() {}

    public Device(CreateDeviceCommand command) {
        this.macAddress = command.macAddress();
        this.type = command.type();
        this.operationalStatus = DeviceStatus.ONLINE;
        this.spotStatus = SpotStatus.AVAILABLE;
        this.lastCommunication = LocalDateTime.now();
        this.parkingSpotId = new ParkingSpotId(command.parkingSpotId());
        this.edgeServerId = new EdgeServerId(command.edgeServerId());
    }

    public String getType() {
        return type.name();
    }

    public String getOperationalStatus() {
        return operationalStatus.name();
    }

    public String getSpotStatus() {
        return spotStatus.name();
    }

    public String getLastCommunication() {
        return lastCommunication.toString();
    }

    public String parkingSpotId() {
        return parkingSpotId.spotId().toString();
    }

    public Long edgeServerId() {
        return edgeServerId.edgeServerId();
    }
}
