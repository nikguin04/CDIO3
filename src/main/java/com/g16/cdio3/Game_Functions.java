package com.g16.cdio3;

public class Game_Functions {
    
    public static void PrintGame() {
        GameData.ClearScreen();
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

    public static final int scoreBoardOffset = 30;
    public static void PrintScoreBoard() {
        System.out.print(GameData.escapeChar + "[s"); // Save cursor position
        System.out.print(GameData.escapeChar + "[H"); // Home cursor

        for (int i = 0; i < Game.players.length; i++) {
            Player p = Game.players[i];
            System.out.print(GameData.escapeChar + "[" + scoreBoardOffset + "G"); // Move cursor to scoreBoardOffset on current line
            System.out.println(p.GetColoredName() + " $" + p.account.GetMoney());
        }

        System.out.print(GameData.escapeChar + "[u"); // Return cursor to saved state
    }
}
