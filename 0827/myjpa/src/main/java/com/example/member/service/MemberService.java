package com.example.member.service;

import com.example.member.dto.MemberDTO;
import com.example.member.entity.MemberEntity;
import com.example.member.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private MemberRepository repo;
    @Autowired
    public MemberService(MemberRepository repo) {
        this.repo = repo;
    }

    public boolean check(String id){
        return repo.findById(id).isEmpty();
    }
    // 회원가입
    public void add(MemberDTO dto){
        MemberEntity Entity = new MemberEntity(dto);
        repo.save(Entity);
    };

    // 회원정보 수정
    public void update(MemberDTO dto){
        Optional<MemberEntity> Entity = repo.findById(dto.getId());
        Entity.ifPresent(m -> {
            if(!dto.getName().isEmpty()) m.setName(dto.getName());
            if(!dto.getEmail().isEmpty()) m.setEmail(dto.getEmail());
            if(!dto.getType().isEmpty()) m.setType(dto.getType());
            repo.save(m);
        });
    };

    // 회원 삭제
    public void delete(MemberDTO dto){
        repo.deleteById(dto.getId());
    };



}
