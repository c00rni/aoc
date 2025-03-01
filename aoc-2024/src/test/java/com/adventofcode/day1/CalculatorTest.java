package com.adventofcode.day1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;

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
        // Given
        Calculator calculator = new Calculator(this.firstList, this.secondList);

        // When
        ArrayList<Integer> firstListSaved = calculator.getFirstList();
        ArrayList<Integer> secondListSaved = calculator.getSecondList();

        // Then
        ArrayList<Integer> expectedList1 = new ArrayList<Integer>();
        expectedList1.addAll(Arrays.asList(1, 1, 3));
        ArrayList<Integer> expectedList2 = new ArrayList<Integer>();
        expectedList2.addAll(Arrays.asList(1, 3, 3));
        assertEquals(expectedList1, firstListSaved);
        assertEquals(expectedList2, secondListSaved);
    }

    @Disabled
    public void shouldThowAnErrorWhenTwoArrayDontHaveTheSameLenght() {
    }
}
