package com.adventofcode.day2;

public class Report {

    private int[] levels;

    public Report(int[] levels) {
        this.levels = levels;
    }

    private boolean _isIncreasing() {
        return this.levels[0] < this.levels[1];
    }

    private boolean _isIncreasing(int index1, int index2) {
        return this.levels[index1] < this.levels[index2];
    }

    public boolean isSafe() {
        boolean order = this._isIncreasing();
        for (int index = 1; index < this.levels.length - 1; index++) {
            if (order != this._isIncreasing(index, index + 1)) {
                return false;
            }
        }
        return true;
    }

}
