package com.example.demo.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemController {
	@Autowired
	private MemService service;
	
	@GetMapping("/join")
	public void joinForm() {
	}

	@PostMapping("/join")
	public String join(MemberDto m) {
		service.saveMem(m);
		return "index";
	}

	@GetMapping("/login")
	public void loginForm() {
	}

	@PostMapping("/login")
	public String login(MemberDto m, HttpSession session, Model model) {
		MemberDto m2 = service.getMem(m.getId());
		if (m2 != null && m2.getPwd().equals(m.getPwd())) {
			session.setAttribute("loginId", m2.getId());
			session.setAttribute("type", m2.getType());
		} else {
			model.addAttribute("msg", "로그인 실패");
		}
		return "index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}

	@ResponseBody
	@GetMapping("/idcheckAjax")
	public Map idcheckAjax(String id) {
		Map map = new HashMap();
		boolean flag = false;
		if (service.getMem(id) == null) {
			flag = true;
		}
		map.put("flag", flag);
		return map;
	}
	
	@GetMapping("/detail")
	public void myinfo(HttpSession session, Model m) {
		m.addAttribute("m", service.getMem((String)session.getAttribute("loginId")));
	}
	
	@PostMapping("/edit")
	public String edit(MemberDto m, HttpSession session) {
		MemberDto m2 = service.saveMem(m);
		session.setAttribute("type", m2.getType());
		return "redirect:/";
	}
	
	@GetMapping("/out")
	public String out(HttpSession session) {
		String loginId = (String)session.getAttribute("loginId");
		service.delMem(loginId);
		return "redirect:/member/logout";
	}
}








