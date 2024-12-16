package com.example.dataroom.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;

@Service
public class MemService {
	@Autowired
	private MemDao dao;

	//추가, 수정:모든 컬럼 수정
	public MemberDto saveMem(MemberDto m) {
		Member entity = new Member(m);
		Member result = dao.saveAndFlush(entity);
		System.out.println(result);
		return new MemberDto(result.getId(), result.getPwd(),
				result.getName(), result.getEmail(), result.getType());
	}

	public MemberDto getMem(String id) {
		Member entity = dao.findById(id).orElse(null);
		if(entity != null) {
			return new MemberDto(entity.getId(), entity.getPwd(), entity.getName(), 
					entity.getEmail(), entity.getType());
		}
		return null;
	}

	public void delMem(String id) {
		dao.deleteById(id);
	}	
}
