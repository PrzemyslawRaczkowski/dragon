package com.osp.dragon.service;

import com.osp.dragon.exception.ArticleNotFoundException;
import com.osp.dragon.model.Article;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

import static com.osp.dragon.service.ArticleSortType.DATE_ASC;
import static com.osp.dragon.service.ArticleSortType.DATE_DESC;
import static java.lang.String.valueOf;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

@Service
public class ArticleService {
    private final ArticlesReader articlesReader;

    public ArticleService(ArticlesReader articlesReader) {
        this.articlesReader = articlesReader;
    }

    public Article getArticleById(int id) {
        return getAllArticles().stream()
                .filter(article -> article.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ArticleNotFoundException(valueOf(id)));
    }

    public List<Article> getAllArticles() {
        return articlesReader.readAllArticlesFromFile();
    }

    public List<Article> getNewestArticles() {
        LocalDate today = LocalDate.now();

        return getAllArticles().stream()
                .filter(article -> article.getCreationDate().isEqual(today))
                .collect(toList());
    }

    public List<Article> sortArticles(ArticleSortType sortType) {
        if (sortType.equals(DATE_DESC)) {
            return sort(DATE_DESC.getSortingFunction());
        }

        return sort(DATE_ASC.getSortingFunction());
    }

    private List<Article> sort(Comparator<Article> comparator) {
        return getAllArticles().stream()
                .sorted(comparator)
                .collect(toList());
    }
}
