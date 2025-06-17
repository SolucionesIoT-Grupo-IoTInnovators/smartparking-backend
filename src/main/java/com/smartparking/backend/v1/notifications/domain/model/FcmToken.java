package com.smartparking.backend.v1.notifications.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FcmToken {
    @Id
    private Long userId; // o userId
    private String token;
}
