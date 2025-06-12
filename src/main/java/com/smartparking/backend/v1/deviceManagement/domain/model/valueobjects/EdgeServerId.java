package com.smartparking.backend.v1.deviceManagement.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record EdgeServerId(Long edgeServerId) {
    public EdgeServerId {
        if (edgeServerId == null || edgeServerId <= 0) {
            throw new IllegalArgumentException("EdgeServerId must be a positive number.");
        }
    }
}
