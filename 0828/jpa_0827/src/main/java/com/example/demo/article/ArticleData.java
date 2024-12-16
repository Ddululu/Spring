package com.example.demo.article;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleData {
    @Id
    @Column(name = "article_num") // article_num이라는 컬럼 생성
    private int articleNum;

    @OneToOne
    @MapsId
    @JoinColumn(name = "article_num") // article_num컬럼은 외래키, Article article 필드와 연결된다.
    private Article article;

    private String fileName;
    @Lob
    private byte[] data;
}
