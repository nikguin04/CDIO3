package com.g16.cdio3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

public class Game {
    public static Scanner scanner;
    public static Player[] players;
    private static int roundCount = 0;

    public static void main(String[] args) {
        InitializeGame();

        StartGame();
    }

    public static void InitializeGame() {
        scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);
        Game_SetupPrompt.Prompt_PlayerCount();
        Game_SetupPrompt.Prompt_PlayerColors();
    }


    public static void StartGame() {
        GameData.ClearScreen();
        Game_Functions.PrintGame();
        Dice dice = new Dice(1, 6);
        while (true) {
            for (int i = 0; i < players.length; i++) {

                Player p = players[i];

                System.out.println(p.GetColoredName()+" press enter to roll the dice!");
                scanner.nextLine();
                GameData.ClearRestOfScreen();

                Dice.DiceThrow dt = dice.DiceThrow();
                System.out.print(p.GetColoredName()+" rolled "+ dt.addedResult);
                
                boolean passedStart = p.AddToPosition(dt.addedResult);
                BoardSquare landedSquare = Board.getSquare(p.GetPosition());
                System.out.println(" and landed on: " + ((landedSquare.getClass() != BoardSquare_Place.class) ? landedSquare.GetSquareName() : ((BoardSquare_Place)landedSquare).GetColoredName()));
                landedSquare.TileEffect(i);

                GameData.GotoTopOfScreen();
                Game_Functions.PrintGame();
            }
        }
    }

    static class SortByMoney implements Comparator<Player> {
        public int compare(Player a, Player b)
        {
            // Check if money is equal, if not, then return the money difference, if equal, return property value difference
            return (a.account.GetMoney() != b.account.GetMoney()) ? b.account.GetMoney() - a.account.GetMoney() : b.GetPropertyValue() - a.GetPropertyValue();
        }
    }
    public static void LoseGame(int playerIndex){
        Player[] pArray = new Player[Game.players.length];
        for (int i = 0; i < Game.players.length; i++) {
            Player p = Game.players[i];
            p.UpdatePropertyValue();
            pArray[i] = p;  
        }
    
        
        Arrays.sort(pArray, new SortByMoney());
        
    }

}