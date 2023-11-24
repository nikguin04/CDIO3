package com.g16.cdio3;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import com.g16.cdio3.Game.SortByMoney;

public class GameTest {
    
    @Test
    public void TestPromptPlayerCount() {
        Game.players = null;
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

    @Test
    public void TestColorInput() {
        provideSystemInput("4\n");
        provideSystemInput("-1\n");
        provideSystemInput("abc\n");
        provideSystemInput("2\n");
        Game.scanner = new Scanner(System.in);
        Game.scanner.useLocale(Locale.ENGLISH);

        Game.players = new Player[] {new Player("Player 1", 10, 0)};
        Game_SetupPrompt.Prompt_PlayerColors();

        Assert.assertEquals(2, Game.players[0].GetColor());
    }

    void provideSystemInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    public void TestSortPropertyValueLogic() {
        Player p1 = new Player("P1", 100, 0);
        p1.SetPropertyValue(100);
        
        Player p2 = new Player("P2", 100, 1);
        p2.SetPropertyValue(120);

        Player p3 = new Player("P3", 100, 2);
        p3.SetPropertyValue(90);

        Player[] arr = new Player[] {p1,p2,p3};
        Arrays.sort(arr, new Game.SortByMoney());

        Assert.assertEquals(arr[0].playerId, 1);
        Assert.assertEquals(arr[1].playerId, 0);
        Assert.assertEquals(arr[2].playerId, 2);
    }

    @Test
    public void TestSortMoneyLogic() {
        Player p1 = new Player("P1", 200, 0);
        p1.SetPropertyValue(100);
        
        Player p2 = new Player("P2", 100, 1);
        p2.SetPropertyValue(120);

        Player p3 = new Player("P3", 400, 2);
        p3.SetPropertyValue(90);

        Player[] arr = new Player[] {p1,p2,p3};
        Arrays.sort(arr, new Game.SortByMoney());

        Assert.assertEquals(arr[0].playerId, 2);
        Assert.assertEquals(arr[1].playerId, 0);
        Assert.assertEquals(arr[2].playerId, 1);
    }

    @Test
    public void TestConflictWinLogic() {
        Player p1 = new Player("P1", 100, 0);
        p1.SetPropertyValue(100);
        
        Player p2 = new Player("P2", 100, 1);
        p2.SetPropertyValue(120);

        Player p3 = new Player("P3", 40, 2);
        p3.SetPropertyValue(200);

        Player[] arr = new Player[] {p1,p2,p3};
        Arrays.sort(arr, new Game.SortByMoney());

        Assert.assertEquals(arr[0].playerId, 1);
        Assert.assertEquals(arr[1].playerId, 0);
        Assert.assertEquals(arr[2].playerId, 2);
    }
}
