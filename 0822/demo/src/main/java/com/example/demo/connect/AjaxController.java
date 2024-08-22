package com.example.demo.connect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/ajax/")
public class AjaxController {
    // ResponseBody는 웹 페이지가 아니라 데이터를 리턴한다.
    @ResponseBody
    @GetMapping("/test1")
    public String test1(int num, String name){
        // 파라미터로 받은 num과 name을 문자열에 담아 리턴
        return "hello ajax / num" +num+ "/ Name:"+ name;}

    @GetMapping("/view1")
    public String view1(){
        return "/ajax/view1";
    }

    @PostMapping("/test2")
    @ResponseBody
    public String test2(int num, String name){
        return "ajax Post / num" +num+ "/ Name:"+ name;
    }

    @PostMapping("/test3")
    @ResponseBody
    public Map<String, Object> test3(int num, String name){
        Map<String, Object> map = new HashMap<>();
        map.put("num", num);
        map.put("name", name);
        return map;
    }
    @PostMapping("/test4")
    @ResponseBody
    public Set<String> test4(String num, String name){
        Set<String> list = new HashSet<>();
        list.add(name);
        list.add(num);
        return list;
    }
}
