package com.osp.dragon.excercise1.controller;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class RandomNumbersGenerator {

        public int generate(int min, int max) {

            Random random = new Random();

            return random.nextInt(max - min + 1) + min;
        }

        public ArrayList<Integer> generateRandomNumbersOfSections(int minimum, int maximum, int numberOfSamples) {

            ArrayList<Integer> List = new ArrayList<>();

            for (int i = 0; i <= numberOfSamples; i++) {
                generate(minimum, maximum);
            }
            return List;
        }
    }