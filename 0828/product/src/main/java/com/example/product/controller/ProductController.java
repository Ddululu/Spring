package com.example.product.controller;

import com.example.product.data.dto.ProductDTO;
import com.example.product.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService service;
    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public void addForm() {
    }

    @PostMapping("/add")
    public String add(ProductDTO dto) {
        service.productAdd(dto);
        return "redirect:/prod/list";
    }

    @RequestMapping("/list")
    public void list(Model m, HttpSession session) {
        String type = (String) session.getAttribute("type");
        String loginId = (String) session.getAttribute("loginId");
        List<ProductDTO> list = null;
        if (type.equals("판매자")) {
            list = service.getBySeller(loginId);
        } else {
            list = service.getAll();
        }
        m.addAttribute("list", list);
    }
}
