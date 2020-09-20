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
    String userTurn;
    String winnerUserSymbol;

    public void createTable() {

        userTurn = USER_1;
        winnerUserSymbol = EMPTY;

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

    public boolean playUser1(int row, int column) {

        if (!isUser1Turn())
            throw new IllegalStateException("Not User 1's turn!!");

        return play(USER_1, row, column);
    }

    public boolean playUser2(int row, int column) {

        if (isUser1Turn())
            throw new IllegalStateException("Not User 2's turn!!");

        return play(USER_2, row, column);
    }

    private boolean play(String userSymbol, int row, int column) {
        if (row > ROW_LIMIT)
            throw new IllegalArgumentException("Row can not bigger than 2");

        if (row < 0)
            throw new IllegalArgumentException("Row can not lower than 0");

        if (column > COLUMN_LIMIT)
            throw new IllegalArgumentException("Column can not bigger than 2");

        if (column < 0)
            throw new IllegalArgumentException("Column can not lower than 0");

        if (table.get(row).get(column).equals(EMPTY)) {
            table.get(row).set(column, userSymbol);
            changeUserTurn();
            checkGameOver();
            return true;
        }

        throw new IllegalStateException("Cell is not empty!!");
    }

    private boolean isUser1Turn() {
        return userTurn.equals(USER_1);
    }

    private void changeUserTurn() {
        if (userTurn.equals(USER_1))
            userTurn = USER_2;
        else
            userTurn = USER_1;
    }

    public boolean isGameOver() {

        if (winnerUserSymbol.equals(EMPTY))
            return false;

        return true;
    }

    private void checkGameOver() {

        String currentRowWinnerSymbol = getRowWinnerSymbol();
        if (!currentRowWinnerSymbol.equals(EMPTY)) {
            winnerUserSymbol = currentRowWinnerSymbol;
            return;
        }

        String currentColumnWinnerSymbol = getColumnWinnerSymbol();
        if (!currentColumnWinnerSymbol.equals(EMPTY)) {
            winnerUserSymbol = currentColumnWinnerSymbol;
            return;
        }

        String currentCrossWinnerSymbol = getCrossWinnerSymbol();
        if (!currentCrossWinnerSymbol.equals(EMPTY)) {
            winnerUserSymbol = currentCrossWinnerSymbol;
            return;
        }
    }

    private String getRowWinnerSymbol() {
        for (int i = 0; i < ROW_LIMIT; i++) {

            boolean isAllRowSame = true;

            for (int j = 0; j < COLUMN_LIMIT - 1; j++) {
                if (!table.get(i).get(j).equals(table.get(i).get(j + 1))) {
                    isAllRowSame = false;
                    break;
                }
            }

            if (isAllRowSame)
                return table.get(i).get(0);
        }
        return EMPTY;
    }

    private String getColumnWinnerSymbol() {

        for (int i = 0; i < COLUMN_LIMIT; i++) {

            boolean isAllColumnSame = true;

            for (int j = 0; j < ROW_LIMIT - 1; j++) {
                if (!table.get(j).get(i).equals(table.get(j + 1).get(i))) {
                    isAllColumnSame = false;
                    break;
                }
            }

            if (isAllColumnSame)
                return table.get(0).get(i);
        }
        return EMPTY;
    }

    private String getCrossWinnerSymbol() {

        if ((table.get(0).get(0).equals(table.get(1).get(1)) && table.get(0).get(0).equals(table.get(2).get(2))) ||
                (table.get(0).get(2).equals(table.get(1).get(1)) && table.get(0).get(2).equals(table.get(2).get(0)))) {

            return table.get(1).get(1);
        }

        return EMPTY;
    }

    public String getWinnerName() {

        return EMPTY;
    }
}
