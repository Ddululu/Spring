package com.example.member.service;

import com.example.member.dto.MemberDTO;
import com.example.member.entity.MemberEntity;
import com.example.member.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private MemberRepository repo;
    @Autowired
    public LoginService(MemberRepository repo) {
        this.repo = repo;
    }

    public Boolean login(MemberDTO dto){
        MemberEntity entity = repo.findById(dto.getId())
                .orElseThrow(()->
                        new EntityNotFoundException("잘못된 아이디 혹은 존재하지 않는 아이디입니다."));
        return pwdCheck(dto,entity);
    }
    private Boolean pwdCheck(MemberDTO dto,MemberEntity entity){
        return dto.getPwd().equals(entity.getPwd());
    }

}
