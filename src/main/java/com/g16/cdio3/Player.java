package com.g16.cdio3;





public class Player {
    private String name;
    public final Account account;
    private int position=0;
    private boolean isInPrison;
    private int color=-1; // 0 = Red, 1 = Blue, 2 = Green, 3 = Yellow

    public Player (String _name, int _money) {
        name = _name;
        account = new Account(_money);
    }


    public String GetName() {
        return name;
    }
    public String GetColoredName() {
        return GameData.colorIndex[color].sgr_color_fg + name + GameData.SGR_CLEAR;
    }
    public void SetName(String _name) {
        name = _name;
    }

    public int GetPosition() {
        return position;
    }
    public boolean AddToPosition(int amount) { // Returns true if player has passed start!, automatically adds money when pass start
        boolean passStart = position + amount >= Board.getSquareCount();
        position = (position + amount) % Board.getSquareCount();
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

    public boolean SetColor(int _color) {
        if (color == -1) {
            color = _color;
            return true;
        } else {
            return false;
        }
    }

    public int GetColor() {
        return color;
    }
    
    public void buyProperty(BoardSquare_Place boardsquare) {
        boardsquare.SetOwner(this.color);
    }
}
