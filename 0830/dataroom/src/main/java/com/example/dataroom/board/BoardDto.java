package com.example.dataroom.board;

import java.util.Date;


import com.example.dataroom.member.Member;
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
public class BoardDto {
	private int num;
	private Member writer;
	private Date wdate;
	private String title;
	private String content;
}
