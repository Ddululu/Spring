package com.example.demo.article;

import com.example.demo.member.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int num;

    @ManyToOne  //Article:member => 다대일
    @JoinColumn(nullable=false)
    @OnDelete(action=OnDeleteAction.CASCADE) //on delete cascade 설정
    private Member writer;

    private String title;
    private String content;
    private int cnt;
    private Date wdate;

    @OneToOne(mappedBy = "article", cascade = CascadeType.ALL)
    private ArticleData articleData;

    @PrePersist
    public void makeDate() {
        this.wdate = new Date();
    }

    public Article(ArticleDto dto){
        this.writer=dto.getWriter();
        this.articleData=dto.getData();
        this.title=dto.getTitle();
        this.content=dto.getContent();
        this.cnt=0;
    }

}
