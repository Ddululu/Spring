package com.example.demo.rep;

import com.example.demo.imgboard.Imgboard2;
import com.example.demo.member.Member;

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
public class ImgrepDto {
	private int num;
	private Member writer;
	private String content;
	private Imgboard2 parent;
}
