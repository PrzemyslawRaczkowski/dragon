package com.osp.dragon.service;

import static java.time.LocalDate.now;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Stream.of;

import com.osp.dragon.model.Article;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        return new ArrayList<>(articles.values());
    }

    private Map<Integer, Article> loadArticles() {
        return of(
                new Article(1, "Title_1", "Content_1", "Author_1", now()),
                new Article(2, "Title_2", "Content_2", "Author_2", now()),
                new Article(3, "Title_3", "Content_3", "Author_3", now()),
                new Article(4, "Title_4", "Content_4", "Author_4", now()),
                new Article(5, "Title_5", "Content_5", "Author_5", now()),
                new Article(6, "Title_6", "Content_6", "Author_6", now())
        ).collect(toMap(Article::getId, article -> article));
    }

}
