package org.kdoluyoruz.trendyol;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(true, sut.isTableEmpty());
    }

}
