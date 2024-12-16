package com.example.demo.product;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/prod")
public class ProdController {
	@Autowired
	private ProductService service;

	@GetMapping("/add")
	public void addForm() {
	}

	@PostMapping("/add")
	public String add(ProductDto dto) {
		service.saveProd(dto);
		return "redirect:/prod/list";
	}

	@RequestMapping("/list")
	public void list(Model m, HttpSession session) {
		String type = (String) session.getAttribute("type");
		String loginId = (String) session.getAttribute("loginId");
		ArrayList<ProductDto> list = null;
		if (type.equals("판매자")) {
			list = service.getBySeller(loginId);
		} else {
			list = service.getAll();
		}
		m.addAttribute("list", list);
	}

}
