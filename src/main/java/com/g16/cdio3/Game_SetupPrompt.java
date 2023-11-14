package com.g16.cdio3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game_SetupPrompt {
    public static void Prompt_PlayerCount() {
        GameData.ClearScreen();
        System.out.println("Please input number of players [2-4]");
        while (Game.players == null) { // players have not been set yet, so loop
            int playerCount = GameData.WaitForInt();
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
        GameData.ClearScreen();
        System.out.println("Please choose a color for all players:");

        for (int i = 0; i < Game.players.length; i++) {
            
            Player player = Game.players[i];
            System.out.println("Please choose a color for: " + player.GetName());
            System.out.println("Please input a number according to the available colors:");
            for (Color col: GameData.colorIndex) {
                System.out.println((col.chosen ? GameData.SGR_STRIKETHROUGH: "") + col.sgr_color_fg + "[" + col.index + "] " + col.name + GameData.SGR_CLEAR);
            }
            while (player.GetColor() == -1) {
                int scanned = GameData.WaitForInt();
                if (scanned >= 0 && scanned < GameData.colorIndex.length && !GameData.colorIndex[scanned].chosen) {
                    Color col = GameData.colorIndex[scanned];
                    player.SetColor(scanned);
                    col.chosen = true;
                    GameData.ClearScreen();
                    System.out.println(player.GetColoredName() + ", You choose the color: " + col.sgr_color_fg + col.name  + "!" + GameData.SGR_CLEAR);
                }
            }
        }
    }

}
