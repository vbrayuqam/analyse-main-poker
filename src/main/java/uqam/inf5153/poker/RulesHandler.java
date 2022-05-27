package uqam.inf5153.poker;

import com.sun.org.apache.bcel.internal.generic.FLOAD;

import java.util.ArrayList;
import java.util.List;

public class RulesHandler {
    private List<Combination> combinations;

    public RulesHandler() {
        combinations = new ArrayList<Combination>();
    }

    public void findStrongestCombination(Player player) {
        Combination currentCombination;
        Hand hand = player.getHand();

        currentCombination = extractHighVal(hand);


        if (containsPair(hand)) {
            currentCombination = extractPair(hand);
        }


        if (containsFlush(hand)) {
            currentCombination = extractFlush(hand);
        }


        this.combinations.add(currentCombination);

        System.out.println(currentCombination);
    }

    private HighVal extractHighVal(Hand hand) {
        int handSize = hand.getNumOfCards();
        Card currentHighVal = hand.getCard(0);


        for(int i = 1; i < handSize; i++) {
            Card currentCard = hand.getCard(i);
            if (currentHighVal.getValue().compareTo(currentCard.getValue()) < 0) {
                currentHighVal = currentCard;
            }
        }

        return new HighVal(currentHighVal);
    }

    private boolean containsPair(Hand hand) {
        boolean hasPair = false;
        int handSize = hand.getNumOfCards();

        for (int i = 0; i < handSize -1; i ++) {
            Card firstCard = hand.getCard(i);
            for (int j = i + 1; j < handSize; j++) {
                Card secondCard = hand.getCard(j);

                if (firstCard.getValue().compareTo(secondCard.getValue()) == 0 ) {
                    hasPair = true;
                }
            }
        }

        return hasPair;
    }

    private Pair extractPair(Hand hand) {
        int handSize = hand.getNumOfCards();
        Pair pair = new Pair();
        boolean pairFound = false;
        Value valueFound = Value.INCORRECT;

        for (int i = 0; i < handSize -1; i ++) {
            Card firstCard = hand.getCard(i);
            for (int j = i + 1; j < handSize; j++) {
                Card secondCard = hand.getCard(j);

                if (firstCard.getValue().compareTo(secondCard.getValue()) == 0 ) {
                    if (pairFound == false || valueFound.compareTo(firstCard.getValue()) < 0) {
                        pair.setFirstCard(firstCard);
                        pair.setSecondCard(secondCard);
                        pairFound = true;
                        valueFound = firstCard.getValue();
                    }
                }
            }
        }

        return pair;
    }

    private boolean containsFlush(Hand hand) {
        boolean isFlush = true;

        int handSize = hand.getNumOfCards();
        Color color = hand.getCard(0).getColor();

        for (int i = 1; i < handSize; i ++) {
            Card currentCard = hand.getCard(i);
            if (currentCard.getColor() != color) {
                isFlush = false;
                break;
            }
        }
        
        return isFlush;
    }

    private Flush extractFlush(Hand hand) {
        return new Flush(hand);
    }
}
