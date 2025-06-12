package com.smartparking.backend.v1.deviceManagement.domain.services;

import com.smartparking.backend.v1.deviceManagement.domain.model.aggregates.EdgeServer;
import com.smartparking.backend.v1.deviceManagement.domain.model.queries.GetEdgeServerByParkingIdQuery;

import java.util.List;

public interface EdgeServerQueryService {
    List<EdgeServer> handle(GetEdgeServerByParkingIdQuery query);
}
