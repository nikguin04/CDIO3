package com.g16.cdio3;

abstract class ChanceCard {
    public abstract String getCardName();
    public abstract String getCardDescription();
    public abstract void ChanceEffect(int playerIndex);
}


public class ChanceCards {
    public static ChanceCard[] chanceCards = {
        new Chance_MoveToStart(),
        new Chance_BirthdayCard(),
        new ChanceDoneYourHomework()
    };  
}


class Chance_MoveToStart extends ChanceCard {
    public String getCardName() {return "Move to start";}
    public String getCardDescription() {return "Move to start, and receive 2 Monopoly money!";}
    public void ChanceEffect(int playerIndex) {
        Game.players[playerIndex].SetPosition(0);
        Game.players[playerIndex].account.ModifyMoney(2);
    }
}

class Chance_BirthdayCard extends ChanceCard {
    public String getCardName() {return "Birthday card";}
    public String getCardDescription() {return "Happy birthday! Everyone gives you 1 Monopoly money!";}
    public void ChanceEffect(int playerIndex) {
        for (int i = 0; i < Game.players.length; i++) {
            Player player = Game.players[i];
            if (i == playerIndex) {
                player.account.ModifyMoney(Game.players.length-1);
                continue;
            }
            player.account.ModifyMoney(-1);
        }
    }
}


class ChanceDoneYourHomework extends ChanceCard {
    public String getCardName(){
        return "Get $2";
    }
    public String getCardDescription(){
        return "You have done your homework you get $2 from the bank.";
    }
    public void ChanceEffect(int playerIndex){
        Game.players[playerIndex].account.ModifyMoney(2);
    }
}
