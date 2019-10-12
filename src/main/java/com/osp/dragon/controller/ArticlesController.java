package com.osp.dragon.controller;

import com.osp.dragon.model.Article;
import com.osp.dragon.service.ArticleService;
import com.osp.dragon.service.ArticleSortType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/articles")
public class ArticlesController {

    private ArticleService articleService;

    public ArticlesController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    @ResponseBody
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Article getArticle(@PathVariable int id) {
        return articleService.getArticleById(id);
    }

    @GetMapping(value = "/newest")
    public List<Article> getArticlesFromToday() {
        return articleService.getNewestArticles();
    }

    @GetMapping(value = "/sort")
    public List<Article> getArticlesFromToday(@RequestParam ArticleSortType sortType) {
        return articleService.sortArticles(sortType);
    }



}
