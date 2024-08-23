package com.example.demo.controller.test;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/test/param")
public class ParamTestController {



    @GetMapping("/param1")
    public String param1(ModelMap m) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        m.addAttribute("list",list);
        return "test/param/param1";
    }

    @GetMapping("/param2")
    public ModelAndView param2(int num, String name) {
        ModelAndView mav = new ModelAndView("test/param/param2");
        mav.addObject("num", num);
        mav.addObject("name", name);
        return mav;
    }

    @GetMapping("/voidTest")
    public void voidTest(Model m) {
        m.addAttribute("data1", "val1");
        m.addAttribute("data2","val2");
    }

    @GetMapping("/sessionTest")
    public void sessionTest(HttpSession session) { // 연결이 유지되는 것 처럼 보이게 정보를 기억
        session.setAttribute("loginId", "user000"); // 세션에 값을 저장.
        // session은 갯수와 타입에 제한이 없기 때문에 Map처럼 사용 가능.
        // session.invalidate(); // 세션을 제거, 로그아웃 처리
    }
}
