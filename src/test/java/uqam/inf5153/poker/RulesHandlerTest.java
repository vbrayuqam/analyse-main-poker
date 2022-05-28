package uqam.inf5153.poker;


import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RulesHandlerTest {

    @Test public void testDetermineEndstate() {
        RulesHandler rh = new RulesHandler();
        Player player = new Player("test");
        List<Player> players = new ArrayList<Player>();
        player.takeCard(new Card("KH"));
        player.takeCard(new Card("QH"));
        player.takeCard(new Card("1H"));
        player.takeCard(new Card("5H"));
        player.takeCard(new Card("TH"));
        players.add(player);
        rh.findStrongestCombination(players.get(0));
        rh.determineEndstate(players);
        assertEquals("test had a flush of HEARTS. ", rh.getEndgame());
    }

    @Test public void testDetermineWinner() {
        RulesHandler rh = new RulesHandler();
        Player player = new Player("test");
        List<Player> players = new ArrayList<Player>();
        player.takeCard(new Card("KH"));
        player.takeCard(new Card("QH"));
        player.takeCard(new Card("1H"));
        player.takeCard(new Card("5H"));
        player.takeCard(new Card("TH"));
        players.add(player);
        rh.findStrongestCombination(players.get(0));
        rh.determineEndstate(players);
        rh.determineWinner(players);
        assertEquals("test had a flush of HEARTS. \nHence, the winner is test! ", rh.getEndgame());
    }
}