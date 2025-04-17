package com.smartparking.backend.v1.profile.interfaces.rest.resource;

public record ParkingOwnerResource(
        Long userId,
        Long parkingOwnerId,
        String fullName,
        String city,
        String country,
        String phone,
        String companyName,
        String ruc
) {
}
