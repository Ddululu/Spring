package com.example.demo.rep;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.imgboard.Imgboard2;

@Service
public class ImgrepService {
	@Autowired
	private ImgrepDao dao;
	
	public ImgrepDto save(ImgrepDto dto) {
		Imgrep ir = dao.save(new Imgrep(dto.getNum(), dto.getWriter(), dto.getContent(), dto.getParent()));
		return new ImgrepDto(ir.getNum(), ir.getWriter(), ir.getContent(), ir.getParent());
	}
	
	public ArrayList<ImgrepDto> getByParent(int parent){
		//ArrayList<Imgrep> l = dao.findByParent(new Imgboard2(parent, null, null, null, null, null));
		ArrayList<Imgrep> l = dao.selectReps(parent);
		ArrayList<ImgrepDto> list = new ArrayList<ImgrepDto>();
		for(Imgrep ir:l) {
			list.add(new ImgrepDto(ir.getNum(), ir.getWriter(), ir.getContent(), ir.getParent()));
		}
		return list;
	}
	
	public ArrayList<ImgrepDto> getByNumWriter(int num){
		ArrayList<Imgrep> l = dao.selectByNum(num);
		ArrayList<ImgrepDto> list = new ArrayList<ImgrepDto>();
		for(Imgrep ir:l) {
			list.add(new ImgrepDto(ir.getNum(), ir.getWriter(), ir.getContent(), ir.getParent()));
		}
		return list;
	}
}
