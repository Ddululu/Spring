package com.example.demo.article;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface ArticleDao extends CrudRepository<Article, Integer> {
    Optional<Article> findByNum(Article num);
    Optional<Article> findByTitle(String title);
    ArrayList<Article> findByNameLike(String extension);
}
