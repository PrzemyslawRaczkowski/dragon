package com.osp.dragon.excercise1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/numbers")
public class NumbersController {

    @Autowired
    public NumbersController() {
    }

    @GetMapping
    @ResponseBody
    public List<Integer> getAllArticles() {
        return Collections.emptyList();
    }


}
