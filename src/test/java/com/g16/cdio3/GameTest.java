package com.g16.cdio3;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Locale;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class GameTest {
    
    @Test
    public void TestPromptPlayerCount() {
        provideSystemInput("2\n");
        Game.scanner = new Scanner(System.in);
        Game.scanner.useLocale(Locale.ENGLISH);

        Game_SetupPrompt.Prompt_PlayerCount();

        Assert.assertEquals(2, Game.players.length);

        Assert.assertEquals("Player 1", Game.players[0].GetName());
        Assert.assertEquals("Player 2", Game.players[1].GetName());

        Assert.assertEquals(20, Game.players[0].account.GetMoney());
        Assert.assertEquals(20, Game.players[1].account.GetMoney());


    }

    @Test
    public void TestPlayerCountScale() {
        provideSystemInput("2\n3\n4\n");
        Game.scanner = new Scanner(System.in);
        Game.scanner.useLocale(Locale.ENGLISH);

        Game.players = null;
        Game_SetupPrompt.Prompt_PlayerCount();
        Assert.assertEquals(2, Game.players.length);
        Assert.assertEquals("Player 1", Game.players[0].GetName());
        Assert.assertEquals("Player 2", Game.players[1].GetName());
        Assert.assertEquals(20, Game.players[0].account.GetMoney());
        Assert.assertEquals(20, Game.players[1].account.GetMoney());

        Game.players = null;
        Game_SetupPrompt.Prompt_PlayerCount();
        Assert.assertEquals(3, Game.players.length);
        Assert.assertEquals("Player 1", Game.players[0].GetName());
        Assert.assertEquals("Player 2", Game.players[1].GetName());
        Assert.assertEquals("Player 3", Game.players[2].GetName());
        Assert.assertEquals(18, Game.players[0].account.GetMoney());
        Assert.assertEquals(18, Game.players[1].account.GetMoney());
        Assert.assertEquals(18, Game.players[2].account.GetMoney());

        Game.players = null;
        Game_SetupPrompt.Prompt_PlayerCount();
        Assert.assertEquals(4, Game.players.length);
        Assert.assertEquals("Player 1", Game.players[0].GetName());
        Assert.assertEquals("Player 2", Game.players[1].GetName());
        Assert.assertEquals("Player 3", Game.players[2].GetName());
        Assert.assertEquals("Player 4", Game.players[3].GetName());
        Assert.assertEquals(16, Game.players[0].account.GetMoney());
        Assert.assertEquals(16, Game.players[1].account.GetMoney());
        Assert.assertEquals(16, Game.players[2].account.GetMoney());
        Assert.assertEquals(16, Game.players[3].account.GetMoney());
    }

    void provideSystemInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }
}
