package com.adventofcode.day1;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;

public class Parser {
    private LineReader reader;

    public Parser(LineReader reader) {
        this.reader = reader;
    }

    private int[] _extractTwoNumberGroups(String line) {
        Pattern pattern = Pattern.compile("(\\d+)\\s+(\\d+)");
        Matcher matcher = pattern.matcher(line);

        if (matcher.matches()) {
            try {
                int firstNumber = Integer.parseInt(matcher.group(1));
                int secondNumber = Integer.parseInt(matcher.group(2));
                return new int[] { firstNumber, secondNumber };
            } catch (IndexOutOfBoundsException e) {
                throw new IllegalLineFormat("The file if not formatted properly.");
            }
        }

        return null;
    }

    public List<ArrayList<Integer>> parseToIntegerLists() {
        ArrayList<Integer> firstList = new ArrayList<>();
        ArrayList<Integer> secondList = new ArrayList<>();

        while (this.reader.hasMoreLine()) {
            String line = this.reader.readLine();
            int[] numbers = this._extractTwoNumberGroups(line);

            firstList.add(numbers[0]);
            secondList.add(numbers[1]);
        }
        List<ArrayList<Integer>> twoArrayListResult = new ArrayList<>();
        twoArrayListResult.add(firstList);
        twoArrayListResult.add(secondList);

        return twoArrayListResult;
    }

    public static class IllegalLineFormat extends RuntimeException {
        public IllegalLineFormat(String message) {
            super(message);
        }
    }

}
