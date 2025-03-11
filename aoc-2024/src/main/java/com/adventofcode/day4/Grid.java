package com.adventofcode.day4;

class Grid {
    private String[] rows;

    public Grid() {
        this.rows = new String[0]; // Initialize empty
    }

    public int getLines() {
        return rows.length;
    }

    public int getColumns() {
        if (rows.length == 0)
            return 0;
        return rows[0].length();
    }

    public void addLine(String line) {
        // Add a new row to the grid
        String[] newRows = new String[rows.length + 1];
        System.arraycopy(rows, 0, newRows, 0, rows.length);
        newRows[rows.length] = line;
        rows = newRows;
    }

    public char getChar(int row, int column) {
        if (row < 0 || row >= rows.length) {
            throw new IndexOutOfBoundsException("Row index out of bounds");
        }
        String rowStr = rows[row];
        if (column < 0 || column >= rowStr.length()) {
            throw new IndexOutOfBoundsException("Column index out of bounds");
        }
        return rowStr.charAt(column);
    }
}
