package com.adventofcode.day1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CalculatorTest {

    private ArrayList<Integer> firstList;
    private ArrayList<Integer> secondList;

    @BeforeEach
    public void init() {
        firstList = new ArrayList<>();
        secondList = new ArrayList<>();
        firstList.addAll(Arrays.asList(1, 3, 1));
        secondList.addAll(Arrays.asList(3, 1, 3));
    }

    @Test
    public void shouldSumTheAbsoluteDifferenceOfTwoArray() {
        // Given
        Calculator calculator = new Calculator(this.firstList, this.secondList);

        // When
        int result = calculator.sumDifference();

        // Then
        assertEquals(2, result);
    }

    @Test
    public void shouldSortInputLists() {
        // When
        Calculator calculator = new Calculator(this.firstList, this.secondList);

        // Then
        ArrayList<Integer> firstListSaved = calculator.getFirstList();
        ArrayList<Integer> secondListSaved = calculator.getSecondList();

        Collections.sort(this.firstList);
        Collections.sort(this.secondList);

        assertEquals(this.firstList, firstListSaved);
        assertEquals(this.secondList, secondListSaved);
    }

    @Test
    public void shouldThowAnErrorWhenTwoArrayDontHaveTheSameLenght() {
        // Given
        this.secondList.add(4);

        // When
        Calculator calculator = new Calculator(this.firstList, this.secondList);

        // Then
        assertThrows(Calculator.NoEqualListSize.class, () -> {
            calculator.sumDifference();
        });

    }

    @Test
    public void shouldCaculateTheSimilarityScore() {
        // Given
        Calculator calculator = new Calculator(this.firstList, this.secondList);

        // When
        int result = calculator.getSimilarityScore();

        // Then
        assertEquals(8, result);
    }
}
