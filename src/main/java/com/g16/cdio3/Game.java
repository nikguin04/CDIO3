package com.g16.cdio3;

import java.util.Locale;
import java.util.Scanner;

public class Game {
    public static Scanner scanner;
    public static Player[] players;
    private static int roundCount;
    public static void main(String[] args) {
        InitializeGame();
    }

    public static void InitializeGame() {
        scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);
        Prompt_PlayerCount();
    }

    public static void Prompt_PlayerCount() {
        System.out.println("Please input number of players [2-4]");
        while (players == null) { // players have not been set yet, so loop
            int playerCount = scanner.nextInt();
            if (playerCount >= 2 && playerCount <= 4) { // Correct player count entered
                players = new Player[playerCount];
                int startMoney = 20 - (playerCount-2) * 2; // 2 = 20, 3 = 18, 4 = 16
                for (int i = 0; i < playerCount; i++) {
                    players[i] = new Player(String.format("Player %d", i+1), startMoney);
                }
            }
        }
    }
}
