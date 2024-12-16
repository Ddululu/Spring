package com.example.myjpa.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.sql.Date;

@AllArgsConstructor
@Getter
public class Guestbook {
    private int num;
    private String writer;
    private Date date;
    private String pwd;
    private String content;
}
