package com.smartparking.backend.v1.deviceManagement.domain.model.aggregates;

import com.smartparking.backend.v1.deviceManagement.domain.model.commands.CreateEdgeServerCommand;
import com.smartparking.backend.v1.deviceManagement.domain.model.valueobjects.EdgeServerStatus;
import com.smartparking.backend.v1.deviceManagement.domain.model.valueobjects.ParkingId;
import com.smartparking.backend.v1.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
public class EdgeServer extends AuditableAbstractAggregateRoot<EdgeServer> {

    @Getter
    @NotNull
    private String name;

    @Getter
    @NotNull
    private String ipAddress;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private EdgeServerStatus status;

    @Getter
    @Setter
    private LocalDateTime lastHeartbeat;

    @Getter
    @Setter
    private Integer connectedDevicesCount;

    @Embedded
    private ParkingId parkingId;

    protected EdgeServer() {}

    public EdgeServer(CreateEdgeServerCommand command) {
        this.name = command.name();
        this.ipAddress = command.ipAddress();
        this.status = EdgeServerStatus.OFFLINE;
        this.lastHeartbeat = LocalDateTime.now();
        this.connectedDevicesCount = 0;
        this.parkingId = new ParkingId(command.parkingId());
    }

    public String getLastHeartBeat() {
        return this.lastHeartbeat.toString();
    }

    public Long getParkingId() {
        return this.parkingId.parkingId();
    }
}
