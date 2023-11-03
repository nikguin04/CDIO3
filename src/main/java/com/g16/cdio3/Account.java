package com.g16.cdio3;

public class Account{
    private int Money=0;
    public int GetMoney() {
        return Money;
    }
    public void ModifyMoney(int _money) {
        Money += _money;
        if(Money < 0) 
            Money = 0;
    }

    public Account(int startMoney) {
        ModifyMoney(startMoney); // This also makes sure our account cant start negative!
    }
}
