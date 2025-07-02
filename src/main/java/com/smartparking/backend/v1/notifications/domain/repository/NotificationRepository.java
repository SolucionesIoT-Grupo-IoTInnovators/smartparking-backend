package com.smartparking.backend.v1.notifications.domain.repository;

import com.smartparking.backend.v1.notifications.domain.model.NotificationMessage;

public interface NotificationRepository {
    void send(NotificationMessage message);
}
