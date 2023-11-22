package com.g16.cdio3;

import java.util.Scanner;

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
        new ChanceToMuchCandy(),
        new ChanceMoveToOrangeOrGreen(),
        new ChanceFreeTile(),
        new ChanceTheBeachPromenade(),
        new ChanceMoveToPinkOrBlue(),
        new ChanceDoneYourHomework(),
        new ChanceRedTile(),
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
        System.out.println("Input the amount of tiles you want to move up to 5 tiles");
        Scanner input = new Scanner(System.in);
        int move = input.nextInt();
        Game.players[playerIndex].AddToPosition(move);
        input.close();
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
        System.out.println("1. " + Board.getSquare(10).GetSquareName() + " 2. " +  Board.getSquare(11).GetSquareName());
        System.out.println("Input the tile you want to move to");
        Scanner input = new Scanner(System.in);
        int move = input.nextInt();
        if (move == 1) {
            Game.players[playerIndex].SetPosition(10);
        } else if (move == 2) {
            Game.players[playerIndex].SetPosition(11);
        }
        input.close();
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
        System.out.println("Input 1 to move 1 tile or 2 to take a new chance card");
        Scanner input = new Scanner(System.in);
        int move = input.nextInt();
        if (move == 1) {
            Game.players[playerIndex].AddToPosition(1);
        } else if (move == 2) {
            // TODO
        }
        input.close();
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
        Game.players[playerIndex].account.ModifyMoney(-2);
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
        // 19, 20
        System.out.println("1. " + Board.getSquare(10).GetSquareName() + " 2. " +  Board.getSquare(11).GetSquareName() + " 3." + Board.getSquare(19).GetSquareName() + " 4." + Board.getSquare(20).GetSquareName());
        System.out.println("Input the tile you want to move to");
        Scanner input = new Scanner(System.in);
        int move = input.nextInt();
        if (move == 1) {
            Game.players[playerIndex].SetPosition(10);
        } else if (move == 2) {
            Game.players[playerIndex].SetPosition(11);
        } else if (move == 3) {
            Game.players[playerIndex].SetPosition(19);
        } else if (move == 4) {
            Game.players[playerIndex].SetPosition(20);
        }
        input.close();
    }
}

class ChanceFreeTile extends ChanceCard {
    public String getCardName(){
        return "Move to a light blue tile";
    }
    public String getCardDescription(){
        return "Move to a light blue tile. If its available then you get it for free, else you pay the landlord.";
    }
    public void ChanceEffect(int playerIndex){
        System.out.println("1. " + Board.getSquare(4).GetSquareName() + " 2. " +  Board.getSquare(5).GetSquareName());
        System.out.println("Input the tile you want to move to");
        Scanner input = new Scanner(System.in);
        int move = input.nextInt();
        if (move == 1) {
            Game.players[playerIndex].SetPosition(4);
        } else if (move == 2) {
            Game.players[playerIndex].SetPosition(5);
        }
        input.close();
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
        Game.players[playerIndex].SetPosition(23);
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
        // 7,8,23, 22,
        System.out.println("1. " + Board.getSquare(7).GetSquareName() + " 2. " +  Board.getSquare(8).GetSquareName() + " 3." + Board.getSquare(22).GetSquareName() + " 4." + Board.getSquare(23).GetSquareName());
        System.out.println("Input the tile you want to move to");
        Scanner input = new Scanner(System.in);
        int move = input.nextInt();
        if (move == 1) {
            Game.players[playerIndex].SetPosition(7);
        } else if (move == 2) {
            Game.players[playerIndex].SetPosition(8);
        } else if (move == 3) {
            Game.players[playerIndex].SetPosition(22);
        } else if (move == 4) {
            Game.players[playerIndex].SetPosition(23);
        }
        input.close();
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
        Game.players[playerIndex].account.ModifyMoney(2);
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
        //13,14
        System.out.println("1. " + Board.getSquare(13).GetSquareName() + " 2. " +  Board.getSquare(14).GetSquareName());
        System.out.println("Input the tile you want to move to");
        Scanner input = new Scanner(System.in);
        int move = input.nextInt();
        if (move == 1) {
            Game.players[playerIndex].SetPosition(13);
        } else if (move == 2) {
            Game.players[playerIndex].SetPosition(14);
        }
        input.close();
    }
}

// class ChanceGreeSkatepark extends ChanceCard{
//     public String getCardName(){
//         return "Get Skatepark for free";
//     }
//     public String getCardDescription(){
//         return "Move to the SkatePark to do the perfect grind. If no one owneds it then you get it for free, else you pay the landlord.";
//     }
//     public void ChanceEffect(int playerIndex) {
//         Game.players[playerIndex].SetPosition(10);
//         // if(Game.Board.getSquare(10).GetOwner() == null){
//         //     Game.players[playerIndex].account.ModifyMoney(-Game.Board.getSquare(10).GetPrice());
//         //     Game.Board.getSquare(10).SetOwner(Game.players[playerIndex]);
//         // }
//         //TODO
//     }
// }

class ChanceGetLightBlueOrRed extends ChanceCard {
    public String getCardName(){
        return "Free tile for Lightblue or red";
    }
    public String getCardDescription() {
        return "Move to a lightblue or red tile. If its available then you get it for free, else you pay the landlord.";
    }
    public void ChanceEffect(int playerIndex){
        // 4,5,13,14
        System.out.println("1. " + Board.getSquare(4).GetSquareName() + " 2. " +  Board.getSquare(5).GetSquareName() + " 3." + Board.getSquare(13).GetSquareName() + " 4." + Board.getSquare(14).GetSquareName());
        System.out.println("Input the tile you want to move to");
        Scanner input = new Scanner(System.in);
        int move = input.nextInt();
        if (move == 1) {
            Game.players[playerIndex].SetPosition(4);
        } else if (move == 2) {
            Game.players[playerIndex].SetPosition(5);
        } else if (move == 3) {
            Game.players[playerIndex].SetPosition(13);
        } else if (move == 4) {
            Game.players[playerIndex].SetPosition(14);
        }
        input.close();
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
        // 1,2,13,14
        System.out.println("1. " + Board.getSquare(1).GetSquareName() + " 2. " +  Board.getSquare(2).GetSquareName() + " 3." + Board.getSquare(13).GetSquareName() + " 4." + Board.getSquare(14).GetSquareName());
        System.out.println("Input the tile you want to move to");
        Scanner input = new Scanner(System.in);
        int move = input.nextInt();
        if (move == 1) {
            Game.players[playerIndex].SetPosition(1);
        } else if (move == 2) {
            Game.players[playerIndex].SetPosition(2);
        } else if (move == 3) {
            Game.players[playerIndex].SetPosition(13);
        } else if (move == 4) {
            Game.players[playerIndex].SetPosition(14);
        }
        input.close();
    }
}

