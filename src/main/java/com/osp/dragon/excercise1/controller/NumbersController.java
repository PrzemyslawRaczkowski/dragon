package com.osp.dragon.excercise1.controller;

import org.springframework.web.bind.annotation.*;

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
    public List<Integer> getRandomNumbers(@RequestParam Integer min,
                                          @RequestParam Integer max,
                                          @RequestParam Integer numberOfSamples) {
        return generator.generateRandomNumbersFromRange(min, max, numberOfSamples);
    }

}
