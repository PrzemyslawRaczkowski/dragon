package com.osp.dragon.service;

import com.osp.dragon.exception.ArticleNotFoundException;
import com.osp.dragon.model.Article;
import com.osp.dragon.model.Comment;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static java.lang.String.valueOf;

@Service
public class CommentsService {
    private final CommentMockedRepository repository;

    public CommentsService(CommentMockedRepository repository) {
        this.repository = repository;
    }

    public Comment getCommentById(int id) {
        return getAllComments().stream()
                .filter(comment -> comment.getId()== id)
                .findFirst()
                .orElseThrow(() -> new ArticleNotFoundException(valueOf(id)));
    }

    public List<Comment> getAllComments() {
        return repository.getAllComment();
    }

}