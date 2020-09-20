package org.kdoluyoruz.trendyol;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe {
    final String USER_1 = "X";
    final String USER_2 = "O";
    final String EMPTY = "";
    List<List<String>> table = new ArrayList<>();

    public void createTable() {
        for (List<String> row : table) {
            for (int i = 0; i < row.size(); i++) {
                row.set(i, EMPTY);
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

        return false;
    }
}
