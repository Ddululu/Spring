package com.example.security.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
// 인증에 성공했을 때 실행할 핸들러
public class MySuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String loginId = authentication.getName(); // 인증을 통과한 유저의 아이디
        System.out.println("로그인 성공 | 사용자: " +loginId);
        String path="";
        if(authentication.getAuthorities()
                .contains(new SimpleGrantedAuthority("구매자"))) {
            System.out.println("구매자");
            path = "/index_con"; // 구매자 전용 페이지
        }else if(authentication.getAuthorities()
                .contains(new SimpleGrantedAuthority("판매자"))){
            System.out.println("판매자");
            path = "/index_sel";
        }else{
            System.out.println("권한모름");
            path = "/";
        }
        // 최종적으로 path 경로로 forward 이동
        request.getRequestDispatcher(path).forward(request, response);
    }
}
