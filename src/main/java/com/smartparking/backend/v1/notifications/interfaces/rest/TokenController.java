package com.smartparking.backend.v1.notifications.interfaces.rest;

import com.smartparking.backend.v1.notifications.domain.model.FcmToken;
import com.smartparking.backend.v1.notifications.domain.repository.FcmTokenRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notifications")
public class TokenController {

    private final FcmTokenRepository fcmTokenRepository;

    public TokenController(FcmTokenRepository fcmTokenRepository) {
        this.fcmTokenRepository = fcmTokenRepository;
    }

    @PostMapping("/register-token")
    public ResponseEntity<Void> registerToken(@RequestParam Long userId, @RequestParam String token) {
        FcmToken entity = new FcmToken();
        entity.setUserId(userId);
        entity.setToken(token);
        fcmTokenRepository.save(entity);
        return ResponseEntity.ok().build();
    }
}
