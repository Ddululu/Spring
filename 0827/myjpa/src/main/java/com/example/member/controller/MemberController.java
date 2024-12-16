package com.example.member.controller;

import com.example.member.dto.MemberDTO;
import com.example.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
    private MemberService service;
    @Autowired
    public MemberController(MemberService service) {
        this.service = service;
    }

    @GetMapping("/check")
    public boolean check(@PathVariable String id) {
        return service.check(id);
    }

    @PostMapping("/join")
    public String join(MemberDTO dto) {
        dto.setType("구매자");
        service.add(dto);
        return "redirect:/";
    }
}
