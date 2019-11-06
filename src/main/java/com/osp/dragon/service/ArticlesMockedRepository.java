package com.osp.dragon.service;

import com.osp.dragon.model.Article;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticlesMockedRepository {

    private final Map<Integer, Article> articles;

    public ArticlesMockedRepository() {
        this.articles = loadArticles();
    }

    public Article getArticleById(int id) {
        return articles.get(id);
    }

    public List<Article> getAllArticles() {
        return (List<Article>) articles.values();
    }

    private Map<Integer, Article> loadArticles() {
        return new HashMap<>();
    }

}
