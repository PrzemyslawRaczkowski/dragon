package com.osp.dragon.excercise1.controller;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class RandomNumbersGenerator {
    public List<Integer> generate() {
        Random random = new Random();
        List<Integer> ListOfNumbers = new ArrayList<>(100);

        for (int i = 0; i < 100; i++) {
            int n = random.nextInt(101);
            ListOfNumbers.add(n);
        }

        return ListOfNumbers;
    }
}
