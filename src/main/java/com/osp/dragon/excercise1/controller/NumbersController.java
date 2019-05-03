package com.osp.dragon.excercise1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/numbers")
public class NumbersController {

    private final RandomNumbersGenerator generator;

    public NumbersController(RandomNumbersGenerator generator) {
        this.generator = generator;
    }

    @GetMapping
    @ResponseBody
    public List<Integer> getRandomNumbers() {
        return generator.generate();
    }

}
