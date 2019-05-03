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

    public List<Integer> generateNumbersFromRange(int minimum, int maximum, int numberOfSamples) {
        Random rand = new Random();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= numberOfSamples; i++) {
            int n = rand.nextInt(maximum - minimum + 1) + minimum;
            list.add(n);
        }

        return list;
    }
}
