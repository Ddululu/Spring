package com.example.demo.imgboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImgboardService {
	@Autowired
	private ImgboardDao dao;
	
	//추가, 수정
	public ImgboardDto save(ImgboardDto dto) {
		Imgboard2 im= dao.save(new Imgboard2(dto.getNum(), dto.getWriter(), dto.getWdate(), dto.getTitle(), 
				dto.getContent(), dto.getFname(), dto.getCnt()));
		return new ImgboardDto(im.getNum(), im.getWriter(), im.getWdate(), im.getTitle(), im.getContent(), 
				im.getFname(), null, null, im.getCnt());
	}
	
	public ImgboardDto getBoard(int num) {
		Imgboard2 im = dao.findById(num).orElse(null);
		if(im == null) {
			return null;
		}
		return new ImgboardDto(im.getNum(), im.getWriter(), im.getWdate(), im.getTitle(), im.getContent(), 
				im.getFname(), null, null, im.getCnt());
	}
	
	public ArrayList<ImgboardDto> getAll(){
		List<Imgboard2> l = dao.findAll();
		ArrayList<ImgboardDto> list = new ArrayList<ImgboardDto>();
		for(Imgboard2 im : l) {
			list.add(new ImgboardDto(im.getNum(), im.getWriter(), im.getWdate(), im.getTitle(), im.getContent(), 
				im.getFname(), null, null, im.getCnt()));
		}
		return list;
	}
	
	public void delBoard(int num) {
		dao.deleteById(num);
	}
	
	public void editCnt(int num) {
		dao.updateCnt(num);
	}
}







