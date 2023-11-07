package com.g16.cdio3;
import java.util.SplittableRandom;

public class Dice {
    private int diceAmount;
    private int diceFaceAmount;

    public DiceThrow DiceThrow() {
        DiceThrow dt = new DiceThrow(this);
        return dt;
    }

    public Dice(int _diceAmount, int _diceFaceAmount) {
        diceAmount = _diceAmount;
        diceFaceAmount = _diceFaceAmount;
    }

    public class DiceThrow {
        public final int[] individualResults; // Final variables can not be changed! Therefor we dont need uneccassary functions like getSum(), getEns(), etc..
        public final int addedResult;
        public final boolean dieFacesEqual;
        public DiceThrow(Dice _dice) {
            individualResults = new int[_dice.diceAmount];
            int _addedResult = 0;
            boolean _dieFacesEqual = true;

            for (int i = 0; i < diceAmount; i++) {
                individualResults[i] = new SplittableRandom().nextInt(1, diceFaceAmount+1);
                _addedResult += individualResults[i];
                if (i > 0 && individualResults[i] != individualResults[i-1]) // First check i>0, which means we have a dice in the array @ i-1. Then check if they are NOT equal!
                {
                    _dieFacesEqual = false;
                }
            }

            dieFacesEqual = _dieFacesEqual;
            addedResult = _addedResult;
        }
    }
}
