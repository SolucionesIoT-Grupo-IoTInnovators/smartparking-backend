package com.smartparking.backend.v1.parkingManagement.interfaces.rest.resources;

public record ParkingResource(
        Long id,
        Long ownerId,
        String name,
        String description,
        String address,
        Double lat,
        Double lng,
        Float ratePerHour,
        Float rating,
        Integer totalSpots,
        Integer availableSpots,
        Integer totalRows,
        Integer totalColumns,
        String imageUrl
) {
}