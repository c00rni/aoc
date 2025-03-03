package com.adventofcode.day2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Unit test for simple App.
 */

public class ParserTest {

    private List<ArrayList<Integer>> listOfList;

    @BeforeEach
    public void init() {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.addAll(Arrays.asList(1, 3, 5));
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.addAll(Arrays.asList(4, 2, 1));

        this.listOfList = new ArrayList<>();
        listOfList.add(list1);
        listOfList.add(list2);
    }

    @Test
    public void shouldParseTheFileListOfIntegers() {
        // Given
        String inputFileContent = "1 3 5\n4 2 1";
        Parser parser = new Parser(new LineReader(new Scanner(inputFileContent)));

        // When
        List<ArrayList<Integer>> result = parser.parseToIntegerLists();

        // Then
        assertEquals(result, listOfList);
    }

}
