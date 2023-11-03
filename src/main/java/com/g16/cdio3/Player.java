package com.g16.cdio3;

public class Player {
    private String name;
    public final Account account;
    private int position=0;
    private boolean isInPrison;

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

    public int GetPosition() {
        return position;
    }
    public boolean AddToPosition(int amount) { // Returns true if player has passed start!
        boolean passStart = position + amount >= Game.tileCount;
        position = (position + amount) % Game.tileCount;
        return passStart;
    }

    public boolean isInPrison() {
        return isInPrison;
    }
    public void SetPrisonStatus(boolean status) {
        isInPrison = status;
    }
}
