package uqam.inf5153.poker;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<Card>();
    }

    /**
     * Adds a card to the hand.
     * @param card the card that is to be added
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Getter.
     */
    public Card getCard(int position) {
        return cards.get(position);
    }

    /**
     * Gets the number of cards currently in the hand.
     * @return an int representing the number of card in the hand
     */
    public int getNumOfCards() {
        return cards.size();
    }
}

