package com.smartparking.backend.v1.parkingManagement.interfaces.rest.resources;

public record AddParkingSpotResource(
        Integer row,
        Integer column,
        String label
) {
}
