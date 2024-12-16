package com.example.product.data.repository;

import java.util.ArrayList;

import com.example.product.data.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.product.data.entity.Member;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
	//작성자로 검색
	ArrayList<Board> findByWriter(Member Writer);
	
	//타이틀(like) 검색
	ArrayList<Board> findByTitleLike(String title);
}
