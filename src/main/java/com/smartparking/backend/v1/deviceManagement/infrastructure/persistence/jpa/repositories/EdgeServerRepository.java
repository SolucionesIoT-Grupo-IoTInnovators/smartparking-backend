package com.smartparking.backend.v1.deviceManagement.infrastructure.persistence.jpa.repositories;

import com.smartparking.backend.v1.deviceManagement.domain.model.aggregates.EdgeServer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EdgeServerRepository extends JpaRepository<EdgeServer, Long> {
    List<EdgeServer> findByParkingIdParkingId(Long parkingId);
}
