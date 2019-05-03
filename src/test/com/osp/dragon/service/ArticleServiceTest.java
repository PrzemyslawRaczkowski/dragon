package com.osp.dragon.other.service;

import com.osp.dragon.other.model.Article;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ArticleServiceTest {

    @Test
    public void should_return_article_for_given_id() {
        // given:
        String id = "12345";
        Article article = new Article(12345, "Title", "First Article", "raczkowski", "10/12/2018");

        Map<String, Article> db = new HashMap<>();
        db.put(id, article);

        ArticleService articleService = new ArticleService();

        // when:
        Article result = articleService.getArticleById(id);

        //
        assertEquals(article, result);
    }

    @Test
    public void should_return_null_when_article_is_not_found() {
        // given:
        String id = "67890987654";
        Article article = new Article(12345, "Title", "First Article", "raczkowski", "10/12/2018");

        Map<String, Article> db = new HashMap<>();
        db.put("12345", article);

        ArticleService articleService = new ArticleService();

        // when:
        Article result = articleService.getArticleById(id);

        // then:
        assertNull(result);
    }
}