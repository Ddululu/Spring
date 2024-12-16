package com.example.demo.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class ArticleServiceImpl implements ArticleService {
    private ArticleDao dao;

    @Autowired
    public ArticleServiceImpl(ArticleDao dao) {
        this.dao = dao;
    }


    @Override
    public ArticleDto saveArticle(ArticleDto article) {
        Article Entity = new Article(article);
        dao.save(Entity);
        ArticleDto dto = new ArticleDto();
        return new ArticleDto(dao.findByNum(Entity).orElseThrow());
    }

    @Override
    public ArrayList<ArticleDto> getAll() {
        ArrayList<ArticleDto> articles = new ArrayList<>();
        for (Article Entity : dao.findAll()) {
            articles.add(new ArticleDto(Entity));
        }
        return articles;
    }

    @Override
    public ArticleDto getById(int id) {
        Article Entity = dao.findById(id).orElseThrow();
        return new ArticleDto(Entity);
    }

    @Override
    public ArticleDto getByTitle(String title) {
        Article Entity = dao.findByTitle(title).orElseThrow();
        return new ArticleDto(Entity);
    }

    @Override
    public ArrayList<ArticleDto> getByExtension(String extentsion) {
        ArrayList<Article> Entities = dao.findByNameLike("%" + extentsion);
        ArrayList<ArticleDto> articles = new ArrayList<>();
        for (Article Entity : Entities) {
            articles.add(new ArticleDto(Entity));
        }
        return articles;
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    public ArticleData saveArticleImage(MultipartFile file) throws IOException {
        ArticleData articleData = new ArticleData();
        articleData.setFileName(file.getOriginalFilename());
        articleData.setData(file.getBytes());
        return articleData;
    }
}
