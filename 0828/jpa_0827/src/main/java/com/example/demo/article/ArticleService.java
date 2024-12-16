package com.example.demo.article;

import java.util.ArrayList;

public interface ArticleService {

    // 글 작성 & 글 수정
    ArticleDto saveArticle(ArticleDto article);

    //글 목록
    ArrayList<ArticleDto> getAll();

    //번호로 검색
    ArticleDto getById(int id);

    //제목으로 검색
    ArticleDto getByTitle(String title);

    // 자료 확장자로 검색
    ArrayList<ArticleDto> getByExtension(String extension);

    // 글 삭제
    void deleteById(int id);
}
