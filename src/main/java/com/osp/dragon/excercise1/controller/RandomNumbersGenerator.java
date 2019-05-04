package com.osp.dragon.excercise1.controller;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class RandomNumbersGenerator {

    public int generateRandomNumbersFromRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public List<Integer> generateRandomNumbersFromRange(int minimum, int maximum, int numberOfSamples) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= numberOfSamples; i++) {
            numbers.add(generateRandomNumbersFromRange(minimum, maximum));
        }

        return numbers;
    }
}