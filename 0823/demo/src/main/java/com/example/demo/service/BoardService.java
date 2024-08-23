package com.example.demo.service;

import com.example.demo.dao.BoardDAO;
import com.example.demo.vo.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardDAO dao;

    public void addBoard(Board board) {
        dao.insert(board);
    }
    public List<Board> getAllBoards() {
        return dao.selectAll();
    }
    public Board getBoardById(int index) {
        return dao.selectById(index);
    }
    public List<Board> getByTitle(String title){
        return dao.selectByTitle(title);
    }
    public List<Board> getByWirter(String name){
        return dao.selectByWriter(name);
    }
    public void deleteBoardById(int index) {
        dao.delete(index);
    }
    public void updateBoard(Board board) {
        dao.update(board);
    }
}
