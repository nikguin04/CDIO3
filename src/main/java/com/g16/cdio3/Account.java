package com.g16.cdio3;

public class Account{
    private int Money=0;
    public int GetMoney() {
        return Money;
    }
    public boolean ModifyMoney(int _money) { // return false if player has lost and true otherwise.
        Money += _money;
        if (Money < 0) {
            Money = 0;
            return false;
        }
        else {
            return true;
        }
    }

    public Account(int startMoney) {
        ModifyMoney(startMoney); // This also makes sure our account cant start negative!
    }
}
