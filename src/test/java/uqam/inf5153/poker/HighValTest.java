package uqam.inf5153.poker;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class HighValTest {

    @Test public void testGetStrength() {
        Card card = new Card("KC");
        HighVal highval = new HighVal(card);
        assertEquals(113, highval.getStrength());
    }

    @Test public void testTestToString() {
        Card card = new Card("KC");
        HighVal highval = new HighVal(card);
        assertEquals(Language.HIGH_VAL + Value.KING + Language.DOT, highval.toString());
    }
}