package com.example.dataroom.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Member {
	@Id
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String type;

	public Member(MemberDto dto){
		this.id = dto.getId();
		this.pwd = dto.getPwd();
		this.name = dto.getName();
		this.email = dto.getEmail();
		this.type = dto.getType();
	}
}
