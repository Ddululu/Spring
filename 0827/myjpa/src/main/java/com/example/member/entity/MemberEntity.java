package com.example.member.entity;

import com.example.member.dto.MemberDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name="member")
public class MemberEntity {
    @Id
    private String id;
    private String pwd;
    private String name;
    private String email;
    private String type;

    public MemberEntity(MemberDTO dto) {
        this.id = dto.getId();
        this.pwd = dto.getPwd();
        this.name = dto.getName();
        this.email = dto.getEmail();
        this.type = dto.getType();
    }
}
