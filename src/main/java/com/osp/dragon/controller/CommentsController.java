package com.osp.dragon.controller;

import com.osp.dragon.model.Comment;
import com.osp.dragon.service.CommentsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/comments")
public class CommentsController {
    private CommentsService commentsService;

    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @GetMapping
    @ResponseBody
    public List<Comment> getAllArticles() {
        return commentsService.getAllComments();
    }
}
