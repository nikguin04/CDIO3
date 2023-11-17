package com.g16.cdio3;

import org.junit.Assert;
import org.junit.Test;

public class BoardTest {
    
    @Test
    public void TestBoardSquareCount() {
        Assert.assertEquals(24, Board.getSquareCount());
    }

    @Test
    public void TestGetBoardSquareNames() {
        Assert.assertEquals("Start", Board.getSquare(0).GetSquareName());
        Assert.assertEquals("Burger Bar", Board.getSquare(1).GetSquareName());
        Assert.assertEquals("Chance", Board.getSquare(3).GetSquareName());
        Assert.assertEquals("Jail", Board.getSquare(6).GetSquareName());
        Assert.assertEquals("Go To Jail", Board.getSquare(18).GetSquareName());
        Assert.assertEquals("The Pier", Board.getSquare(23).GetSquareName());
    }

    @Test
    public void TestBoardSquarePlaceMask() {
        BoardSquare_Place square = (BoardSquare_Place)Board.getSquare(1);
        Assert.assertEquals(1, square.squarePrice);
        Assert.assertEquals(2, square.squareTwinPosition);
    }

    @Test
    public void TestBoardSquareTwinsClasses() {
        for (int i = 0; i < Board.getSquareCount(); i++) {
            BoardSquare sq = Board.getSquare(i);
            if (sq.getClass() == BoardSquare_Place.class) {
                BoardSquare_Place place_sq = (BoardSquare_Place) sq;
                Assert.assertEquals(Board.getSquare(place_sq.squareTwinPosition).getClass(), BoardSquare_Place.class);
            }
        }
    }

}
