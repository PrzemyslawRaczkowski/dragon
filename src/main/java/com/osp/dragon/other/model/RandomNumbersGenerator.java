package com.osp.dragon.other.model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "/numbers")

public class RandomNumbersGenerator {

    @GetMapping
    @ResponseBody
    public List<Integer> generateRandomNumbers() {
        Random random = new Random();
        ArrayList<Integer> ListOfNumbers = new ArrayList<>(100);

        for (int i = 0; i < 100; i++) {
            int n = random.nextInt(101);
            ListOfNumbers.add(n);
        }
        return ListOfNumbers;
    }

    public ArrayList<Integer> generateRandomNumbersOfSections(int minimum, int maximum) {
        Random rand = new Random();

        ArrayList<Integer> List = new ArrayList<>(maximum - minimum);

        for (int i = 0; i <= List.size(); i++) {
            int n = rand.nextInt(maximum - minimum + 1) + minimum;
            List.add(n);
        }
        return List;
    }
}

