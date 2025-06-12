package com.smartparking.backend.v1.deviceManagement.infrastructure.persistence.jpa.repositories;

import com.smartparking.backend.v1.deviceManagement.domain.model.aggregates.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    Optional<Device> findByParkingSpotIdSpotId(UUID parkingSpotIdSpotId);
    List<Device> findByEdgeServerIdEdgeServerId(Long edgeServerId);
}
