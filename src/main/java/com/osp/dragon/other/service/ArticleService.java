package com.osp.dragon.other.service;

import com.osp.dragon.other.model.Article;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleService {

    private final Map<String, Article> articlesMap;

    public ArticleService() {
        this.articlesMap = initializeArticlesCache();
    }

    public Article getArticleById(String id) {
        return articlesMap.get(id);
    }

    public List<Article> getAllArticles(){
        return new ArrayList<>(articlesMap.values());
    }

    private Map<String, Article> initializeArticlesCache() {
        Map<String, Article> map = new HashMap<>();

        Article article1 = new Article(12345, "Title", "First Article", "raczkowski", "10/12/2018");
        Article article2 = new Article(12345, "Title", "First Article", "raczkowski", "10/12/2018");
        Article article3 = new Article(12345, "Title", "First Article", "raczkowski", "10/12/2018");
        Article article4 = new Article(12345, "Title", "First Article", "raczkowski", "10/12/2018");
        Article article5 = new Article(12345, "Title", "First Article", "raczkowski", "10/12/2018");
        Article article6 = new Article(12345, "Title", "First Article", "raczkowski", "10/12/2018");

        map.put("1", article1);
        map.put("2", article2);
        map.put("3", article3);
        map.put("4", article4);
        map.put("5", article5);
        map.put("6", article6);

        return map;
    }
}
