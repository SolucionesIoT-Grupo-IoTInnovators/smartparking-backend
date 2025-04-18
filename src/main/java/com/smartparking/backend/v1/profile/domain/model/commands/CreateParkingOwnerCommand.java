package com.smartparking.backend.v1.profile.domain.model.commands;

public record CreateParkingOwnerCommand(String fullName, String city, String country,
                                        String phone, String companyName, String ruc) {
}
