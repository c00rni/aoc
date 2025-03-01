package com.adventofcode.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Calculator {

    private ArrayList<Integer> firstList;
    private ArrayList<Integer> secondList;
    private HashMap<Integer, Integer> secondListOccurences;

    public Calculator(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        Collections.sort(list1);
        Collections.sort(list2);
        this.firstList = list1;
        this.secondList = list2;
        this._createSecondListOccurences();
    }

    private void _createSecondListOccurences() {
        this.secondListOccurences = new HashMap<Integer, Integer>();

        for (int i : this.secondList) {
            if (this.secondListOccurences.get(i) != null) {
                this.secondListOccurences.put(i, this.secondListOccurences.get(i) + 1);
            } else {
                this.secondListOccurences.put(i, 1);
            }
        }
    }

    private int _getOccuranceInSecontList(int key) {
        int occurence = 0;
        if (this.secondListOccurences.get(key) != null) {
            occurence = this.secondListOccurences.get(key);
        }
        return occurence;
    }

    public int getSimilarityScore() {
        int similarityScore = 0;
        for (int i : this.firstList) {
            similarityScore += i * this._getOccuranceInSecontList(i);
        }
        return similarityScore;
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
