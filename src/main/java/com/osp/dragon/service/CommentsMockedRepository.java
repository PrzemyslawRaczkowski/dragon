package com.osp.dragon.service;

import com.osp.dragon.model.Article;
import com.osp.dragon.model.Comment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.time.LocalDate.now;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Stream.of;

@Service
class CommentMockedRepository {

    private final Map<Integer, Comment> comment;

    public CommentMockedRepository() {
        this.comment = loadComments();
    }

    public Comment getCommentById(int id) {
        return comment.get(id);
    }

    public List<Comment> getAllComment() {
        return new ArrayList<>(comment.values());
    }

    private Map<Integer, Comment> loadComments() {
        return of(
                new Comment(1, "Content_1", "Author_1", now().minusDays(1)),
                new Comment(2, "Content_2", "Author_2", now()),
                new Comment(3, "Content_3", "Author_3", now().minusDays(2)),
                new Comment(4, "Content_4", "Author_4", now().minusMonths(1)),
                new Comment(5, "Content_5", "Author_5", now().minusDays(3)),
                new Comment(6, "Content_6", "Author_6", now().minusMonths(2))
        ).collect(toMap(Comment::getId, comment -> comment));
    }
}