package com.example.demo.controller;

import com.example.demo.service.CityService;
import com.example.demo.vo.City;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService Service;

    @GetMapping("/info")
    public String info(){
        return "city/info";
    }

    @GetMapping("/detail")
    public String detail(int id, Model model) {
        City city = Service.getCity(id);
        if(city == null) model.addAttribute("msg","없는 아이디");
        else model.addAttribute("city", city);
        System.out.println(city);
        return "city/detail";

    }

    @GetMapping("/add")
    public String add(Model m) {
        ArrayList<String> list = new ArrayList<String>();
        String [] arr= {"ABW", "AFG", "AGO", "AIA", "ALB", "AND", "ANT", "ARE", "ARG", "ARM",
                "ASM", "ATG", "AUS", "AUT", "AZE", "BDI", "BEL", "BEN", "BFA", "BGD", "BGR"};
        list.addAll(Arrays.asList(arr));
        m.addAttribute("list",list);
    return "city/add";
    }

    @PostMapping("/add")
    public String add(City city) { // Model대신 CityVo 객체를 받아 양식에 넣을 수 있다.
        Service.add(city);
        return "index";
    }

    @RequestMapping ("/list")
    public String list(Model m) {
        m.addAttribute("list",Service.getAll());
        return "city/list";
    }

    @PostMapping("/edit")
    public String edit(City city) {
        Service.edit(city);
        return "index";
    }

    @GetMapping("/del")
    public String del(int id) {
        Service.delete(id);
        return "index";
    }
}
