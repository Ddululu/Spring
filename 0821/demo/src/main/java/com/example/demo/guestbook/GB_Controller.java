package com.example.demo.guestbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/guest")
public class GB_Controller {
    @Autowired
    private GB_Service service;

    @RequestMapping("/")
    public String mainpage(Model m) {
        m.addAttribute("list",service.getAllBooks());
        System.out.println(service.getAllBooks());
        return "/guest/index";
    }

    @GetMapping("/add")
    public void addBook() {}

    @PostMapping("/add")
    public String add(GB_VO vo){
        service.addBook(vo);
        return "redirect:/guest/";
    }

    @GetMapping("/detail")
    public void detail(int index, Model m) {
        m.addAttribute("book",service.getBook(index));
    }

    @GetMapping("/edit")
    public String edit(GB_VO vo) {
        service.editBook(vo);
        return "redirect:/guest/";
    }

    @GetMapping("/del")
    public String del(int index) {
        service.delBook(index);
        return "redirect:/guest/";
    }
}
