package com.adventofcode.day2;

import java.util.ArrayList;

public class Report {

    private ArrayList<Integer> _levels;
    private LevelChecker _checker;
    private boolean _isIncreasing;

    public Report(ArrayList<Integer> levels, LevelChecker checker) {
        if (levels.size() < 2) {
            throw new TooSmallReport("The report must contains at least 2 levels.");
        }

        this._levels = levels;
        this._checker = checker;
        this._isIncreasing = this.isIncreasing();

    }

    public boolean isIncreasing() {
        return this._levels.get(0) < this._levels.get(1);
    }

    public boolean isSafe() {
        if (this._levels.size() < 2) {
            throw new TooSmallReport("The report must contains at least 2 levels.");
        }

        for (int i = 0; i < this._levels.size() - 1; i++) {
            if (!this._checker.checkAdjacentLevels(this._isIncreasing, this._levels.get(i), this._levels.get(i + 1))) {
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
