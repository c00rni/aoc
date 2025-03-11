package com.adventofcode.day4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GridTest {

    @Disabled
    public void shouldInitailizeAGridWithALength() {
        // Given
        Grid grid = new Grid();

        // When
        int gridLength = grid.getLines();

        // Then
        assertEquals(gridLength, 12);
    }

    @Test
    public void shouldGetTheOfASpefificRowAndColumn() {
        // Given
        Grid grid = new Grid();
        String line = "012345678901";

        // When
        grid.addLine(line);

        // Then
        char charaterFound = grid.getChar(0, 11);
        assertEquals('1', charaterFound);
    }

}
