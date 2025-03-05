package com.adventofcode.day2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CheckerTest {

    @BeforeEach
    public void init() {
    }

    @Test
    public void shouldNothaveTheSameDirection() {
        // Given
        Checker checker = new Checker();

        // When
        boolean result = checker.checkAdjacentLevels(true, 2, 1);

        // Then
        assertFalse(result);
    }

    @Test
    public void shouldNothaveAValidifference() {
        // Given
        Checker checker = new Checker();

        // When
        boolean result = checker.checkAdjacentLevels(true, 1, 7);

        // Then
        assertFalse(result);
    }
}
