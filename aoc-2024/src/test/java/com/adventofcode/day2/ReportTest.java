package com.adventofcode.day2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReportTest {

    @Test
    public void shouldEvaluteTheResportAsSafe() {
        // Given
        int[] numbers = new int[] { 1, 3, 5 };

        // When
        Report report = new Report(numbers);

        // Then
        assertTrue(report.isSafe());
    }

    @Disabled
    public void shouldEvaluteTheResportAsUnSafe() {

    }

    @Disabled
    public void shouldThrowAnErrorBecauseTheArrayIsEmpty() {

    }

}
