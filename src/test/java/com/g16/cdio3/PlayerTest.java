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
}
