package com.smartparking.backend.v1.parkingManagment.interfaces.rest.transform;

import com.smartparking.backend.v1.parkingManagment.domain.model.aggregates.Parking;
import com.smartparking.backend.v1.parkingManagment.interfaces.rest.resources.ParkingResource;

public class ParkingResourceFromEntityAssembler {
    public static ParkingResource toResourceFromEntity(Parking entity) {
        return new ParkingResource(
                entity.getId(),
                entity.getOwnerId(),
                entity.getName(),
                entity.getDescription(),
                entity.getAddress(),
                entity.getLat(),
                entity.getLng(),
                entity.getRatePerHour(),
                entity.getRating(),
                entity.getTotalSpots(),
                entity.getAvailableSpots(),
                entity.getTotalRows(),
                entity.getTotalColumns(),
                entity.getImageUrl()
        );
    }
}
