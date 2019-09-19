package com.osp.dragon.excercise1.controller;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

@Ignore
public class RandomNumbersGeneratorTest {

    @Test
    public void should_return_proper_number_of_samples() {
        // given:
        int numberOfSamples = 100;
        RandomNumbersGenerator generator = new RandomNumbersGenerator();

        // when:
        List<Integer> result = generator.generateRandomNumbersFromRange(10, 100, numberOfSamples);

        // then:
        assertEquals(result.size(), numberOfSamples);
    }

}