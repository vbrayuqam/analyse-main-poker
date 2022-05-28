package uqam.inf5153.poker;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MainTest {


    @Before public void initResult() { Main.endMessage = null; }

    // P1 Wins

    @Test public void p1F_p2H() {
        String p1 = "2D 5D QD KD 7D";
        String p2 = "1S 4C KH TD 3S";
        Main.main(new String[] {p1, p2});
        assertEquals("P1 had a flush of DIAMONDS. P2 had a KING. \nHence, the winner is P1! ", Main.endMessage);
    }

    @Test public void p1F_p2P() {
        String p1 = "2D 5D QD KD 7D";
        String p2 = "1S 4C 1H TD 3S";
        Main.main(new String[] {p1, p2});
        assertEquals("P1 had a flush of DIAMONDS. P2 had a pair of ACE. \nHence, the winner is P1! ", Main.endMessage);
    }

    @Test public void p1F_p2F() {
        String p1 = "2D 5D QD KD 7D" ;
        String p2 = "1H 4H JH TH 3H" ;
        Main.main(new String[] {p1, p2});
        assertEquals("P1 had a flush of DIAMONDS. P2 had a flush of HEARTS. \nHence, the winner is P1! ", Main.endMessage);
    }

    // P2 Wins

    @Test public void p2F_p1H() {
        String p1 = "1S 4C KH TD 3S";
        String p2 = "2D 5D QD KD 7D";
        Main.main(new String[] {p1, p2});
        assertEquals("P1 had a KING. P2 had a flush of DIAMONDS. \nHence, the winner is P2! ", Main.endMessage);
    }

    @Test public void p2F_p1P() {
        String p1 = "1S 4C 1H TD 3S" ;
        String p2 = "2D 5D QD KD 7D";
        Main.main(new String[] {p1, p2});
        assertEquals("P1 had a pair of ACE. P2 had a flush of DIAMONDS. \nHence, the winner is P2! ", Main.endMessage);
    }

    @Test public void p2F_p1F() {
        String p1 = "1H 4H JH TH 3H";
        String p2 = "2D 5D QD KD 7D";
        Main.main(new String[] {p1, p2});
        assertEquals("P1 had a flush of HEARTS. P2 had a flush of DIAMONDS. \nHence, the winner is P2! ", Main.endMessage);
    }

    // Tie cases

    @Test public void tie_F() {
        String p1 = "3H 8H JH KH 7H";
        String p2 = "2D 5D QD KD 7D";
        Main.main(new String[] {p1, p2});
        assertEquals("P1 had a flush of HEARTS. P2 had a flush of DIAMONDS. \nHence, the game ends in a tie! ", Main.endMessage);
    }

    @Test public void tie_P() {
        String p1 = "1S 4C 1H TD 3S" ;
        String p2 = "1C 5H 1D KS 7C";
        Main.main(new String[] {p1, p2});
        assertEquals("P1 had a pair of ACE. P2 had a pair of ACE. \nHence, the game ends in a tie! ", Main.endMessage);
    }

    @Test public void tie_H() {
        String p1 = "1S 4D JH TD 3H";
        String p2 = "2D 5S JD 3D 7D";
        Main.main(new String[] {p1, p2});
        assertEquals("P1 had a JACK. P2 had a JACK. \nHence, the game ends in a tie! ", Main.endMessage);
    }

    // Error cases

    @Test public void tooManyCards() {
        String p1 = "3H 8H JH KH 7H 7C";
        String p2 = "2D 5D QD KD 7D";
        Main.main(new String[] {p1, p2});
        assertEquals("There was an error with the hands given. P1's hand was too big. ", Main.endMessage);
    }

    @Test public void notEnoughCards() {
        String p1 = "3H 8H JH KH 7H";
        String p2 = "2D 5D QD KD";
        Main.main(new String[] {p1, p2});
        assertEquals("There was an error with the hands given. P2's hand was too small. ", Main.endMessage);
    }

    @Test public void unknownValue() {
        String p1 = "3H XH JH KH 7H";
        String p2 = "2D 5D QD KD 7D";
        Main.main(new String[] {p1, p2});
        assertEquals("There was an error with the hands given. P1 had a card of a wrong value in his hand. ", Main.endMessage);
    }

    @Test public void unknownSuit() {
        String p1 = "3H 8H JH KH 7H";
        String p2 = "2D 5D QX KD 7D";
        Main.main(new String[] {p1, p2});
        assertEquals("There was an error with the hands given. P2 had a card of a wrong color in his hand. ", Main.endMessage);
    }

    // Extension : Detect cheating

    @Test public void sameCardTwice() {
        String p1 = "3H 8H JH KH 7H";
        String p2 = "8H 8H QH KD 7D";
        Main.main(new String[] {p1, p2});
        assertEquals("There was an error with the hands given. P2 cheated, they played the same card twice. ", Main.endMessage);
    }

    @Test public void nPlayersTie() {
        String p1 = "1D 2D 3D 4D 5D";
        String p2 = "1H 2H 3H 4H 5H";
        String p3 = "1C 2C 3C 4C 5C";
        Main.main(new String[] {p1, p2, p3});
        assertEquals("P1 had a flush of DIAMONDS. P2 had a flush of HEARTS. P3 had a flush of CLUBS. \nHence, the game ends in a tie! ", Main.endMessage);
    }
}
