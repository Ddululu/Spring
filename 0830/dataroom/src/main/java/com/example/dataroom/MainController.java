package com.example.dataroom;

import com.example.dataroom.member.MemService;
import com.example.dataroom.member.MemberDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.HttpCookie;

@Controller
public class MainController {
    @Autowired
    MemService service;
    @GetMapping("/")
    public String index() {

        return "/login/index.html";

    }


    @GetMapping("/logout")
    public String logout(HttpCookie cookie) {
        cookie.hasExpired();
        return "redirect:/index.html";
    }
}
