package com.example.demo.vo;

import lombok.*;

import java.sql.Date;

@Setter // 멤버변수 Setter 자동 등록
@Getter // 멤버변수 Getter 자동 등록
@NoArgsConstructor // 기본 생성자 생성?
@AllArgsConstructor // Arguement가 있는 생성자 생성
@ToString // ToString 메소드를 재정의 해줌

@Data //Annotation은 AllArgsConstructor를 제외하고 위에 선언한 것들을 모아 놓은 인터페이스
public class GuestBook {
    private int index;
    private String writer;
    private String pwd;
    private Date wdate;
    private String content;
}
