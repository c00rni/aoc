package com.adventofcode.day1;

import java.util.ArrayList;
import java.util.Collections;

public class Calculator {

    private ArrayList<Integer> firstList;
    private ArrayList<Integer> secondList;

    public Calculator(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        Collections.sort(list1);
        Collections.sort(list2);
        this.firstList = list1;
        this.secondList = list2;
    }

    public int sumDifference() {
        if (this.firstList.size() != this.secondList.size()) {
            throw new NoEqualListSize("List must have the same size.");
        }
        int result = 0;
        for (int count = 0; count < this.firstList.size(); count++) {
            result += Math.abs(this.firstList.get(count) - this.secondList.get(count));
        }
        return result;
    }

    public ArrayList<Integer> getFirstList() {
        return this.firstList;
    }

    public ArrayList<Integer> getSecondList() {
        return this.secondList;
    }

    public static class NoEqualListSize extends RuntimeException {
        public NoEqualListSize(String message) {
            super(message);
        }
    }

}
