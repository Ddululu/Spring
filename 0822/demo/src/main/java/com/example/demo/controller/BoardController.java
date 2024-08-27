package com.example.demo.controller;

import com.example.demo.service.BoardService;
import com.example.demo.vo.Board;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService service;

    @GetMapping("/")
    public String board(Model m) {
        m.addAttribute("list", service.getAllBoards());
        return "/board/index";}
    @GetMapping("/index")
    public String index(Model m) {
        return "/board/";
    }

    @GetMapping("/add")
    public void addform(HttpSession session) {
    }

    @PostMapping("/add")
    public String add(Board board) {
        service.addBoard(board);
        return "board/";
    }

    @GetMapping("/getAjax")
    @ResponseBody
    public Map getAjax(int index) {
        Board b = service.getBoardById(index);
        System.out.println("인덱스: "+index);
        Map map = new HashMap();
        map.put("index", b.getIndex());
        map.put("title", b.getTitle());
        map.put("content", b.getContent());
        map.put("writer",b.getWriter());
        map.put("wdate", b.getWdate()+"");
        return map;
    }

    @GetMapping("/detail")
    public String detail(int index, Model model, HttpSession session) {
        Board b = service.getBoardById(index);
        model.addAttribute("board", b);
        return "board/detail";
    }
    @PostMapping("/edit")
    public String edit(Board board) {
        service.updateBoard(board);
        return "redirect:/board/";
    }

    @GetMapping("/delete")
    public String delete(int index) {
        service.deleteBoardById(index);
        return "redirect:/board/";
    }

//    @GetMapping("/search")
//    public String search(Board board) {}
}



