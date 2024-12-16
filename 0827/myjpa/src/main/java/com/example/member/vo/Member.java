package com.example.member.vo;

import com.example.member.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Member {
    private final String id;
    private final String pwd;
    private final String name;
    private final String email;
    private final String type;

    public Member(MemberEntity entity){
        this.id=entity.getId();
        this.pwd=entity.getPwd();
        this.name=entity.getName();
        this.email=entity.getEmail();
        this.type=entity.getType();
    }
}
