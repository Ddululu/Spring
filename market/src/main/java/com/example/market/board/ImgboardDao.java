package com.example.market.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ImgboardDao extends JpaRepository<Imgboard, Integer> {

}
