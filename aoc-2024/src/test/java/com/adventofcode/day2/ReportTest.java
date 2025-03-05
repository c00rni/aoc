package com.adventofcode.day2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.Arrays;

public class ReportTest {

    private ArrayList<Integer> numbers;
    private LevelChecker checker;

    class MockChecker implements LevelChecker {

        private int _count;

        public MockChecker() {
            this._count = 0;
        }

        public boolean checkAdjacentLevels(boolean direction, Integer firstLevelValue, Integer secondLevelValue) {
            this._count++;
            return true;
        }

        public int getCount() {
            return this._count;
        }

    }

    @BeforeEach
    public void init() {
        this.numbers = new ArrayList<Integer>();
        this.checker = new MockChecker();
    }

    @Test
    public void shouldApplyTheCheckOnAllTheLevel() {
        // Given
        this.numbers.addAll(Arrays.asList(1, 3, 5, 6, 9));
        Report report = new Report(this.numbers, this.checker);

        // When
        report.isSafe();

        // Then
        assertEquals(((MockChecker) this.checker).getCount(), 4);
    }

    @Test
    public void shouldBeInscreasing() {
        // Given
        this.numbers.addAll(Arrays.asList(1, 3, 5, 6, 9));

        // When
        Report report = new Report(this.numbers, this.checker);

        // Then
        assertTrue(report.isIncreasing());
    }

    @Test
    public void shouldThrowAnErrorBecauseTheArrayIsTooSmall() {
        // When
        this.numbers.add(1);

        // Then
        assertThrows(Report.TooSmallReport.class, () -> {
            new Report(this.numbers, this.checker);
        });

    }

}
