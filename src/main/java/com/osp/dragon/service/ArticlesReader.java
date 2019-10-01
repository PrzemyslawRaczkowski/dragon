package com.osp.dragon.service;

import com.osp.dragon.model.Article;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticlesReader {

    private static final String FILE_NAME = "C:/Users/Raczkowski/IdeaProjects/dragon2/src/main/resources/articles.csv";

    public ArrayList<Article> readArticlesFromFile() throws IOException, ClassNotFoundException {

        List<Article> objects = new ArrayList<>();
        FileInputStream fis = new FileInputStream(FILE_NAME);
        ObjectInputStream ois = new ObjectInputStream(fis);

        Article obj;

        boolean isExist = true;

        while (isExist) {
            if (fis.available() != 0) {
                obj = (Article) ois.readObject();
                objects.add(obj);
            } else {
                isExist = false;
            }
        }
        return (ArrayList<Article>) objects;
    }
}
