package com.smartparking.backend.v1.notifications.domain.repository;

import com.smartparking.backend.v1.notifications.domain.model.FcmToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FcmTokenRepository extends JpaRepository<FcmToken, String> {
    Optional<FcmToken> findByUserId(Long userId);
}
