package com.g16.cdio3;


interface BoardSquare {
    public String GetSquareName();
    public void TileEffect(int playerIndex);
}

class BoardSquare_Place implements BoardSquare {
    public final String squareName;
    public final int squarePrice;
    private boolean isOwned;
    private int ownedBy;
    public final int squareTwinPosition;
    public final String color;
    public final String sgr_color_fg;
    
    public void TileEffect(int playerIndex) {

    }
    public BoardSquare_Place(String _name, int _price, int _squareTwinPosition, String _color, String _sgr_color_fg) {
        squareName = _name;
        squarePrice = _price;
        isOwned = false;
        ownedBy = -1;
        squareTwinPosition = _squareTwinPosition;
        color = _color;
        sgr_color_fg = _sgr_color_fg;
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
    public String GetSquareName() {
        return squareName;
    }
}


//private static ChanceCard[] chanceEffects;
class BoardSquare_Chance implements BoardSquare {

    public void TileEffect(int playerIndex) {
        
    }
    public String GetSquareName() {
        return "Chance";
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
    public String GetSquareName() {
        return squareName;
    }
}

class BoardSquare_GoJail implements BoardSquare {
    public void TileEffect(int playerIndex) {
        // DO NOTHING AS OF YET! we add the money when we move the player, not here
        Game.players[playerIndex].SetPrisonStatus(true);
        Game.players[playerIndex].SetPosition(6);

    }
    public BoardSquare_GoJail() {

    }
    public String GetSquareName() {
        return "Go To Jail";
    }
}