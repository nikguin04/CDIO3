package com.g16.cdio3;
import com.g16.cdio3.Player;

import org.junit.Assert;
import org.junit.Test;


public class PlayerTest {
    
    @Test
    public void PlayerCreation() {
        Player player = new Player("NameTest", 100);
        Assert.assertEquals("NameTest", player.GetName());
        Assert.assertEquals(100, player.account.GetMoney());
    }

    @Test
    public void SetPlayerName() {
        Player player = new Player("NameTest", 100);
        Assert.assertEquals("NameTest", player.GetName());

        player.SetName("NewName123");
        Assert.assertEquals("NewName123", player.GetName());
    }

    @Test
    public void PlayerAccountReferenceTest() {
        Player player = new Player("NameTest", 1000);
        Assert.assertEquals(1000, player.account.GetMoney());

        player.account.ModifyMoney(100);
        Assert.assertEquals(1100, player.account.GetMoney());
    }

    @Test
    public void PositionTest() {
        Player player = new Player("NameTest", 1000);
        Assert.assertEquals(0, player.GetPosition());

        Assert.assertEquals(false, player.AddToPosition(5));
        Assert.assertEquals(5, player.GetPosition());

        //loops over to 0 at 24
        Assert.assertEquals(true, player.AddToPosition(19));
        Assert.assertEquals(0, player.GetPosition());
        
        Assert.assertEquals(false, player.AddToPosition(5));
        Assert.assertEquals(5, player.GetPosition());

        //loops over to 0 at 24
        Assert.assertEquals(true, player.AddToPosition(25));
        Assert.assertEquals(6, player.GetPosition());
    }


        @Test
    public void PrisonTest() {
        Player player = new Player("NameTest", 1000);
        Assert.assertEquals(false, player.isInPrison());

        player.SetPrisonStatus(false);
        Assert.assertEquals(false, player.isInPrison());

        player.SetPrisonStatus(true);
        Assert.assertEquals(true, player.isInPrison());
    }

    @Test
    public void TestColorSetting() {
        Player player = new Player("NameTest", 1000);
        Assert.assertEquals(-1, player.GetColor());
        Assert.assertTrue(player.SetColor(2));
        Assert.assertEquals(2, player.GetColor());
        Assert.assertFalse(player.SetColor(1));

    }
}
