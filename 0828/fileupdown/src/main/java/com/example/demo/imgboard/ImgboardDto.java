package com.example.demo.imgboard;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.member.Member;
import com.example.demo.rep.ImgrepDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ImgboardDto {
	private int num;
	private Member writer;
	private Date wdate;
	private String title;
	private String content;
	private String fname;
	private MultipartFile f;
	private ArrayList<ImgrepDto> reps;
	private int cnt = 0;
}
