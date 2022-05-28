package uqam.inf5153.poker;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;


public class ErrorHandlerTest {

    @Test public void getErrorMsg() {
        ErrorHandler eh = new ErrorHandler();
        assertEquals(Language.GAME_ERROR, eh.getErrorMsg());
    }

    @Test public void verifyBigHand() {
        Player player = new Player("test");
        player.takeCard(new Card("1D"));
        player.takeCard(new Card("1D"));
        player.takeCard(new Card("1D"));
        player.takeCard(new Card("1D"));
        player.takeCard(new Card("1D"));
        player.takeCard(new Card("1D"));
        ErrorHandler eh = new ErrorHandler();
        boolean result = eh.verifyBigHand(player);
        assertEquals(result, true);
    }

    @Test public void verifyBigHandFail() {
        Player player = new Player("test");
        player.takeCard(new Card("1D"));
        ErrorHandler eh = new ErrorHandler();
        boolean result = eh.verifyBigHand(player);
        assertEquals(result, false);
    }


    @Test public void verifySmallHandFail() {
        Player player = new Player("test");
        player.takeCard(new Card("1D"));
        player.takeCard(new Card("1D"));
        player.takeCard(new Card("1D"));
        player.takeCard(new Card("1D"));
        player.takeCard(new Card("1D"));
        player.takeCard(new Card("1D"));
        ErrorHandler eh = new ErrorHandler();
        boolean result = eh.verifySmallHand(player);
        assertEquals(result, false);
    }

    @Test public void verifySmallHand() {
        Player player = new Player("test");
        player.takeCard(new Card("1D"));
        ErrorHandler eh = new ErrorHandler();
        boolean result = eh.verifySmallHand(player);
        assertEquals(result, true);
    }

    @Test public void verifyColor() {
        Player player = new Player("test");
        player.takeCard(new Card("1X"));
        ErrorHandler eh = new ErrorHandler();
        boolean result = eh.verifyColor(player);
        assertEquals(true, result);
    }

    @Test public void verifyValue() {
        Player player = new Player("test");
        player.takeCard(new Card("XD"));
        ErrorHandler eh = new ErrorHandler();
        boolean result = eh.verifyValue(player);
        assertEquals(true, result);
    }

    @Test public void verifyColorFail() {
        Player player = new Player("test");
        player.takeCard(new Card("1D"));
        ErrorHandler eh = new ErrorHandler();
        boolean result = eh.verifyColor(player);
        assertEquals(false, result);
    }

    @Test public void verifyValueFail() {
        Player player = new Player("test");
        player.takeCard(new Card("1D"));
        ErrorHandler eh = new ErrorHandler();
        boolean result = eh.verifyValue(player);
        assertEquals(false, result);

    }

    @Test public void verifyCheating() {
        Player player = new Player("test");
        player.takeCard(new Card("1D"));
        player.takeCard(new Card("1D"));
        ErrorHandler eh = new ErrorHandler();
        boolean result = eh.verifyCheating(player);
        assertEquals(result, true);
    }
}