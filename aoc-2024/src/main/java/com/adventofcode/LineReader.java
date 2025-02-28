package com.adventofcode;

import java.io.BufferedReader;
import java.io.IOException;

public class LineReader {

    private BufferedReader inputStream;

    public LineReader(BufferedReader buffer) {
        this.inputStream = buffer;
    }

    public String readLine() {
        try {
            String line = inputStream.readLine();
            if (line == null) {
                throw new Error("No more lines.");
            }
            return line;
        } catch (IOException e) {
            System.err.println("Error occur while reading the input line");
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
