package org.kdoluyoruz.trendyol;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        boolean result = sut.playUser1(row,column);

        //Assert
        assertTrue(result);
    }

}
