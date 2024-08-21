package com.example.guestbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GB_Controller {
    @Autowired
    private GB_Service service;

    @GetMapping("/")
    public String mainpage(Model m) {
        m.addAttribute("list",service.getAllBooks());
        System.out.println(service.getAllBooks());
        return "index";
    }
}
