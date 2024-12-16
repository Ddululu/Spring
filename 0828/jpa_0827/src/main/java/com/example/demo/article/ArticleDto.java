package com.example.demo.article;

import com.example.demo.member.Member;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {
    private int num;
    private Member writer;
    private String title;
    private ArticleData data;
    private String content;
    private int cnt;
    private Date wdate;

    public ArticleDto(Article article) {
        this.num = article.getNum();
        this.writer = article.getWriter();
        this.data=article.getArticleData();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.cnt = article.getCnt();
        this.wdate = article.getWdate();
    }
}
