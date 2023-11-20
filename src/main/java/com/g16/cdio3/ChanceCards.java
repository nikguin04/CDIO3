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
        new ChanceMove5(),
        new ChanceMoveToOrange(),
        new ChanceMove1TileORTakeAnother(),
        new ChanceToTheShip(),
        new ChanceToMuchCandy(),
        new ChanceMoveToOrangeOrGreen(),
        new ChanceFreeTile(),
        new ChanceGetOutOfJail(),
        new ChanceTheBeachPromenade(),
        new ChanceCat(),
        new ChanceDog(),
        new ChanceMoveToPinkOrBlue(),
        new ChanceDoneYourHomework(),
        new ChanceRedTile(),
        new ChanceGreeSkatepark(),
        new ChanceGetLightBlueOrRed(),
        new ChanceBrownOrYellow()
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


class ChanceMove5 extends ChanceCard {
    public String getCardName() {
        return "Move up to 5 tiles";
    }
    public String getCardDescription() {
        return "Move up to 5 tiles!";
    }
    public void ChanceEffect(int playerIndex){
        // func for the player to move up to five tiles
    }
}

class ChanceMoveToOrange extends ChanceCard {
    public String getCardName() {
        return "Move to a orange Tile";
    }
    public String getCardDescription() {
        return "Move to a orange tile of your choice, if its not owned then you get it for free, else you pay the landlord.";
    }
    public void ChanceEffect(int  playerIndex) {
        // func for the player to move to a oraange tile 
    }
}

class ChanceMove1TileORTakeAnother extends ChanceCard {
    public String getCardName() {
        return "1 tile or 1 more chance card";
    }

    public String getCardDescription() {
        return "Move 1 tile or take a chance card";
    }
    public void ChanceEffect(int playerIndex) {
        //Func for the chosing of moveing 1 tile or take a new chance card.
    }
}

class ChanceToTheShip extends ChanceCard{
    public String getCardName() {
        return "Chance card for the Ship";
    }
    public String getCardDescription(){
        return "Give this card to the ship and take antoher card. Ship on your next trun sail to a tile of your choseing and buy it. If there is no available tiles then you buy it of another player.";
    }
    public void ChanceEffect(int playerIndex){
        //func make this card
    }
}

class ChanceToMuchCandy extends ChanceCard{
    public String getCardName() {
        return "Too much candy";
    }
    public String getCardDescription() {
        return "You ate too much candy. Pay the bank 2 M.";
    }
    public void ChanceEffect(int playerIndex) {
        // func make this. 
    }
}

class ChanceMoveToOrangeOrGreen extends ChanceCard {
    public String getCardName() {
        return "Move to an Orange or Green tile";
    }
    public String getCardDescription(){
        return "Move to an Orange or Green tile. If its available then you get it for free, else you pay the landlord.";
    }
    public void ChanceEffect(int playerIndex){
        // make this. 
    }
}

class ChanceFreeTile extends ChanceCard {
    public String getCardName(){
        return "Free tile";
    }
    public String getCardDescription(){
        return "Move to a light blue tile. If its available then you get it for free, else you pay the landlord.";
    }
    public void ChanceEffect(int playerIndex){
        // make this.
    }
}

class ChanceGetOutOfJail extends ChanceCard {
    public String getCardName(){
        return "Get out of jail card";
    }
    public String getCardDescription(){
        return "Keep this card and use if when you are in jail";
    }
    public void ChanceEffect(int playerIndex) {
        // make this.
    }
}

class ChanceTheBeachPromenade extends ChanceCard {
    public String getCardName(){
        return "Move to The Beach Promenade";
    }
    public String getCardDescription(){
        return "Move to The Beach Promenade";
    }
    public void ChanceEffect(int playerIndex){
        //make this.
    }
}

class ChanceCat extends ChanceCard{
    public String getCardName() {
        return "Cat";
    }
    public String getCardDescription(){
        return "Give this card to the cat. Cat on your next turn move to a tile of your chossing if its not owned buy it else pay the landlord.";
    }
    public void ChanceEffect(int playerIndex){
        // make this
    }
}

class ChanceDog extends ChanceCard {
    public String getCardName() {
        return "Dog";
    }
    public String getCardDescription(){
        return "Give this card to the Dog. Dog on your next turn jump to a tile of your chossing if its not owned buy it else pay the landlord.";
    }
    public void ChanceEffect(int playerIndex){
        // make this.
    }
}

class ChanceMoveToPinkOrBlue extends ChanceCard {
    public String getCardName(){
        return "Move to a Pink or blue tile";
    }
    public String getCardDescription(){
        return "Move to a pink or a darkblue tile. If its available then you get it for free, else you pay the landlord.";
    }
    public void ChanceEffect(int playerIndex){
        //make this.
    }
}

class ChanceDoneYourHomework extends ChanceCard {
    public String getCardName(){
        return "Get 2 M.";
    }
    public String getCardDescription(){
        return "You have done your homework you get 2M from the bank.";
    }
    public void ChanceEffect(int playerIndex){
        // make this.s
    }
}

class ChanceRedTile extends ChanceCard {
    public String getCardName(){
        return "Free red tile.";
    }
    public String getCardDescription(){
        return "Move to a red tile. If its available then you get it for free, else you pay the landlord.";
    }
    public void ChanceEffect(int playerIndex){
        //make this.
    }
}

class ChanceGreeSkatepark extends ChanceCard{
    public String getCardName(){
        return "Get Skatepark for free";
    }
    public String getCardDescription(){
        return "Move to the SkatePark to do the perfect grind. If no one owneds it then you get it for free, else you pay the landlord.";
    }
    public void ChanceEffect(int playerIndex) {
        // make this.
    }
}

class ChanceGetLightBlueOrRed extends ChanceCard {
    public String getCardName(){
        return "Free tile for Lightblue or red";
    }
    public String getCardDescription() {
        return "Move to a lightblue or red tile. If its available then you get it for free, else you pay the landlord.";
    }
    public void ChanceEffect(int playerIndex){
        //make this
    }
}

class ChanceBrownOrYellow extends ChanceCard{
    public String getCardName(){
        return "Free tile for brown or red.";
    }
    public String getCardDescription(){
        return "Move to a brown or red tile. If its available then you get it for free, else you pay the landlord.";
    }
    public void ChanceEffect(int playerIndex){
        //Make this
    }
}

