package com.adventofcode.day2;

interface LevelChecker {
    public boolean checkAdjacentLevels(boolean direction, Integer firstLevelValue, Integer secondLevelValue);
}

public class Checker implements LevelChecker {

    public Checker() {
    }

    public Integer difference(Integer firstLevel, Integer secondeLevel) {
        return Math.abs(firstLevel - secondeLevel);
    }

    public boolean isIncreasing(Integer fistLevel, Integer secondLevel) {
        return fistLevel < secondLevel;
    }

    public boolean checkAdjacentLevels(boolean direction, Integer firstLevelValue, Integer secondLevelValue) {
        Integer difference = this.difference(firstLevelValue, secondLevelValue);
        boolean isValidDifference = difference >= 1 && difference <= 3;
        boolean isSameDirection = direction == this.isIncreasing(firstLevelValue, secondLevelValue);
        return isSameDirection && isValidDifference;
    }

}
