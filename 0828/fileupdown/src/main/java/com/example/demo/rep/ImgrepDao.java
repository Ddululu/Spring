package com.example.demo.rep;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.imgboard.Imgboard2;
@Repository
public interface ImgrepDao extends JpaRepository<Imgrep, Integer> {
	ArrayList<Imgrep> findByParent(Imgboard2 parent);
	
	@Query(value="select * from imgrep where parent_num=:parent", nativeQuery=true)
	ArrayList<Imgrep> selectReps(@Param("parent") int parent);
	
	@Query(value="select * from imgrep where writer_id = (select writer_id from imgrep where num=:num)", nativeQuery=true)
	ArrayList<Imgrep> selectByNum(@Param("num") int num);//num: 댓글 번호. 이글의 작성자가 작성한 모든 댓글을 검색
}
