package com.example.demo.guestbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GB_Service {
    @Autowired
    private GB_DAO dao; // DAO

    // 글 작성
    public void addBook(GB_VO vo){
        dao.insert(vo);
    }

    // 번호로 검색
    public GB_VO getBook(int id){
        return dao.select(id);
    }

    // 글 수정
    public void editBook(GB_VO vo){
        dao.update(vo);
    }

    // 번호로 삭제
    public void delBook(int id){
        dao.delete(id);
    }

    // 전체 글 가져오기
    public ArrayList<GB_VO> getAllBooks(){
        return dao.selectAll();
    }

}
