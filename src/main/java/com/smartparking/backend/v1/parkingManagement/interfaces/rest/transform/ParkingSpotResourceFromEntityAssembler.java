package com.smartparking.backend.v1.parkingManagement.interfaces.rest.transform;

import com.smartparking.backend.v1.parkingManagement.domain.model.entities.ParkingSpot;
import com.smartparking.backend.v1.parkingManagement.interfaces.rest.resources.ParkingSpotResource;

public class ParkingSpotResourceFromEntityAssembler {
    public static ParkingSpotResource toResourceFromEntity(ParkingSpot entity) {
        return new ParkingSpotResource(
                entity.getId(),
                entity.getParkingId(),
                entity.getRowIndex(),
                entity.getColumnIndex(),
                entity.getLabel(),
                entity.getStatus()
        );
    }
}
