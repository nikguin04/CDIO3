package com.g16.cdio3;

abstract class ChanceCard {
    public abstract String getCardName();
    public abstract String getCardDescription();
    public abstract void ChanceEffect(int playerIndex);
}

class Chance_MoveToStart extends ChanceCard {
    public String getCardName() {return "Move to start";}
    public String getCardDescription() {return "Move to start, and receive 2 Monopoly money";}
    public void ChanceEffect(int playerIndex) {
        Game.players[playerIndex].SetPosition(0);
        Game.players[playerIndex].account.ModifyMoney(2);
    }
}

public class ChanceCards {
    public static ChanceCard[] chanceCards = {
        new Chance_MoveToStart()
    };
}

