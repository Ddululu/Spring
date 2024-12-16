package com.example.market.auth;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider, UserDetailsService userDetailsService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // 1. Authorization 헤더에서 JWT 추출
        String header = request.getHeader("Authorization");
        String token = null;
        String username = null;

        if (header != null && header.startsWith("Bearer ")) {
            token = header.substring(7); // "Bearer " 이후의 토큰만 추출
            try {
                // 2. JWT에서 사용자 이름 추출
                username = jwtTokenProvider.getUsernameFromToken(token);
            } catch (Exception e) {
                System.out.println("JWT token extraction failed: " + e.getMessage());
            }
        }

        // 3. JWT가 유효하고 인증되지 않은 상태이면 인증 처리
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // UserDetailsService를 통해 사용자 정보 로드
            var userDetails = this.userDetailsService.loadUserByUsername(username);

            if (jwtTokenProvider.validateToken(token)) {
                // 4. 토큰이 유효하면 인증 객체 생성 후 SecurityContext에 설정
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // Spring Security의 SecurityContext에 인증 정보 설정
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        // 5. 체인의 다음 필터 실행
        filterChain.doFilter(request, response);
    }
}