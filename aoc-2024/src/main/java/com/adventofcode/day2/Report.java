package com.adventofcode.day2;

import java.util.ArrayList;

public class Report {

    private ArrayList<Integer> levels;

    public Report(ArrayList<Integer> levels) {
        this.levels = levels;
    }

    private boolean _isIncreasing() {
        if (this.levels.size() < 2) {
            throw new TooSmallReport("The report must contains at least 2 levels.");
        }
        return this.levels.get(0) < this.levels.get(1);
    }

    private boolean _inRange(int index1, int index2, int min, int max) {
        int diff = Math.abs(this.levels.get(index1) - this.levels.get(index2));
        return diff >= min && diff <= max;
    }

    private boolean _isIncreasing(int index1, int index2) {
        if (this.levels.size() < 2) {
            throw new TooSmallReport("The report must contains at least 2 levels.");
        }
        return this.levels.get(index1) < this.levels.get(index2);
    }

    public boolean isSafe() {
        boolean order = this._isIncreasing();
        for (int index = 0; index < this.levels.size() - 1; index++) {
            if (order != this._isIncreasing(index, index + 1) || !this._inRange(index, index + 1, 1, 3)) {
                return false;
            }
        }
        return true;
    }

    public static class TooSmallReport extends RuntimeException {
        public TooSmallReport(String message) {
            super(message);
        }
    }

}
