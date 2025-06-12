package com.smartparking.backend.v1.deviceManagement.domain.services;

import com.smartparking.backend.v1.deviceManagement.domain.model.aggregates.Device;
import com.smartparking.backend.v1.deviceManagement.domain.model.queries.GetDeviceByParkingSpotIdQuery;
import com.smartparking.backend.v1.deviceManagement.domain.model.queries.GetDevicesByEdgeServerIdQuery;

import java.util.List;
import java.util.Optional;

public interface DeviceQueryService {
    Optional<Device> handle(GetDeviceByParkingSpotIdQuery query);
    List<Device> handle(GetDevicesByEdgeServerIdQuery query);
}
