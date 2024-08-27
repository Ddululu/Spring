package com.example.demo.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
    @GetMapping("/")
    public String Main() {return "/test/index";}
    @GetMapping("test/index")
    public void home(){}
}
