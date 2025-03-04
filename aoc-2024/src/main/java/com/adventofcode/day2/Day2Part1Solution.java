package com.adventofcode.day2;

import java.util.Scanner;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Day2Part1Solution {
    public static void main(String[] args) {
        try {
            InputStream inputStream = Day2Part1Solution.class.getClassLoader().getResourceAsStream("day2_input.txt");
            Scanner scanner = new Scanner(inputStream);

            LineReader reader = new LineReader(scanner);
            Parser streamParser = new Parser(reader);

            List<ArrayList<Integer>> fileListsOfNumbers = streamParser.parseToIntegerLists();

            int safeReport = 0;
            for (ArrayList<Integer> numbers : fileListsOfNumbers) {
                Report report = new Report(numbers);
                if (report.isSafe()) {
                    safeReport++;
                }
            }

            System.out.println("Solution to Advance of code day 1 part 1 is: " + safeReport);

        } catch (Exception e) {
            System.err.println("Error reading the resource: " + e.getMessage());
        }

    }
}
