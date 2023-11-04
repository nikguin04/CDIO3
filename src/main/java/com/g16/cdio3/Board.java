package com.g16.cdio3;

public class Board {
    private static BoardSquare[] boardSquares = new BoardSquare[] {
        new BoardSquare_NonAction("Start"),
        new BoardSquare_Place("Burger Bar", 1, 2),
        new BoardSquare_Place("Pizza Hut", 1, 1),
        new BoardSquare_Chance(),
        new BoardSquare_Place("Candy Store", 1, 5),
        new BoardSquare_Place("Ice Cream Store", 1, 4),
        new BoardSquare_NonAction("Jail"),
        new BoardSquare_Place("Museum", 2, 8),
        new BoardSquare_Place("Library", 2, 7),
        new BoardSquare_Chance(),
        new BoardSquare_Place("Skate Park", 2, 11),
        new BoardSquare_Place("Swimming Pool", 2, 10),
        new BoardSquare_NonAction("Free Parking"),
        new BoardSquare_Place("Game Hall", 3, 14),
        new BoardSquare_Place("Cinema", 3, 13),
        new BoardSquare_Chance(),
        new BoardSquare_Place("Toy Store", 3, 17),
        new BoardSquare_Place("Pet Store", 3, 16),
        new BoardSquare_GoJail(),
        new BoardSquare_Place("Bowling Alley", 4, 20),
        new BoardSquare_Place("Zoo", 4, 19),
        new BoardSquare_Chance(),
        new BoardSquare_Place("Water Park", 4, 23),
        new BoardSquare_Place("The Pier", 4, 22)
    };

    public static BoardSquare getSquare(int square) {
        return boardSquares[square];
    }
    public static int getSquareCount() {
        return boardSquares.length;
    }
}
