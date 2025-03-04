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
        String[] stringNumbers = pattern.split(line);
        ArrayList<Integer> arrayListResult = new ArrayList<>();

        for (String number : stringNumbers) {
            arrayListResult.add(Integer.parseInt(number));
        }

        return arrayListResult;
    }

    public List<ArrayList<Integer>> parseToIntegerLists() {
        List<ArrayList<Integer>> arrayListResult = new ArrayList<>();

        while (this.reader.hasMoreLine()) {
            String line = this.reader.readLine();
            arrayListResult.add(this._extractTwoNumberGroups(line));
        }

        return arrayListResult;
    }

}
