package com.example.demo.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemController {
	@Autowired
	private MemberService service;

	@GetMapping("/join")
	public void joinForm() {
	}

	@PostMapping("/join")
	public String join(MemberDto m) {
		service.save(m);
		return "redirect:/index.jsp";
	}

	@GetMapping("/login")
	public void loginForm() {
	}

	@PostMapping("/login")
	public String login(MemberDto m, HttpSession session) {
		String msg = "로그인 실패";
		MemberDto m2 = service.getMember(m.getId());
		if (m2 != null && m2.getPwd().equals(m.getPwd())) { // 로그인 성공
			session.setAttribute("loginId", m2.getId());
			session.setAttribute("type", m2.getType());
			msg = "로그인 성공";
		}
		session.setAttribute("msg", msg);
		return "index";
	}


	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}

	@RequestMapping("/out")
	public String out(String id) {
		service.delMember(id);
		return "redirect:/member/logout";
	}

	@GetMapping("/edit")
	public ModelAndView editForm(String id) {
		MemberDto m = service.getMember(id);
		ModelAndView mav = new ModelAndView("member/edit");
		mav.addObject("m", m);
		return mav;
	}

	@PostMapping("/edit")
	public String edit(MemberDto m) {
		service.save(m);
		return "redirect:/index.jsp";
	}

	@ResponseBody // 응답 내용을 바로 반환
	@GetMapping("/idcheck")
	public Map idcheck(String id) {
		Map map = new HashMap();
		MemberDto m = service.getMember(id);
		boolean flag = false;
		if (m == null) {
			flag = true;
		}
		map.put("flag", flag);
		return map;
	}
}
