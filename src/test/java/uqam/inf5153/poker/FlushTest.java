package uqam.inf5153.poker;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class FlushTest {

    @Test public void testGetStrength() {
        Player player = new Player("test");
        player.takeCard(new Card("1D"));
        player.takeCard(new Card("2D"));
        player.takeCard(new Card("3D"));
        player.takeCard(new Card("4D"));
        player.takeCard(new Card("5D"));
        Flush flush = new Flush(player.getHand(), Color.DIAMONDS, 5);
        assertEquals(flush.getStrength(), 605);
    }

    @Test public void testToString() {
        Player player = new Player("test");
        player.takeCard(new Card("1D"));
        player.takeCard(new Card("2D"));
        player.takeCard(new Card("3D"));
        player.takeCard(new Card("4D"));
        player.takeCard(new Card("5D"));
        Flush flush = new Flush(player.getHand(), Color.DIAMONDS, 5);
        assertEquals(Language.FLUSH + Color.DIAMONDS + Language.DOT, flush.toString());
    }
}