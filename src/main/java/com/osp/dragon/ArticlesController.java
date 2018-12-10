package com.osp.dragon;

import com.osp.dragon.model.Article;
import com.osp.dragon.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/articles")
public class ArticlesController {

    private ArticleService articleService;

    @Autowired
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
    public Article getArticle(@PathVariable String id) {
        return articleService.getArticleById(id);
    }

}
