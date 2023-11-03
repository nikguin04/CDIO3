package com.g16.cdio3;


interface BoardSquare {
    public String squareName;
    public void TileEffect(int playerIndex);
}

class BoardSquare_Place implements BoardSquare {
    public final String squareName;
    public final int squarePrice;
    private boolean isOwned;
    private int ownedBy;
    private int squareTwinPosition;
    public void TileEffect(int playerIndex) {

    }
    public BoardSquare_Place(String _name, int _price, int _squareTwinPosition) {
        squareName = _name;
        squarePrice = _price;
        isOwned = false;
        ownedBy = -1;
        squareTwinPosition = _squareTwinPosition;
    }

    public boolean SetOwner(int player) {
        if (!isOwned) {
            isOwned = true;
            ownedBy = player;
            return true;
        } else {
            return false;
        }
    }

    public boolean RemoveOwner() {
        if (isOwned) {
            isOwned = false;
            ownedBy = -1;
            return true;
        } else {
            return false;
        }
    }

    public int GetOwner() {
        return ownedBy;
    }

    public boolean isOwned() {
        return isOwned;
    }
}


//private static ChanceCard[] chanceEffects;
class BoardSquare_Chance implements BoardSquare {

    public void TileEffect(int playerIndex) {

    }
}

class BoardSquare_NonAction implements BoardSquare {
    public String squareName;
    public void TileEffect(int playerIndex) {
        // DO NOTHING AS OF YET! we add the money when we move the player, not here 
    }
    public BoardSquare_NonAction(String name) {
        squareName = name;
    }
}

class BoardSquare_GoJail implements BoardSquare {
    public String squareName = "Jail";
    public void TileEffect(int playerIndex) {
        // DO NOTHING AS OF YET! we add the money when we move the player, not here 
        Game.players[playerIndex].SetPrisonStatus(true);
        Game.players[playerIndex].AddToPosition(12);
    }
    public BoardSquare_GoJail() {

    }
}