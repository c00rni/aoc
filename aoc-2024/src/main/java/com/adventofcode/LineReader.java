package com.adventofcode;

import java.util.Scanner;

public class LineReader {

    private Scanner scanner;

    public LineReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readLine() {
        if (!this.hasMoreLine()) {
            throw new NoMoreLine("The is not more line to read.");
        }
        try {
            return this.scanner.nextLine();
        } catch (Exception e) {
            System.err.println(e);
            return "";
        }
    }

    public Boolean hasMoreLine() {
        return this.scanner.hasNext();
    }

    public static class NoMoreLine extends RuntimeException {
        public NoMoreLine(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
