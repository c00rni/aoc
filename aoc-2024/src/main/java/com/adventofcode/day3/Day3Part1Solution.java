package com.adventofcode.day3;

import java.util.Scanner;
import java.io.InputStream;
import java.util.ArrayList;
import com.adventofcode.day2.LineReader;

public class Day3Part1Solution {
    public static void main(String[] args) {
        try {
            InputStream inputStream = Day3Part1Solution.class.getClassLoader().getResourceAsStream("day3_input.txt");
            Scanner scanner = new Scanner(inputStream);

            LineReader reader = new LineReader(scanner);
            Parser streamParser = new Parser(reader);

            ArrayList<String> extractCommands = streamParser.parse();

            boolean executionIsEnable = true;
            Calculator calculator = new Calculator();

            for (String command : extractCommands) {
                if (command.startsWith("mul")) {
                    if (executionIsEnable) {
                        ArrayList<String> stringOperands = streamParser.parseLine("\\d+", command);
                        int operand1 = Integer.parseInt(stringOperands.get(0));
                        int operand2 = Integer.parseInt(stringOperands.get(1));
                        int multiplicationResult = calculator.multiply(operand1, operand2);
                        calculator.add(multiplicationResult);
                    }
                } else if (command.startsWith("do()")) {
                    executionIsEnable = true;
                } else if (command.startsWith("don't()")) {
                    executionIsEnable = false;
                }
            }

            System.out.println("Solution to Advance of code day 3 is: " + calculator.getTotal());

        } catch (Exception e) {
            System.err.println("Error reading the resource: " + e.getMessage());
        }

    }
}
