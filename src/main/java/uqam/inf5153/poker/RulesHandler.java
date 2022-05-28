package uqam.inf5153.poker;

import java.util.ArrayList;
import java.util.List;

public class RulesHandler {
    private List<Combination> combinations;
    private String endgame;

    public RulesHandler() {
        combinations = new ArrayList<Combination>();
        endgame = "";
    }

    /**
     * Determines the end state of a game of poker.
     * @param players the players whose hands require analyzing
     */
    public void determineEndstate(List<Player> players) {
        int numPlayers = players.size();
        for(int i = 0; i < numPlayers; i++) {
            endgame += players.get(i).getName() + Language.PLAYER_HAS + this.combinations.get(i).toString();
        }
    }

    /**
     * Determines the winner or lack of winner in a game of poker.
     * @param players the players whose hands require analyzing
     */
    public void determineWinner(List<Player> players) {
        int highestStrength = combinations.get(0).getStrength();
        Player currentWinner = players.get(0);
        int numPlayers = players.size();
        int handsWithHighestStrength = 0;

        for (int i = 1; i < numPlayers; i++) {
            int currentStrength = combinations.get(i).getStrength();
            if (highestStrength < currentStrength) {
                highestStrength = currentStrength;
                currentWinner = players.get(i);
            }
        }

        for (int i = 0; i < numPlayers; i++) {
            int currentStrength = combinations.get(i).getStrength();
            if (highestStrength == currentStrength) {
                handsWithHighestStrength += 1;
            }
        }

        if (handsWithHighestStrength > 1) {
            endgame += Language.TIE + Language.EXCLAMATION;
        } else {
            endgame += Language.WINNER + currentWinner.getName() + Language.EXCLAMATION;
        }
    }

    /**
     * Getter.
     */
    public String getEndgame() {
        return this.endgame;
    }

    /**
     * Finds the strongest combination that a player has.
     * @param player the player whose hand requires analyzing
     */
    public void findStrongestCombination(Player player) {
        Combination currentCombination;
        Hand hand = player.getHand();

        currentCombination = extractHighVal(hand);


        if (containsPair(hand)) {
            currentCombination = extractPair(hand);
        }


        if (containsFlush(hand)) {
            int flushStrength = currentCombination.getStrength();
            currentCombination = extractFlush(hand, flushStrength);
        }


        this.combinations.add(currentCombination);
    }

    /**
     * Extracts the highest value card from a hand.
     * @param hand the hand that requires the extraction
     * @return a HighVal representing the highest value card
     */
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

    /**
     * Determines if a hand contains a pair.
     * @param hand the hand that requires analyzing
     * @return a boolean that indicates if the hand contains a pair
     */
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

    /**
     * Extracts the strongest Pair from a hand.
     * @param hand the hand that requires the extraction
     * @return the strongest Pair in the hand
     */
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
                    if (!pairFound || valueFound.compareTo(firstCard.getValue()) < 0) {
                        pair.setFirstCard(firstCard);
                        pair.setSecondCard(secondCard);
                        pair.calculateStrength();
                        pairFound = true;
                        valueFound = firstCard.getValue();
                    }
                }
            }
        }

        return pair;
    }

    /**
     * Determines if a hand contains a flush.
     * @param hand the hand that requires analyzing
     * @return a boolean that indicates if the hand contains a flush
     */
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

    /**
     * Extracts a flush from a hand.
     * @param hand the hand that requires the extraction
     * @return a Flush
     */
    private Flush extractFlush(Hand hand, int strength) {
        Card card = hand.getCard(0);
        Color color = card.getColor();

        return new Flush(hand, color, strength);
    }
}
