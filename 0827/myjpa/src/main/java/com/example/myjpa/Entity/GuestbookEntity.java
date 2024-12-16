package com.example.myjpa.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name="GUESTBOOK")
public class GuestbookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int num;
    private String writer;
    private Date wdate;
    private String pwd;
    private String content;

    @PrePersist // insert 전 자동 호출
    public void makeDate(){
        wdate= new Date(System.currentTimeMillis());
    }
    public GuestbookEntity(String writer, String pwd, String content) {
        this.writer = writer;
        this.pwd = pwd;
        this.content = content;
    }
}
