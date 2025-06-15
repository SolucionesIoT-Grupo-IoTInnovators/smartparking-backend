package com.smartparking.backend.v1.deviceManagement.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record EdgeServerId(String edgeServerId) {
    public EdgeServerId {
        if (edgeServerId == null) {
            throw new IllegalArgumentException("Edge Server ID cannot be null");
        }
    }
    public EdgeServerId() {
        this("");
    }
}
