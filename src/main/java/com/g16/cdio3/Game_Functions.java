package com.g16.cdio3;

public class Game_Functions {
    
    public static void PrintGame() {

        for (int i = 0; i < Board.getSquareCount(); i++) {
            BoardSquare square = Board.getSquare(i);
            if (square.getClass() == BoardSquare_Place.class) {
                BoardSquare_Place pSquare = (BoardSquare_Place) square;
                System.out.println(pSquare.sgr_color_fg + pSquare.squareName + " $" + pSquare.squarePrice + GameData.SGR_CLEAR);
            } else {
                System.out.println(square.GetSquareName());
            }
            
        }
    }
}
