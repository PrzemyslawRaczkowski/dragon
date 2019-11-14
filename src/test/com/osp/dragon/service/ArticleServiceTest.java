package com.osp.dragon.service;

import static java.time.LocalDate.now;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
        Article expectedResult = new Article(1, "Title_1", "Content_1", "Author_1", now().minusDays(1));

        // when:
        Article result = service.getArticleById(id);

        // then:
        assertThat(result).isNotNull();
        assertThat(result).isEqualToComparingFieldByField(expectedResult);
    }

    /*
        @Test
        public void should_throw_exception_when_article_not_found_by_id() {
            // given:
            int id = 1000;
            String expectedMessage = "Article with id: 1000 has not been found.";

            // when:
            Throwable throwable = catchThrowable(() -> service.getArticleById(id));

            // then:
            Assert.assertThat(throwable).isInstanceOf(ArticleNotFoundException.class);
            assertThat(throwable.getMessage()).isEqualTo(expectedMessage);
        }
    */
    @Test
    public void should_return_all_articles() {
        // given:
        int expectedResult = 6;
        // when:
        List<Article> articles = service.getAllArticles();

        // then:
        assertThat(articles).hasSize(expectedResult);

    }

    @Test
    public void should_return_Newest_article() {
        // given:
        //LocalDate expectedDate=LocalDate.parse("2019-11-07");
        LocalDate expectedDate = LocalDate.now();

        // when:
        List<Article> articles = service.getNewestArticles();

        // then:
        assertThat(articles.get(0).getCreationDate()).isEqualTo(expectedDate);
    }

    @Test
    public void should_return_Desc_articles() {
        // given:
        List<Article> expectedResult = new ArrayList<>();
        expectedResult.add(new Article(2, "Title_2", "Content_2", "Author_2", now()));
        expectedResult.add(new Article(1, "Title_1", "Content_1", "Author_1", now().minusDays(1)));
        expectedResult.add(new Article(3, "Title_3", "Content_3", "Author_3", now().minusDays(2)));
        expectedResult.add(new Article(5, "Title_5", "Content_5", "Author_5", now().minusDays(3)));
        expectedResult.add(new Article(4, "Title_4", "Content_4", "Author_4", now().minusMonths(1)));
        expectedResult.add(new Article(6, "Title_6", "Content_6", "Author_6", now().minusMonths(2)));

        // when:
        List<Article> articles1 = service.sortArticles(ArticleSortType.DATE_DESC);
        // then:
        assertThat(articles1).isNotNull();
        assertThat(articles1).isEqualTo(expectedResult);

    }

    @Test
    public void should_return_ASC_articles() {
        // given:
        List<Article> expectedResult = new ArrayList<>();
        expectedResult.add(new Article(6, "Title_6", "Content_6", "Author_6", now().minusMonths(2)));
        expectedResult.add(new Article(4, "Title_4", "Content_4", "Author_4", now().minusMonths(1)));
        expectedResult.add(new Article(5, "Title_5", "Content_5", "Author_5", now().minusDays(3)));
        expectedResult.add(new Article(3, "Title_3", "Content_3", "Author_3", now().minusDays(2)));
        expectedResult.add(new Article(1, "Title_1", "Content_1", "Author_1", now().minusDays(1)));
        expectedResult.add(new Article(2, "Title_2", "Content_2", "Author_2", now()));
        // when:
        List<Article> articles1 = service.sortArticles(ArticleSortType.DATE_ASC);
        // then:
        assertThat(articles1).isNotNull();
        assertThat(articles1).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_number_of_entries_articles() {
        // given:
        int size = 4;
        int expectedResult = 4;
        // when:
        List<Article> articles = service.articlesPagination(size);
        // then:
        assertThat(articles.size()).isNotNull();
        assertThat(articles.size()).isEqualTo(expectedResult);
    }
}