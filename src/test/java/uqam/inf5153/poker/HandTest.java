package uqam.inf5153.poker;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class HandTest {

    @Test public void testGetCard() {
        Hand hand = new Hand();
        hand.addCard(new Card("7H"));
        assertEquals(Value.SEVEN, hand.getCard(0).getValue());
        assertEquals(Color.HEARTS, hand.getCard(0).getColor());
    }

    @Test public void testGetNumOfCards() {
        Hand hand = new Hand();
        hand.addCard(new Card("7H"));
        hand.addCard(new Card("7H"));
        hand.addCard(new Card("7H"));
        hand.addCard(new Card("7H"));
        assertEquals(4, hand.getNumOfCards());
    }

    @Test public void testGetNumOfCardsFail() {
        Hand hand = new Hand();
        hand.addCard(new Card("7H"));
        hand.addCard(new Card("7H"));
        hand.addCard(new Card("7H"));
        hand.addCard(new Card("7H"));
        hand.addCard(new Card("7H"));
        assertNotEquals(4, hand.getNumOfCards());
    }
}