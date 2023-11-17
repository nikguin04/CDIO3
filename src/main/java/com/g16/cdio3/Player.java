package com.g16.cdio3;

public class Player {
    private String name;
    public final Account account;
    private int position = 0;
    private boolean isInPrison;
    private int color = -1; // 0 = Red, 1 = Blue, 2 = Green, 3 = Yellow
    public final int playerId;

    public Player(String _name, int _money, int _playerId) {
        name = _name;
        account = new Account(_money, _playerId);
        playerId = _playerId;

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

    public boolean AddToPosition(int amount) { // Returns true if player has passed start!, automatically adds money
                                               // when pass start
        boolean passStart = position + amount >= Board.getSquareCount();
        position = (position + amount) % Board.getSquareCount();
        if (passStart) {
            account.ModifyMoney(2);
        }
        return passStart;
    }

    public boolean SetPosition(int place) { // Returns true if player has passed start!, does not automatically add
                                            // money when pass start
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

    public void buyProperty(BoardSquare_Place squareToBuy) {
        // TODO make changes for boardSquare_Place if needed.

        // Set owner of boardSquare
        squareToBuy.SetOwner(this.playerId);

        // Remove money from player
        this.account.ModifyMoney(-squareToBuy.squarePrice);

        System.out.println("You just bought " + squareToBuy.GetSquareName() + " for: " + squareToBuy.squarePrice + "$");
        // System.out.println("Your account balance is now: " + this.account.GetMoney());
    }

    public void payRent(BoardSquare_Place currentSquare) {
        Player playerToPay = Game.players[currentSquare.GetOwner()];
        if (playerToPay == this) {
            System.out.println("You own this square, no rent is paid.");
            return;
        }
        boolean isTwinOwned = ((BoardSquare_Place) Board.getSquare(currentSquare.squareTwinPosition))
                .GetOwner() == currentSquare.GetOwner();
        int moneyToPay = currentSquare.squarePrice;
        if (isTwinOwned) {
            moneyToPay *= 2; 
        }
        
        this.account.ModifyMoney(-moneyToPay);
        playerToPay.account.ModifyMoney(moneyToPay);

        System.out.println(
                this.GetColoredName() + ": You just paid " + moneyToPay + "$" + " in rent to " + playerToPay.GetColoredName());
        // System.out.println("Your respective account balances are now: ");
        // System.out.println(this.GetColoredName() + ": " + this.account.GetMoney());
        // System.out.println(playerToPay.GetColoredName() + ": " + playerToPay.account.GetMoney());
    }
}
