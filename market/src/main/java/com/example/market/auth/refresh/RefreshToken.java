package com.example.market.auth.refresh;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username; // 사용자명
    @Column(nullable = false, unique = true)
    private String tokenId; // Refresh Token의 jti
    private String userAgent; // 사용자 에이전트
    private String ipAddress; // IP 주소
    private LocalDateTime issuedAt; // 발급 시간
    private LocalDateTime expiresAt; // 만료 시간

    private boolean invalidated; // 토큰이 무효화되었는지 여부

    // 기본 생성자, getter, setter 생략
}
