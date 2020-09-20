package org.kdoluyoruz.trendyol;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe {
    final String USER_1 = "X";
    final String USER_2 = "O";
    final String EMPTY = "";
    final int ROW_LIMIT = 3;
    final int COLUMN_LIMIT = 3;
    List<List<String>> table = new ArrayList<>();

    public void createTable() {

        for (int i = 0; i < ROW_LIMIT; i++) {
            table.add(new ArrayList<>());
            for (int j = 0; j < COLUMN_LIMIT; j++) {
                table.get(i).add(EMPTY);
            }
        }
    }


    public boolean isTableEmpty() {
        for (List<String> row : table) {
            for (String cell : row) {
                if (!cell.equals(EMPTY)) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<List<String>> getTable() {
        return table;
    }

    public boolean playUser1(int row, int column) {

        if (row > ROW_LIMIT)
            throw new IllegalArgumentException("Row can not bigger than 2");

        if (row < 0)
            throw new IllegalArgumentException("Row can not lower than 0");

        if (column > COLUMN_LIMIT)
            throw new IllegalArgumentException("Column can not bigger than 2");

        if (column < 0)
            throw new IllegalArgumentException("Column can not lower than 0");


        if (table.get(row).get(column).equals(EMPTY)) {
            table.get(row).set(column, USER_1);
            return true;
        }

        throw new IllegalStateException("Cell is not empty!!");
    }
}
