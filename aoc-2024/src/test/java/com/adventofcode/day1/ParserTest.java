package com.adventofcode.day1;

import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */

public class ParserTest {

    @Test
    public void shouldParseTheFileIntoTwoListOfIntegers() {
        // Given
        String inputFileContent = "1 3";
        Parser parser = new Parser(new LineReader(new Scanner(inputFileContent)));

        // When
        List<ArrayList<Integer>> result = parser.parseToIntegerLists();

        // Then
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        List<ArrayList<Integer>> listOfList = new ArrayList<>();
        listOfList.add(list1);
        listOfList.add(list2);
        assertEquals(result, listOfList);
    }

}
