package com.osp.dragon.service;

import com.osp.dragon.model.Article;

import java.util.Comparator;

import static java.util.Comparator.comparing;

public enum ArticleSortType {
    DATE_ASC(comparing(Article::getCreationDate)),
    DATE_DESC((a1, a2) -> a2.getCreationDate().compareTo(a1.getCreationDate()));

    private final Comparator<Article> sortingFunction;

    ArticleSortType(Comparator<Article> sortingFunction) {
        this.sortingFunction = sortingFunction;
    }

    public Comparator<Article> getSortingFunction() {
        return sortingFunction;
    }
}
