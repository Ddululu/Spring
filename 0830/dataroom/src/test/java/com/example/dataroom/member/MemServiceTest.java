package com.example.dataroom.member;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class MemServiceTest {
    @Autowired
    MemDao dao;

    @Test
    void saveMem() {
        MemberDto dto = new MemberDto("aaa","aaa","aaa","aaa","구매자");

        MemService service = new MemService(dao);

        MemberDto member = service.saveMem(dto);
        Assertions.assertNotNull(member);
    }

    @Test
    void getMem() {
    }

    @Test
    void delMem() {
    }
}