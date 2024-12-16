package com.example.product.data.repository;

import com.example.product.data.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MemRepository extends JpaRepository<Member, String> {

}
