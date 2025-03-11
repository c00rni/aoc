package com.adventofcode.day4;

import java.util.Scanner;
import java.io.InputStream;
import com.adventofcode.day2.LineReader;

public class Day4Part1Solution {
    public static void main(String[] args) {
        try {
            InputStream inputStream = Day4Part1Solution.class.getClassLoader().getResourceAsStream("day4_input.txt");
            Scanner scanner = new Scanner(inputStream);

            LineReader reader = new LineReader(scanner);

            Grid grid = new Grid();

            while (reader.hasMoreLine()) {
                grid.addLine(reader.readLine());
            }

            Searcher searcher = new Searcher(grid, "XMAS");
            System.out.println("Solution to Advance of code day 4 is: " + searcher.countAllOccurrences());

        } catch (Exception e) {
            System.err.println("Error reading the resource: " + e.getMessage());
        }

    }
}
