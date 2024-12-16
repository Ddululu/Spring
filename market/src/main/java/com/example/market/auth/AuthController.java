package com.example.market.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    // Refresh Token을 사용해 Access Token 갱신
//    @PostMapping("/api/refresh-token")
//    public ResponseEntity<?> refreshAccessToken(@RequestParam("refreshToken") String refreshToken) {
//
//        if (newAccessToken != null) {
//            return ResponseEntity.ok(Map.of("accessToken", newAccessToken));
//        } else {
//            return ResponseEntity.status(403).body("Invalid or expired Refresh Token");
//        }
//    }
}