package com.example.market.board;

import com.example.market.user.Users;
import org.springframework.web.multipart.MultipartFile;



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
	private Users writer;
	private String title;
	private String img;
	private MultipartFile f;
}
