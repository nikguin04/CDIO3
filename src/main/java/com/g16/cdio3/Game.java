package com.g16.cdio3;

import java.util.Locale;
import java.util.Scanner;

public class Game {
    public static Scanner scanner;
    public static Player[] players;
    private static int roundCount = 0;
    //public static final int tileCount = 24; // TEMPORARY VARIABLE, THIS NEEDS TO BE AUTOMATICALLY SET FROM AN ARRAY LATER!
    public static void main(String[] args) {
        InitializeGame();
    }

    public static void InitializeGame() {
        scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);
        Game_SetupPrompt.Prompt_PlayerCount();
        Game_SetupPrompt.Prompt_PlayerColors();
    }


}
