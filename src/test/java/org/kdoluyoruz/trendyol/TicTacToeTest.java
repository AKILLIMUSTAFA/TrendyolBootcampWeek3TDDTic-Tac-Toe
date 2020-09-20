package org.kdoluyoruz.trendyol;

import org.assertj.core.api.Java6Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TicTacToeTest {

    TicTacToe sut;

    @BeforeEach
    public void setup() {
        sut = new TicTacToe();
    }

    @AfterEach
    public void cleanup() {
        sut = null;
    }

    @Test
    public void createTable_WhenGameStart_ShouldReturnEmptyTable() {
        //Arrange

        //Act
        sut.createTable();

        //Assert
        assertTrue(sut.isTableEmpty());
    }

    @Test
    public void playUser1_WhenCellIsEmpty_ShouldReturnTrue() {
        //Arrange
        int row = 0;
        int column = 0;

        //Act
        sut.createTable();
        boolean result = sut.playUser1(row, column);

        //Assert
        assertTrue(result);
    }

    @Test
    public void playUser1_WhenRowLimitIsExceeded_ShouldThrowIllegalArgumentException() {
        //Arrange
        int row = 4;
        int column = 1;

        //Act
        sut.createTable();
        Throwable throwable = Java6Assertions.catchThrowable(() -> sut.playUser1(row, column));

        //Assert
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class).hasMessage("Row can not bigger than 2");
    }

    @Test
    public void playUser1_WhenRowLimitIsLowerThan0_ShouldThrowIllegalArgumentException() {
        //Arrange
        int row = -1;
        int column = 1;

        //Act
        sut.createTable();
        Throwable throwable = Java6Assertions.catchThrowable(() -> sut.playUser1(row, column));

        //Assert
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class).hasMessage("Row can not lower than 0");
    }

    @Test
    public void playUser1_WhenColumnLimitIsExceeded_ShouldThrowIllegalArgumentException() {
        //Arrange
        int row = 0;
        int column = 5;

        //Act
        sut.createTable();
        Throwable throwable = Java6Assertions.catchThrowable(() -> sut.playUser1(row, column));

        //Assert
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class).hasMessage("Column can not bigger than 2");
    }

    @Test
    public void playUser1_WhenColumnLimitIsLowerThan0_ShouldThrowIllegalArgumentException() {
        //Arrange
        int row = 1;
        int column = -5;

        //Act
        sut.createTable();
        Throwable throwable = Java6Assertions.catchThrowable(() -> sut.playUser1(row, column));

        //Assert
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class).hasMessage("Column can not lower than 0");
    }

    @Test
    public void playUser1_WhenCellIsNotEmpty_ShouldThrowIllegalStateException() {
        //Arrange
        int row = 0;
        int column = 0;

        //Act
        sut.createTable();
        sut.playUser1(row, column);
        Throwable throwable = Java6Assertions.catchThrowable(() -> sut.playUser1(row, column));

        //Assert
        assertThat(throwable).isInstanceOf(IllegalStateException.class).hasMessage("Cell is not empty!!");
    }

    @Test
    public void playUser1_WhenNotUser1Turn_ShouldThrowIllegalStateException() {
        //Arrange
        int move1_row = 0;
        int move1_column = 0;
        int move2_row = 1;
        int move2_column = 0;

        //Act
        sut.createTable();
        sut.playUser1(move1_row, move1_column);
        Throwable throwable = Java6Assertions.catchThrowable(() -> sut.playUser1(move2_row, move2_column));

        //Assert
        assertThat(throwable).isInstanceOf(IllegalStateException.class).hasMessage("Not User 1's turn!!");
    }

}
