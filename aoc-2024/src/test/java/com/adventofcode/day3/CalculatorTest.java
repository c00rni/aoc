package com.adventofcode.day3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void init() {
        this.calculator = new Calculator();
    }

    @Test
    public void shouldMultiplyNumbers() {
        // Given
        int operand1 = 120;
        int operand2 = 2;

        // When
        int result = calculator.multiply(operand1, operand2);

        // Then
        assertEquals(240, result);
    }

    @Test
    public void shouldAddNumberToTotal() {
        // Given
        int number = 120;
        int number2 = 20;

        // When
        calculator.add(number);
        calculator.add(number2);

        // Then
        assertEquals(140, this.calculator.getTotal());
    }
}
