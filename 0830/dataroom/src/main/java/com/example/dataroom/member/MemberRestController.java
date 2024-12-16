package com.example.dataroom.member;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@CrossOrigin("*") // 모든 IP에서 Rest API 요청을 받는다 -> 원래는 서버와 소통하는 용도기 때문에 지정된 ip만 허용
@RequestMapping("/api/member")
public class MemberRestController {
    private MemService service;
    @Autowired
    public MemberRestController(MemService service) {this.service = service;}

    @GetMapping("/join")
    public ResponseEntity<MemberDto> join(@RequestParam String id) {
        MemberDto mem = service.getMem(id);
        Optional.of(mem).orElseThrow(EntityNotFoundException::new);
        return new ResponseEntity<>(mem, HttpStatus.OK);
    }

    // 멤버를 추가
    @PostMapping("/join")
    @ResponseBody
    public ResponseEntity Join(@RequestBody MemberDto member) {
        MemberDto m2 = service.saveMem(member);
        Map<String,Object> map = new HashMap<>();
        map.put("member",m2);
        return new ResponseEntity(map, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<MemberDto> get(MemberDto m, HttpSession session) {
        MemberDto m2 = service.getMem(m.getId());
        if (m2 != null && m2.getPwd().equals(m.getPwd())) {
            session.setAttribute("loginId", m2.getId());
        }
        return ResponseEntity.ok(m2);
    }




}
