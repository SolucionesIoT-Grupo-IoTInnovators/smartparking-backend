package com.smartparking.backend.v1.parkingManagment.interfaces.rest.transform;

import com.smartparking.backend.v1.parkingManagment.domain.model.entities.ParkingSpot;
import com.smartparking.backend.v1.parkingManagment.interfaces.rest.resources.ParkingSpotResource;

public class ParkingSpotResourceFromEntityAssembler {
    public static ParkingSpotResource toResourceFromEntity(ParkingSpot entity) {
        return new ParkingSpotResource(
                entity.getId(),
                entity.getParkingId(),
                entity.getAvailable(),
                entity.getRowIndex(),
                entity.getColumnIndex(),
                entity.getLabel()
        );
    }
}
