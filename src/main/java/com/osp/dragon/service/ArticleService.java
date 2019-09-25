package com.osp.dragon.service;

import com.osp.dragon.model.Article;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

import static com.osp.dragon.service.ArticleSortType.DATE_ASC;
import static com.osp.dragon.service.ArticleSortType.DATE_DESC;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

@Service
public class ArticleService {

    private final Map<String, Article> articlesMap;

    public ArticleService() {
        this.articlesMap = initializeArticlesCache();
    }

    public Article getArticleById(String id) {
        return articlesMap.get(id);
    }

    public List<Article> getAllArticles() {
        return new ArrayList<>(articlesMap.values());
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

    private Map<String, Article> initializeArticlesCache() {
        Map<String, Article> articlesMap = new HashMap<>();

        LocalDate date = LocalDate.now();

        Article article1 = new Article(1, "Title", "First Article", "raczkowski", date);
        Article article2 = new Article(2, "Title", "First Article", "raczkowski", date.minusDays(1));
        Article article3 = new Article(3, "Title", "First Article", "raczkowski", date.minusWeeks(2));
        Article article4 = new Article(4, "Title", "First Article", "raczkowski", date);
        Article article5 = new Article(5, "Title", "First Article", "raczkowski", date.minusDays(1));
        Article article6 = new Article(6, "Title", "First Article", "raczkowski", date);


        articlesMap.put("1", article1);
        articlesMap.put("2", article2);
        articlesMap.put("3", article3);
        articlesMap.put("4", article4);
        articlesMap.put("5", article5);
        articlesMap.put("6", article6);

        return articlesMap;
    }
}
