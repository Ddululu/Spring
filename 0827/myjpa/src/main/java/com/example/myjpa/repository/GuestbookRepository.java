package com.example.myjpa.repository;

import com.example.myjpa.Entity.GuestbookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestbookRepository extends JpaRepository<GuestbookEntity,Integer> {
    List<GuestbookEntity> findByWriter(String writer);
}
