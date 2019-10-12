package com.osp.dragon.exception;

public class ArticleNotFoundException extends RuntimeException {

    public ArticleNotFoundException(String id) {
        super(String.format("Article with id: %s has not been found.", id));
    }
}
