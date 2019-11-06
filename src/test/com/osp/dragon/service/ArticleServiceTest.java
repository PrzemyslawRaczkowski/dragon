package com.osp.dragon.service;

import static java.time.LocalDate.now;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.osp.dragon.exception.ArticleNotFoundException;
import com.osp.dragon.model.Article;

public class ArticleServiceTest {
    private ArticleService service;

    @Before
    public void setUp() {
        service = new ArticleService(new ArticlesMockedRepository());
    }

    @Test
    public void should_return_article_by_id() {
        // given:
        int id = 1;
        Article expectedResult = new Article(1, "Title_1", "Content_1", "Author_1", now());

        // when:
        Article result = service.getArticleById(id);

        // then:
        assertThat(result).isNotNull();
        assertThat(result).isEqualToComparingFieldByField(expectedResult);
    }

    @Test
    public void should_throw_exception_when_article_not_found_by_id() {
        // given:
        int id = 1000;
        String expectedMessage = "Article with id: 1000 has not been found.";

        // when:
        Throwable throwable = catchThrowable(() -> service.getArticleById(id));

        // then:
        assertThat(throwable).isInstanceOf(ArticleNotFoundException.class);
        assertThat(throwable.getMessage()).isEqualTo(expectedMessage);
    }

    @Test
    public void should_return_all_articles() {
        // given:
        int expectedResult = 6;
        // when:
        List<Article> articles = service.getAllArticles();

        // then:
        assertThat(articles).hasSize(expectedResult);

    }
}