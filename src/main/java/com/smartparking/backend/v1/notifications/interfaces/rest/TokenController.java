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
        fcmTokenRepository.findByToken(token).ifPresentOrElse(existing -> {
            if (!existing.getUserId().equals(userId)) {
                existing.setUserId(userId);
                fcmTokenRepository.save(existing);
            }
        }, () -> {
            FcmToken newToken = new FcmToken();
            newToken.setUserId(userId);
            newToken.setToken(token);
            fcmTokenRepository.save(newToken);
        });

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/unregister-token")
    public ResponseEntity<Void> unregisterToken(@RequestParam String token) {
        fcmTokenRepository.deleteByToken(token);
        return ResponseEntity.ok().build();
    }
}
