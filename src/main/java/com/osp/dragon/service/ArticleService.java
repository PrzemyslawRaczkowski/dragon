package com.osp.dragon.service;

import com.osp.dragon.model.Article;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

import static com.osp.dragon.service.ArticleSortType.DATE_ASC;
import static com.osp.dragon.service.ArticleSortType.DATE_DESC;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

@Service
public class ArticleService {
    private List<Article> articlesList;

    public ArticleService() throws IOException, ClassNotFoundException {
        ArticlesReader articlesReader = new ArticlesReader();
        this.articlesList = articlesReader.readAllArticlesFromFile();
    }

    public Article getArticleById(int id) {
        return articlesList.get(id - 1);
    }

    public List<Article> getAllArticles() {
        return new ArrayList<>(articlesList);
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
