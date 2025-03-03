package com.adventofcode.day2;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.List;

public class Parser {
    private LineReader reader;

    public Parser(LineReader reader) {
        this.reader = reader;
    }

    private ArrayList<Integer> _extractTwoNumberGroups(String line) {
        Pattern pattern = Pattern.compile("\\s+");
        String[] numbers = pattern.split(line);
        ArrayList<Integer> arrayListResult = new ArrayList<>();

        for (String number : numbers) {
            arrayListResult.add(Integer.parseInt(number));
        }

        return arrayListResult;
    }

    public List<ArrayList<Integer>> parseToIntegerLists() {
        List<ArrayList<Integer>> ArrayListResult = new ArrayList<>();

        while (this.reader.hasMoreLine()) {
            String line = this.reader.readLine();
            ArrayListResult.add(this._extractTwoNumberGroups(line));
        }

        return ArrayListResult;
    }

}
