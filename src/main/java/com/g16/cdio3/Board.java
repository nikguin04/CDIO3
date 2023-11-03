package com.g16.cdio3;

public class Board {
    private BoardSquare[] boardSquares = new BoardSquare[] {
        new BoardSquare_NonAction("Start"),
        new BoardSquare_Place("Burger Bar", 1, 2),
        new BoardSquare_Place("Pizza Hut", 1, 1),
        new BoardSquare_Chance(),
        new BoardSquare_Place("Candy Store", 1, 5),
        new BoardSquare_Place("Ice Cream Store", 1, 4),
        new BoardSquare_NonAction("Jail"),
        
    };

    public BoardSquare getSquare(int square) {
        return boardSquares[square];
    }
}
