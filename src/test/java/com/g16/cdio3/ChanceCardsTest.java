package com.g16.cdio3;

import org.junit.Assert;
import org.junit.Test;

public class ChanceCardsTest {
    
    @Test
    public void TestChanceCardArrayIndexing() {
        Assert.assertEquals("Move to start", ChanceCards.chanceCards[0].getCardName());
        Assert.assertEquals("Move to start, and receive $2", ChanceCards.chanceCards[0].getCardDescription());

        Assert.assertEquals("Birthday card", ChanceCards.chanceCards[1].getCardName());
        Assert.assertEquals("Happy birthday! Everyone gives you $1", ChanceCards.chanceCards[1].getCardDescription());
    }

    @Test
    public void TestChanceCardFunctionCall() {
        Game.players = new Player[] {new Player("p1test", 10, 0)};
        Game.players[0].AddToPosition(5);
        Assert.assertEquals(5, Game.players[0].GetPosition());
        Assert.assertEquals(10, Game.players[0].account.GetMoney());

        ChanceCards.chanceCards[0].ChanceEffect(0);
        Assert.assertEquals(0, Game.players[0].GetPosition());
        Assert.assertEquals(12, Game.players[0].account.GetMoney());
    }

    
}
