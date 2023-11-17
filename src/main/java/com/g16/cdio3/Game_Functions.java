package com.g16.cdio3;

public class Game_Functions {
    private static final int nonPlaceOffset = 3;
    public static void PrintGame() {
        //GameData.ClearScreen();
        for (int i = 0; i < Board.getSquareCount(); i++) {
            BoardSquare square = Board.getSquare(i);
            System.out.print(getPlayerPos(i) + " "); // Players printout
            if (square.getClass() == BoardSquare_Place.class) {
                BoardSquare_Place pSquare = (BoardSquare_Place) square;
                System.out.print("(" + (!pSquare.isOwned() ? "■" : GameData.colorIndex[Game.players[pSquare.GetOwner()].GetColor()].sgr_color_fg + "■" + GameData.SGR_CLEAR) + ")"); // Print owner of square
                System.out.println(pSquare.GetColoredName());
            } else {
                System.out.println(" ".repeat(nonPlaceOffset) +  square.GetSquareName());
            }
            
        }
    }

    private static String getPlayerPos(int pos) {
        String toret = "|";
        for (Player p: Game.players) {
            if (p.GetPosition() == pos) {
                toret += GameData.colorIndex[p.GetColor()].sgr_color_fg + "■" + GameData.SGR_CLEAR;
            } else {
                toret += " ";
            }

            toret += "|";
        }
        return toret;
    }


    public static final int scoreBoardOffset = 45;
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
