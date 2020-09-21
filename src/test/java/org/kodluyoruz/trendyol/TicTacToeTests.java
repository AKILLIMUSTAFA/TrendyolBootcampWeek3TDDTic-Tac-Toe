package org.kodluyoruz.trendyol;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TicTacToeTests {

    TicTacToe sut;

    @BeforeEach
    public void setup() {
        sut = new TicTacToe();
        sut.createTable();
    }

    @AfterEach
    public void cleanup() {
        sut = null;
    }

    @Test
    public void createTable_WhenGameStart_ShouldReturnEmptyTable() {
        //Arrange

        //Act

        //Assert
        assertTrue(sut.isTableEmpty());
    }

    @Test
    public void playUser1_WhenCellIsEmpty_ShouldReturnTrue() {
        //Arrange
        int row = 0;
        int column = 0;

        //Act
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
        Throwable throwable = catchThrowable(() -> sut.playUser1(row, column));

        //Assert
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class).hasMessage("Row can not bigger than 2");
    }

    @Test
    public void playUser1_WhenRowLimitIsLowerThan0_ShouldThrowIllegalArgumentException() {
        //Arrange
        int row = -1;
        int column = 1;

        //Act
        Throwable throwable = catchThrowable(() -> sut.playUser1(row, column));

        //Assert
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class).hasMessage("Row can not lower than 0");
    }

    @Test
    public void playUser1_WhenColumnLimitIsExceeded_ShouldThrowIllegalArgumentException() {
        //Arrange
        int row = 0;
        int column = 5;

        //Act
        Throwable throwable = catchThrowable(() -> sut.playUser1(row, column));

        //Assert
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class).hasMessage("Column can not bigger than 2");
    }

    @Test
    public void playUser1_WhenColumnLimitIsLowerThan0_ShouldThrowIllegalArgumentException() {
        //Arrange
        int row = 1;
        int column = -5;

        //Act
        Throwable throwable = catchThrowable(() -> sut.playUser1(row, column));

        //Assert
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class).hasMessage("Column can not lower than 0");
    }

    @Test
    public void playUser2_WhenCellIsNotEmpty_ShouldThrowIllegalStateException() {
        //Arrange
        int row = 0;
        int column = 0;

        //Act
        sut.playUser1(row, column);
        Throwable throwable = catchThrowable(() -> sut.playUser2(row, column));

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
        sut.playUser1(move1_row, move1_column);
        Throwable throwable = catchThrowable(() -> sut.playUser1(move2_row, move2_column));

        //Assert
        assertThat(throwable).isInstanceOf(IllegalStateException.class).hasMessage("Not User 1's turn!!");
    }

    @Test
    public void playUser2_WhenNotUser2Turn_ShouldThrowIllegalStateException() {
        //Arrange
        int move1_row = 0;
        int move1_column = 0;
        int move2_row = 1;
        int move2_column = 0;

        //Act
        sut.playUser1(2, 2);
        sut.playUser2(move1_row, move1_column);
        Throwable throwable = catchThrowable(() -> sut.playUser2(move2_row, move2_column));

        //Assert
        assertThat(throwable).isInstanceOf(IllegalStateException.class).hasMessage("Not User 2's turn!!");
    }

    @Test
    public void isGameOver_WhenUser1HasSideBySideSymbols_ReturnTrue() {

        // Arrange

        // Act
        sut.playUser1(0, 0);
        sut.playUser2(1, 0);
        sut.playUser1(0, 1);
        sut.playUser2(2, 0);
        boolean result1 = sut.isGameOver();
        sut.playUser1(0, 2);
        boolean result2 = sut.isGameOver();

        // Assert
        assertFalse(result1);
        assertTrue(result2);
    }

    @Test
    public void isGameOver_WhenUser1HasOneUnderTheOtherSymbols_ReturnTrue() {

        // Arrange

        // Act
        sut.playUser1(0, 0);
        sut.playUser2(0, 1);
        sut.playUser1(1, 0);
        sut.playUser2(0, 2);
        boolean result1 = sut.isGameOver();
        sut.playUser1(2, 0);
        boolean result2 = sut.isGameOver();

        // Assert
        assertFalse(result1);
        assertTrue(result2);
    }

    @Test
    public void isGameOver_WhenUser1HasCrossedSymbols_ReturnTrue() {

        // Arrange

        // Act
        sut.playUser1(0, 2);
        sut.playUser2(0, 1);
        sut.playUser1(1, 1);
        sut.playUser2(1, 2);
        boolean result1 = sut.isGameOver();
        sut.playUser1(2, 0);
        boolean result2 = sut.isGameOver();

        // Assert
        assertFalse(result1);
        assertTrue(result2);
    }

    @Test
    public void getWinnerName_WhenGameOverIfWinnerExists_ReturnWinnerName() {

        // Arrange

        // Act
        sut.playUser1(0, 2);
        sut.playUser2(0, 1);
        sut.playUser1(1, 1);
        sut.playUser2(1, 2);
        sut.playUser1(2, 0);

        String result = sut.getWinnerName();

        // Assert
        assertThat(result).isEqualTo("User1");
    }

    @Test
    public void getWinnerName_WhenGameOverIfWinnerDoesNotExists_ReturnNoWinner() {

        // Arrange

        // Act
        /*
        0 X 0
        X 0 0
        X 0 X   */

        sut.playUser1(0, 0);
        sut.playUser2(0, 1);
        sut.playUser1(0, 2);


        sut.playUser2(1, 0);
        sut.playUser1(1, 1);
        sut.playUser2(2, 0);


        sut.playUser1(1, 2);
        sut.playUser2(2, 2);
        sut.playUser1(2, 1);



        String result = sut.getWinnerName();

        // Assert
        assertThat(result).isEqualTo("No Winner");
    }

    @Test
    public void getWinnerName_WhenGameDoesNotOver_ThrowIllegalStateException() {

        // Arrange

        // Act
        sut.playUser1(0, 0);
        sut.playUser2(0, 1);
        sut.playUser1(0, 2);


        sut.playUser2(1, 0);
        sut.playUser1(1, 1);
        sut.playUser2(2, 0);

        Throwable throwable = catchThrowable(() -> sut.getWinnerName());

        //Assert
        assertThat(throwable).isInstanceOf(IllegalStateException.class).hasMessage("Game Does Not Over Yet!!");
    }




}
