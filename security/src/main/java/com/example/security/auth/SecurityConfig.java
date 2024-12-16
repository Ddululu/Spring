package com.example.security.auth;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic(HttpBasicConfigurer::disable) //기본 설정 disable
                .csrf(CsrfConfigurer::disable) // 쓰기 작업 막은것을 해제, Post, Put 등의 요청 가능
                .cors(Customizer.withDefaults()) // 네트워크 도메인, ip 허용 코드 작성
                .authorizeHttpRequests((authorizeRequests) ->  // 어떤 요청을 허용하고 제한할지 정하는 메서드
                    authorizeRequests
                            .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll() // forward는 모두 허용
                            .requestMatchers("/","join","/autherror","login").permitAll() // 특정 URI는 인증이 없어도 허용
                            .requestMatchers("/auth").authenticated())
                .formLogin((login)->
                        login
                                .permitAll()
                                .loginPage("/loginform") //로그인 폼을 주는 요청 url
                                .loginProcessingUrl("/login") // 로그인 처리 요청 URL (보여줄 URL?, 실제 처리는 여기서 안함)
                                .usernameParameter("id") // Users에서 로그인에 사용되는 ID의 필드 명을 알려줘야 함
                                .passwordParameter("password") // Users의 패스워드 필드명을 알려줘야함
                                .defaultSuccessUrl("/", true)// 로그인에 성공했으면 "/" 로 리다이렉트
                                .successHandler(new MySuccessHandler()) //성공했을때 핸들러
                                .failureHandler(new MyFailureHandler()) //실패했을 때 핸들러
                );
        return http.build();
    }
}
