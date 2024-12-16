package com.example.market.config;

import com.example.market.auth.JwtAuthenticationFilter;
import com.example.market.auth.JwtService;
import com.example.market.auth.refresh.RefreshTokenRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.UUID;

@Configuration
@EnableWebSecurity
public class SecurityConfigure {
    @Autowired
    private JwtService jwtService;

    @Autowired
    RefreshTokenRepository refRepo;

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfigure(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain loginFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf)->{csrf.disable();})
            .authorizeRequests((req)->req
                .anyRequest().authenticated())
            .formLogin((login)-> login
                    .loginProcessingUrl("/api/login")
                    .permitAll()
                    .successHandler((request, response, authentication) -> {
                        // 로그인 성공 시 Access Token과 Refresh Token 생성
                        String accessToken = jwtService.createAccessToken(authentication.getName());

                        // Access Token 및 Refresh Token을 응답 헤더에 추가
                        response.setHeader("Authorization", "Bearer " + accessToken);
                        response.setStatus(HttpServletResponse.SC_OK);
                    }))
            .sessionManagement(configurer->configurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();





    }
}
