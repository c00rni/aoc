package com.adventofcode.day1;

import java.util.Scanner;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Day1Part1Solution {
    public static void main(String[] args) {
        try {
            InputStream inputStream = Day1Part1Solution.class.getClassLoader().getResourceAsStream("day1_1_input.txt");
            Scanner scanner = new Scanner(inputStream);

            LineReader reader = new LineReader(scanner);
            Parser streamParser = new Parser(reader);

            List<ArrayList<Integer>> fileListsOfNumbers = streamParser.parseToIntegerLists();

            ArrayList<Integer> firstList = fileListsOfNumbers.get(0);
            ArrayList<Integer> secondList = fileListsOfNumbers.get(1);

            Calculator calculator = new Calculator(firstList, secondList);
            int result = calculator.sumDifference();

            System.out.println("Solution to Advance of code day 1 part 1 is: " + result);

        } catch (Exception e) {
            System.err.println("Error reading the resource: " + e.getMessage());
        }

    }
}
