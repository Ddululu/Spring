package com.example.demo.imgboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ImgboardDao extends JpaRepository<Imgboard2, Integer> {
	
	//insert, update, delete 문 작성시 @Transactional, @Modifying 추가
	@Transactional
	@Modifying
	@Query(value="update imgboard2 set cnt=cnt+1 where num=:num", nativeQuery=true)
	void updateCnt(@Param("num") int num);
}
