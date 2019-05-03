package com.osp.dragon.excercise1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "/numbers")
public class NumbersController {

    @Autowired
    public NumbersController() {
    }

    @GetMapping
    @ResponseBody
    public List<Integer> generateRandomNumbers() {
        Random random = new Random();
        List<Integer> ListOfNumbers = new ArrayList<>(100);

        for (int i = 0; i < 100; i++) {
            int n = random.nextInt(101);
            ListOfNumbers.add(n);
        }

        return ListOfNumbers;
    }


}
