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

                for (int i = 0; i < numbers.size(); i++) {
                    ArrayList<Integer> copyNumber = new ArrayList<Integer>(numbers);
                    copyNumber.remove(i);
                    Report report = new Report(copyNumber, new Checker());

                    if (report.isSafe()) {
                        safeReport++;
                        i = numbers.size();
                    }
                }
            }

            System.out.println("Solution to Advance of code day 2 is: " + safeReport);

        } catch (Exception e) {
            System.err.println("Error reading the resource: " + e.getMessage());
        }

    }
}
