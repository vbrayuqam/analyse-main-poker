package uqam.inf5153.poker;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<Card>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    @Override
    public String toString() {
        String handString = "";

        for (int i = 0; i < cards.size(); i ++) {
            handString += cards.get(i);
        }

        return handString;
    }
}

