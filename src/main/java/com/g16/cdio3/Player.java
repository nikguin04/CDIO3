package com.g16.cdio3;

public class Player {
    private String name;
    public Account account;
    public Player (String _name, int _money) {
        name = _name;
        account = new Account(_money);
    }


    public String GetName() {
        return name;
    }
    public void SetName(String _name) {
        name = _name;
    }
}
