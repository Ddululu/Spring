package com.example.market.auth;

import com.example.market.auth.refresh.RefreshTokenRepository;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class JwtTokenProvider {
    Key secret = Keys.hmacShaKeyFor(
            "2afe16a6d630d94cd07c68d5e35568655bf5f60bef29c4f1321fc857816afec9".getBytes(StandardCharsets.UTF_8));// 안전하게 관리해야 함
    @Value("${jwt.access-token.expiration")
    private long accessTokenExpiration; // 15분

    @Autowired
    private RefreshTokenRepository refRepo;

    private Map<String,Object> createHeader(){
        return Map.of("alg","HS256","typ", "JWT");
    }

    public String generateAccessToken(String username) {
        return Jwts.builder()
                .header()
                    .add(createHeader())
                    .and()
                .claims()
                    .subject(username)
                    .expiration(new Date(System.currentTimeMillis() + accessTokenExpiration))
                    .issuedAt(new Date(System.currentTimeMillis())).and()
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            System.out.println("Token expired");
            return false;
        } catch (JwtException | IllegalArgumentException e) {
            System.out.println("Invalid token");
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).build()
                .parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
