package com.adventofcode.day3;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import com.adventofcode.day2.LineReader;

public class Parser {
    private LineReader reader;

    public Parser(LineReader reader) {
        this.reader = reader;
    }

    public ArrayList<String> parseLine(String regex, String line) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        ArrayList<String> results = new ArrayList<String>();

        while (matcher.find()) {
            results.add(matcher.group());
        }
        return results;
    }

    public ArrayList<String> parse() {
        ArrayList<String> commands = new ArrayList<String>();

        while (this.reader.hasMoreLine()) {
            String line = this.reader.readLine();
            ArrayList<String> lineCommands = this.parseLine("mul\\([0-9]{1,3}\\,[0-9]{1,3}\\)|do\\(\\)|don't\\(\\)",
                    line);
            commands.addAll(lineCommands);
        }

        return commands;
    }

}
