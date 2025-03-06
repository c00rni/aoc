package com.adventofcode.day3;

class Calculator {
    private int _total;

    public Calculator() {
        this._total = 0;
    }

    public int multiply(int operand1, int operand2) {
        return operand1 * operand2;
    }

    public void add(int number) {
        this._total += number;
    }

    public int getTotal() {
        return this._total;
    }
}
