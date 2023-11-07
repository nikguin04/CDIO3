package com.g16.cdio3;

import java.util.Locale;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Game.scanner = new Scanner(System.in);
        Game.scanner.useLocale(Locale.ENGLISH);
        Game.players = new Player[] {new Player("Player 1", 10)};
        Game_SetupPrompt.Prompt_PlayerColors();
    }
}
