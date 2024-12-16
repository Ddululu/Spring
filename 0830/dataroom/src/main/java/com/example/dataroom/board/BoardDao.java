package com.example.dataroom.board;

import java.util.ArrayList;

import com.example.dataroom.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BoardDao extends JpaRepository<Board, Integer> {
	//작성자로 검색
	ArrayList<Board> findByWriter(Member Writer);
	
	//타이틀(like) 검색
	ArrayList<Board> findByTitleLike(String title);
}
