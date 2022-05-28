package uqam.inf5153.poker;


import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class PairTest {

    @Test public void testGetFirstCard() {
        Pair pair = new Pair();
        pair.setFirstCard(new Card("1D"));
        assertEquals(Color.DIAMONDS, pair.getFirstCard().getColor());
        assertEquals(Value.ACE, pair.getFirstCard().getValue());
    }

    @Test public void testGetSecondCard() {
        Pair pair = new Pair();
        pair.setSecondCard(new Card("1D"));
        assertEquals(Color.DIAMONDS, pair.getSecondCard().getColor());
        assertEquals(Value.ACE, pair.getSecondCard().getValue());
    }

    @Test public void testGetStrength() {
        Pair pair = new Pair();
        pair.setFirstCard(new Card("1H"));
        pair.setSecondCard(new Card("1D"));
        pair.calculateStrength();
        assertEquals(201, pair.getStrength());
    }

    @Test public void testTestToString() {
        Pair pair = new Pair();
        pair.setFirstCard(new Card("1H"));
        pair.setSecondCard(new Card("1D"));
        assertEquals(Language.PAIR + Value.ACE + Language.DOT, pair.toString());
    }
}