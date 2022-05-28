package uqam.inf5153.poker;

import static org.junit.Assert.*;

import org.junit.Test;


public class CardTest {


    @Test public void getColor() {
        Card card = new Card("1D");
        assertEquals(Color.DIAMONDS, card.getColor());
    }

    @Test public void getColorError() {
        Card card = new Card("1X");
        assertEquals(Color.INCORRECT, card.getColor());
    }

    @Test public void getValue() {
        Card card = new Card("1D");
        assertEquals(Value.ACE, card.getValue());
    }
    @Test public void getValueError() {
        Card card = new Card("YD");
        assertEquals(Value.INCORRECT, card.getValue());
    }

    @Test public void getStrength() {
        Card card = new Card("1D");
        assertEquals(1, card.getStrength());
    }
}