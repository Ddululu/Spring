package com.example.myjpa.controller;

import com.example.myjpa.dto.GuestbookDTO;
import com.example.myjpa.service.GuestbookService;
import com.example.myjpa.vo.Guestbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class GuestbookController {
    @Autowired
    private GuestbookService service;

    @RequestMapping("/list")
    public void list(Model model) {
        model.addAttribute("list", service.getAll());
    }

    @GetMapping("/add")
    public void addForm() {}

    @PostMapping("/add")
    public String add(GuestbookDTO dto) {
        service.addBook(dto);
        return "redirect:/board/list";
    }

    @ResponseBody
    @GetMapping("/getBook")
    public Map getBook(int num) {
        System.out.println(num);
        Guestbook vo = service.getBook(num);
        Map map = new HashMap();
        map.put("num", vo.getNum());
        map.put("writer", vo.getWriter());
        map.put("wdate", vo.getDate()+"");
        map.put("content", vo.getContent());
        return map;
    }

    @GetMapping("/detail")
    public void detail(int num, Model model)
    {
        model.addAttribute("board", service.getBook(num));
    }

    @PostMapping("/edit")
    public String edit(@RequestParam  int id, GuestbookDTO dto) {
        service.updateBook(id, dto);
        return "redirect:/board/list";
    }

    @GetMapping("/del")
    public String del(int num) {
        service.deleteBook(num);
        return "redirect:/board/list";
    }


    @GetMapping("/getbywriter")
    public String getByWriter(String writer, Model m) {
        m.addAttribute("list", service.getByWriter(writer));
        return "board/list";
    }
}
