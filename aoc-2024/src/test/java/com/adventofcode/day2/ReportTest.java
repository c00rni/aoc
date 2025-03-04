package com.adventofcode.day2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.Arrays;

public class ReportTest {

    private ArrayList<Integer> numbers;

    @BeforeEach
    public void init() {
        this.numbers = new ArrayList<Integer>();
    }

    @Test
    public void shouldEvaluteTheResportAsSafe() {
        // Given
        this.numbers.addAll(Arrays.asList(1, 3, 6, 7, 9));

        // When
        Report report = new Report(numbers);

        // Then
        assertTrue(report.isSafe());
    }

    @Test
    public void shouldEvaluteTheResportUnSafeBecauseAdjacentNumberDifferenceIsToBig() {
        // Given
        this.numbers.addAll(Arrays.asList(1, 2, 7, 8, 9));

        // When
        Report report = new Report(numbers);

        // Then
        assertFalse(report.isSafe());
    }

    @Test
    public void shouldEvaluteTheResportUnsageOfDifferenceOf4() {
        // Given
        this.numbers.addAll(Arrays.asList(9, 7, 6, 2, 1));

        // When
        Report report = new Report(numbers);

        // Then
        assertFalse(report.isSafe());
    }

    @Test
    public void shouldEvaluteTheResportUnSafeBecauseNumbersIncreaseAndDecrease() {
        // Given
        this.numbers.addAll(Arrays.asList(1, 3, 2, 4));

        // When
        Report report = new Report(numbers);

        // Then
        assertFalse(report.isSafe());
    }

    @Test
    public void shouldEvaluteTheResportAsUnsageBecauseAdjacentNumberDifferenceIsTooLow() {
        // Given
        this.numbers.addAll(Arrays.asList(1, 1, 2));

        // When
        Report report = new Report(numbers);

        // Then
        assertFalse(report.isSafe());
    }

    @Test
    public void shouldThrowAnErrorBecauseTheArrayIsTooSmall() {
        // Given
        this.numbers.add(1);

        // When
        Report report = new Report(numbers);

        // Then
        assertThrows(Report.TooSmallReport.class, () -> {
            report.isSafe();
        });

    }

}
