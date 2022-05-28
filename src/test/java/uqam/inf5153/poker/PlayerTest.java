package uqam.inf5153.poker;


import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class PlayerTest {

    @Test public void testGetHand() {
        Player player = new Player("test");
        player.takeCard(new Card("XX"));
        Hand hand = player.getHand();
        assertEquals(hand.getCard(0).getValue(), Value.INCORRECT);
    }

    @Test public void testTestGetName() {
        Player player = new Player("test");
        assertEquals("test", player.getName());
    }
}