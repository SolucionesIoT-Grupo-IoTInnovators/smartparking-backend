package com.smartparking.backend.v1.deviceManagement.domain.services;

import com.smartparking.backend.v1.deviceManagement.domain.model.aggregates.Device;
import com.smartparking.backend.v1.deviceManagement.domain.model.queries.GetDeviceByParkingSpotIdQuery;
import com.smartparking.backend.v1.deviceManagement.domain.model.queries.GetDevicesByEdgeServerIdQuery;
import com.smartparking.backend.v1.deviceManagement.domain.model.queries.GetDevicesByParkingIdQuery;
import com.smartparking.backend.v1.deviceManagement.domain.model.queries.GetUnassignedDevicesByParkingIdQuery;

import java.util.List;
import java.util.Optional;

public interface DeviceQueryService {
    List<Device> handle(GetDevicesByParkingIdQuery query);
    Optional<Device> handle(GetDeviceByParkingSpotIdQuery query);
    List<Device> handle(GetUnassignedDevicesByParkingIdQuery query);
    List<Device> handle(GetDevicesByEdgeServerIdQuery query);
}
