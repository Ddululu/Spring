package com.example.guestbook;

import lombok.*;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

@Setter // 멤버변수 Setter 자동 등록
@Getter // 멤버변수 Getter 자동 등록
@NoArgsConstructor
@AllArgsConstructor
@ToString // ToString 메소드를 재정의 해줌

@Data //Annotation은 위에 선언한 것들을 모아 놓은 인터페이스
public class GB_VO {
    private int index;
    private String writer;
    private String pwd;
    private Date date;
    private String content;
}
