package com.g16.cdio3;
import com.g16.cdio3.Account;

import org.junit.Assert;
import org.junit.Test;

public class AccountTest {
    
    @Test
    public void AddToAccountBalance() {
        Account account = new Account(1000, 0);
        account.ModifyMoney(400);
        Assert.assertEquals(1000 + 400, account.GetMoney());
    }

    @Test
    public void SubtractfromAccountBalance() {
        Account account = new Account(1000, 0);
        account.ModifyMoney(-400);
        Assert.assertEquals(1000 - 400, account.GetMoney());
    }

    @Test
    public void TestNegative() {
        Account account = new Account(1000, 0);
        Assert.assertFalse(account.ModifyMoney(-4000));
        Assert.assertEquals(-3000, account.GetMoney());
    }


}