package com.example.demo.controller.test;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test/cookie")
public class CookieTestController {
    @GetMapping("/")
    public String Main(){return "test/cookie/index";}

    @GetMapping("/index")
    public void index(){}

    @GetMapping("/add")
    public String add(int num, String name, HttpServletResponse response) {
        Cookie c1 = new Cookie("num",num+""); // jakarta.servelt.http.Cookie 클래스 사용
        Cookie c2 = new Cookie("name",name);

        response.addCookie(c1);
        response.addCookie(c2);

        return "/test/cookie/index";
    }
    @GetMapping("/list")
    public String list(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies) {
            System.out.println("num : " +cookie.getName()+ "value : "+cookie.getValue());
        }
        return "test/cookie/index";
    }
}
