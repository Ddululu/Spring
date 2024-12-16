package com.example.market.auth.refresh;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByTokenIdAndInvalidatedFalse(String tokenId);
    boolean existsByTokenId(String tokenId);
    void deleteByTokenId(String tokenId); // 토큰 삭제(로그아웃 시)
}
