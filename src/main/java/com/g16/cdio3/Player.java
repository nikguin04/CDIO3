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
    public boolean AddToPosition(int amount) { // Returns true if player has passed start!, automatically adds money when pass start
        boolean passStart = position + amount >= Game.tileCount;
        position = (position + amount) % Game.tileCount;
        if (passStart) {
            account.ModifyMoney(2);
        }
        return passStart;
    }

    public boolean SetPosition(int place) { // Returns true if player has passed start!, does not automatically add money when pass start
        boolean passStart = position > place;
        position = place;
        return passStart;
    }

    public boolean isInPrison() {
        return isInPrison;
    }
    public void SetPrisonStatus(boolean status) {
        isInPrison = status;
    }
}
