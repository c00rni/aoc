package com.adventofcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Unit test for simple App.
 */

public class FileReaderTest {

    @Test
    public void readline_CallsBufferedReaderReadLine() {
        // Given
        String inputLine = "First line.";
        BufferedReader mockBufferedReader = mock(BufferedReader.class);
        try {
            when(mockBufferedReader.readLine()).thenReturn(inputLine);
        } catch (IOException e) {
            System.err.println(e);
        }

        LineReader lineReader = new LineReader(mockBufferedReader);

        // When
        String result = lineReader.readLine();

        // Then
        assertEquals(inputLine, result);
    }

    @Disabled
    void readline_ThrowsErrorWhenNoMoreLines() {
    }

}
