package com.osp.dragon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;
import java.util.Objects;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Comment {

    @JsonProperty("id")
    private final int id;

    @JsonProperty("content")
    private final String content;

    @JsonProperty("author")
    private final String author;

    @JsonProperty("creationDate")
    private LocalDate creationDate;

    public Comment(int id, String content, String author, LocalDate creationDate) {
        this.id = id;
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
        if (!(o instanceof Comment)) return false;
        Comment comment = (Comment) o;
        return id == comment.id && 
                content.equals(comment.content) &&
                author.equals(comment.author) &&
                creationDate.equals(comment.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, author, creationDate);
    }
}
