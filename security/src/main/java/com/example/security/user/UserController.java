package com.example.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(){
        return "index";
    }
    @GetMapping("/join")
    public String joinForm(){
        return "member/join";
    }
    @PostMapping("/join")
    public String join(UserDto user){
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/loginform")
    public String loginForm(){
        return "member/login";
    }

    @RequestMapping("/autherror")
    public String error(){
        return "error";
    }

}
