package com.example.demo.scope;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/scope/")
public class ScopeController {
    @Autowired
    private ScopeService service;

    @GetMapping("/")
    public String main(){return "scope/index";}

    @GetMapping("auth/")
    public String loginForm() {
        return "scope/auth/login";}

    @PostMapping("auth/login")
    public String login(Member m, HttpSession session, Model model) {
        try {
            Member m2 = service.getAccount(m.getId());
            if(m2.getPwd().equals(m.getPwd())) {
                session.setAttribute("loginId", m2.getId());
                session.setAttribute("type", m2.getType());
                session.setAttribute("msg","로그인 성공");
            }
        }catch(Exception e) {
            model.addAttribute("msg", "로그인 실패");
            return "scope/auth/login";
        }
        return "scope/index";
    }

    @GetMapping("auth/join")
    public void joinForm(Member account) {
    }

    @PostMapping("auth/join")
    public String signUp(Member account) {
        service.signUp(account);
        return "scope/auth/login";
    }
//    @GetMapping("auth/idcheck")
//    public String idCheck() {
//        return "scope/auth/idcheck";
//    }
    @GetMapping("auth/check")
    @ResponseBody
    public String idCheck(String id) {
        String msg;
        try{
           service.getAccount(id);
           msg="이미 존재하는 아이디";
        }catch(Exception e){
            msg="사용 가능한 아이디";
        }
        return msg;
    }

    @GetMapping("auth/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "scope/auth/login";
    }







//    /* 로그인 Form으로부터 계정 정보를 받고, 세션 정보를 다루는 메소드*/
//    @PostMapping("/auth/loign")
//    public String login(String id, String pwd, HttpSession session) {;
//
//        System.out.println("세션:" +session);
//        System.out.println("session id: " + session.getId());
//        System.out.println("session Create Time: " + session.getCreationTime() );
//        System.out.println("session Last Access Time: " + session.getLastAccessedTime());
//        System.out.println("session Max Inactive: " + session.getMaxInactiveInterval());
//
//        String msg = "로그인 실패";
//        if(id.equals("aaa") && pwd.equals("111")){
//            /*1) 로그인을 위한 id와 pwd를 파라미터로 전달받는다. form에서도 각각 name="id", name="pwd"여야 한다.
//            * 2) 로그인 성공 시 로그인 정보를 session 객체에 저장한다.
//            * 3) 같은 속성을 요청하면 session 객체를 이용해 대신 입력.*/
//            session.setAttribute("id", id);
//            session.setAttribute("pwd", pwd);
//            msg = "로그인 성공";
//        }
//        return "redirect:scope/index";

}
