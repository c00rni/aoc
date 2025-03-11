package com.adventofcode.day4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class SearcherTest {

    @Test
    public void shouldreturnTrueIfAPositionHaveTheRightValue() {
        // Given
        Grid grid = new Grid();
        grid.addLine("XMAS");
        Searcher searcher = new Searcher(grid, "");

        // When
        boolean result = searcher.check(0, 0, 'X');

        // Then
        assertTrue(result);
    }

    @Test
    public void shouldreturnTrueBecauseItFoundXMASOnTheDirection() {
        // Given
        Grid grid = new Grid();
        grid.addLine("X...");
        grid.addLine(".M..");
        grid.addLine("..A.");
        grid.addLine("...S");
        Searcher searcher = new Searcher(grid, "XMAS");

        // When
        boolean result = searcher.search(Direction.DOWN_RIGHT, 0, 0);

        // Then
        assertTrue(result);
    }

    @Disabled
    public void shouldNotFoundTheSearchTermInTheDirection() {
        // Given
        Grid grid = new Grid();
        grid.addLine("XMAS");
        Searcher searcher = new Searcher(grid, "XMAS");

        // When
        boolean result = searcher.search(Direction.LEFT, 0, 0);

        // Then
        assertFalse(result);
    }

    @Disabled
    public void shouldCountNumberOfOccurence() {
        // Given
        Grid grid = new Grid();
        grid.addLine("MMMSXXMASM");
        grid.addLine("MSAMXMSMSA");
        grid.addLine("AMXSXMAAMM");
        grid.addLine("MSAMASMSMX");
        grid.addLine("XMASAMXAMM");
        grid.addLine("XXAMMXXAMA");
        grid.addLine("SMSMSASXSS");
        grid.addLine("SAXAMASAAA");
        grid.addLine("MAMMMXMMMM");
        grid.addLine("MXMXAXMASX");
        Searcher searcher = new Searcher(grid, "XMAS");

        // When
        int result = searcher.countAllOccurrences();

        // Then
        assertEquals(18, result);
    }
}
