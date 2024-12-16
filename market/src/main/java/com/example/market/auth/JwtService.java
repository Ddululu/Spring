package com.example.market.auth;

import org.springframework.stereotype.Service;

@Service
public class JwtService {
    private final JwtTokenProvider jwtTokenProvider;

    public JwtService(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public String createAccessToken(String username) {
        return jwtTokenProvider.generateAccessToken(username); // Access Token 생성
    }
}