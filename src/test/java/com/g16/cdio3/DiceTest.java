package com.g16.cdio3;

import org.junit.Assert;
import org.junit.Test;

public class DiceTest {
    
    @Test
    public void TestDiceCreationParams() {
        Dice dice = new Dice(4, 10);
        Dice.DiceThrow dt = dice.DiceThrow();
        Assert.assertEquals(4, dt.individualResults.length);
        for (int res: dt.individualResults) {
            Assert.assertTrue(res > 0 && res < 10+1);
        }
    }

    @Test
    public void TestEqualFaces() {
        Dice dice = new Dice(4, 1);
        Dice.DiceThrow dt = dice.DiceThrow();
        Assert.assertTrue(dt.dieFacesEqual);

        dice = new Dice(20, 10000); // Pretty much impossible to be equal
        dt = dice.DiceThrow();
        Assert.assertFalse(dt.dieFacesEqual);

        dice = new Dice(2, 6); // Brute force equal test 1000 times
        for (int i = 0; i < 1000; i++)
            dt = dice.DiceThrow();
            if (dt.individualResults[0] == dt.individualResults[1]) {
                Assert.assertTrue(dt.dieFacesEqual);
            } else {
                Assert.assertFalse(dt.dieFacesEqual);
        }
    }

    @Test
    public void TestDiceAddedResult() {
        Dice dice = new Dice(2, 10);
        Dice.DiceThrow dt = dice.DiceThrow();
        Assert.assertEquals(dt.individualResults[0] + dt.individualResults[1], dt.addedResult);
    }
}
