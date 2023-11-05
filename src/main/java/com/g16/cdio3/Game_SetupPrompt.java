package com.g16.cdio3;

public class Game_SetupPrompt {
    public static void Prompt_PlayerCount() {
        System.out.println("Please input number of players [2-4]");
        while (Game.players == null) { // players have not been set yet, so loop
            int playerCount = Game.scanner.nextInt();
            if (playerCount >= 2 && playerCount <= 4) { // Correct player count entered
                Game.players = new Player[playerCount];
                int startMoney = 20 - (playerCount-2) * 2; // 2 = 20, 3 = 18, 4 = 16
                for (int i = 0; i < playerCount; i++) {
                    Game.players[i] = new Player(String.format("Player %d", i+1), startMoney);
                }
            }
        }
    }

    public static void Prompt_PlayerColors() {
        System.out.println("Please choose a color for all players:");

        for (int i = 0; i < Game.players.length; i++) {
            
        }
    }
}
