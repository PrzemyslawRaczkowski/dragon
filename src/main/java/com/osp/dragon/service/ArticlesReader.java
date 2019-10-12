package com.osp.dragon.service;

import com.osp.dragon.model.Article;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticlesReader {

    private static final String FILE_NAME = "articles.csv";

    public List<Article> readAllArticlesFromFile() {

        List<Article> objects = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Article article;

        boolean doesExist = true;

        while (doesExist) {
            if (fileInputStream.available() != 0) {
                article = (Article) objectInputStream.readObject();
                objects.add(article);
            } else {
                doesExist = false;
            }
        }
        return objects;
    }
}
