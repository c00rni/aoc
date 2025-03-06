package com.adventofcode.day3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.adventofcode.day2.LineReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class ParserTest {

    @Test
    public void shouldExtractCommands() {
        // Given
        String inputFileContent = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5)";

        // When
        Parser parser = new Parser(new LineReader(new Scanner(inputFileContent)));

        // Then
        ArrayList<String> total = parser.parse();
        ArrayList<String> expectedList = new ArrayList<>(
                Arrays.asList("mul(2,4)", "don't()", "mul(5,5)", "mul(11,8)", "do()", "mul(8,5)"));
        assertEquals(expectedList, total);
    }

}
