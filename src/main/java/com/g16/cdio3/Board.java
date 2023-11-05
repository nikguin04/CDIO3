package com.g16.cdio3;

public class Board {
    private static BoardSquare[] boardSquares = new BoardSquare[] {
        new BoardSquare_NonAction("Start"),
        new BoardSquare_Place("Burger Bar", 1, 2, "Bright Green", GameData.escapeChar + "[92m"),
        new BoardSquare_Place("Pizza Hut", 1, 1, "Bright Green", GameData.escapeChar + "[92m"),
        new BoardSquare_Chance(),
        new BoardSquare_Place("Candy Store", 1, 5, "Bright Blue", GameData.escapeChar + "[94m"),
        new BoardSquare_Place("Ice Cream Store", 1, 4, "Bright Blue", GameData.escapeChar + "[94m"),
        new BoardSquare_NonAction("Jail"),
        new BoardSquare_Place("Museum", 2, 8, "Bright Red", GameData.escapeChar + "[91m"),
        new BoardSquare_Place("Library", 2, 7, "Bright Red", GameData.escapeChar + "[91m"),
        new BoardSquare_Chance(),
        new BoardSquare_Place("Skate Park", 2, 11, "Bright Yellow", GameData.escapeChar + "[93m"),
        new BoardSquare_Place("Swimming Pool", 2, 10, "Bright Yellow", GameData.escapeChar + "[93m"),
        new BoardSquare_NonAction("Free Parking"),
        new BoardSquare_Place("Game Hall", 3, 14, "Dark Red", GameData.escapeChar + "[31m"),
        new BoardSquare_Place("Cinema", 3, 13, "Dark Red", GameData.escapeChar + "[31m"),
        new BoardSquare_Chance(),
        new BoardSquare_Place("Toy Store", 3, 17, "Dark Yellow", GameData.escapeChar + "[33m"),
        new BoardSquare_Place("Pet Store", 3, 16, "Dark Yellow", GameData.escapeChar + "[33m"),
        new BoardSquare_GoJail(),
        new BoardSquare_Place("Bowling Alley", 4, 20, "Dark Green", GameData.escapeChar + "[32m"),
        new BoardSquare_Place("Zoo", 4, 19, "Dark Green", GameData.escapeChar + "[32m"),
        new BoardSquare_Chance(),
        new BoardSquare_Place("Water Park", 4, 23, "Dark Blue", GameData.escapeChar + "[34m"),
        new BoardSquare_Place("The Pier", 4, 22, "Dark Blue", GameData.escapeChar + "[34m")
    };

    public static BoardSquare getSquare(int square) {
        return boardSquares[square];
    }
    public static int getSquareCount() {
        return boardSquares.length;
    }
}
