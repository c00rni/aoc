package com.adventofcode.day4;

class Searcher {
    private Grid grid;

    public Searcher(Grid grid) {
        this.grid = grid;
    }

    public boolean check(int rowIndex, int columnIndex, char searchedCharacter) {
        return grid.getChar(rowIndex, columnIndex) == searchedCharacter;
    }

    public boolean search(Direction direction, int row, int column, String searchTerm) {
        int rowDelta = direction.getRowDelta();
        int colDelta = direction.getColumnDelta();
        int length = searchTerm.length();

        for (int i = 0; i < length; i++) {
            int currentRow = row + i * rowDelta;
            int currentCol = column + i * colDelta;
            try {
                if (!check(currentRow, currentCol, searchTerm.charAt(i))) {
                    return false;
                }
            } catch (IndexOutOfBoundsException e) {
                return false;
            }
        }
        return true;
    }

    public int countAllOccurrences(String seachTerm) {
        int count = 0;
        int rows = grid.getLines();
        int cols = grid.getColumns();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                for (Direction dir : Direction.values()) {
                    if (search(dir, row, col, seachTerm)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int countAllMASinX() {
        int count = 0;
        int rows = grid.getLines();
        int cols = grid.getColumns();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // Check if current cell contains 'A'
                if (grid.getChar(row, col) != 'A') {
                    continue;
                }

                boolean leftDiagonal = search(Direction.UPPER_LEFT, row, col, "AM")
                        && search(Direction.DOWN_RIGHT, row, col, "AS")
                        || search(Direction.UPPER_LEFT, row, col, "AS") && search(Direction.DOWN_RIGHT, row, col, "AM");
                boolean rightDiagonal = search(Direction.UPPER_RIGHT, row, col, "AM")
                        && search(Direction.DOWN_LEFT, row, col, "AS")
                        || search(Direction.UPPER_RIGHT, row, col, "AS") && search(Direction.DOWN_LEFT, row, col, "AM");
                if (leftDiagonal && rightDiagonal) {
                    count++;
                }
            }
        }
        return count;
    }

}
