package com.adventofcode.day4;

class Searcher {
    private Grid grid;
    private String searchTerm;

    public Searcher(Grid grid, String searchTerm) {
        this.grid = grid;
        this.searchTerm = searchTerm;
    }

    public boolean check(int rowIndex, int columnIndex, char searchedCharacter) {
        return grid.getChar(rowIndex, columnIndex) == searchedCharacter;
    }

    public boolean search(Direction direction, int row, int column) {
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

    public int countAllOccurrences() {
        int count = 0;
        int rows = grid.getLines();
        int cols = grid.getColumns();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                for (Direction dir : Direction.values()) {
                    if (search(dir, row, col)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

}
