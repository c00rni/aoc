package com.adventofcode.day1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Scanner;

/**
 * Unit test for simple App.
 */

public class FileReaderTest {

    private Scanner scanner;

    private String inputLine;

    @BeforeEach
    public void init() {
        this.inputLine = "First line.";
        this.scanner = new Scanner(inputLine);
    }

    @Test
    public void readline_GetTheContentOfTheNextLine() {
        // Given
        LineReader lineReader = new LineReader(this.scanner);

        // When
        String result = lineReader.readLine();

        // Then
        assertEquals(this.inputLine, result);
    }

    @Test
    void readline_ThrowsErrorWhenNoMoreLines() {
        // Given
        LineReader lineReader = new LineReader(this.scanner);

        // When
        lineReader.readLine();

        // Then
        assertThrows(LineReader.NoMoreLine.class, () -> {
            lineReader.readLine();
        });
    }

    @Test
    public void shouldIndicateThereIsStillLinesToProcess() {
        // Given
        LineReader lineReader = new LineReader(this.scanner);

        // When
        Boolean result = lineReader.hasMoreLine();

        // Then
        assertTrue(result);
    }
}
