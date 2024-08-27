package com.example.demo.vo;

import lombok.*;

import java.sql.Date;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    private int index;
    private String writer;
    private Date wdate;
    private String title;
    private String content;
}
