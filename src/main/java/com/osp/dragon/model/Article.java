package com.osp.dragon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Article implements Serializable {

    @JsonProperty("id")
    private final int id;

    @JsonProperty("title")
    private final String title;

    @JsonProperty("content")
    private final String content;

    @JsonProperty("author")
    private final String author;

    @JsonProperty("creationDate")
    private LocalDate creationDate;

    public Article(int id,
                   String title,
                   String content,
                   String author,
                   LocalDate creationDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return id == article.id &&
                title.equals(article.title) &&
                content.equals(article.content) &&
                author.equals(article.author) &&
                creationDate.equals(article.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, author, creationDate);
    }
}
