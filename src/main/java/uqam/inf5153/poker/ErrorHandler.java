package uqam.inf5153.poker;

public class ErrorHandler {
    final int POKER_HAND_SIZE = 5;
    private String errorMsg = Language.GAME_ERROR;

    public ErrorHandler() {
    }

    /**
     * Getter.
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * Determines if a player's hand is too big.
     * @param player the player whose hand's requires validation
     * @return a boolean that indicates if the hand is too big
     */
    public boolean verifyBigHand(Player player) {
        boolean isBig = false;
        Hand hand = player.getHand();

        if (hand.getNumOfCards() > POKER_HAND_SIZE) {
            isBig = true;
            this.errorMsg += player.getName() + Language.GAME_ERROR_BIG_HAND;
        }

        return isBig;
    }

    /**
     * Determines if a player's hand is too small.
     * @param player the player whose hand requires validation
     * @return a boolean that indicates if the hand is too small
     */
    public boolean verifySmallHand(Player player) {
        boolean isSmall = false;
        Hand hand = player.getHand();

        if (hand.getNumOfCards() < POKER_HAND_SIZE) {
            isSmall = true;
            this.errorMsg += player.getName() + Language.GAME_ERROR_SMALL_HAND;
        }

        return isSmall;
    }

    /**
     * Determines if the colors in a player's hand are valid.
     * @param player the player whose hand requires validation
     * @return a boolean that indicates if the hand contains an issue
     */
    public boolean verifyColor(Player player) {
        boolean badColor = false;
        Hand hand = player.getHand();
        int handSize = hand.getNumOfCards();

        for (int i = 0; i < handSize; i++) {
            Card card = hand.getCard(i);
            if (card.getColor() == Color.INCORRECT) {
                badColor = true;
                this.errorMsg += player.getName() + Language.GAME_ERROR_COLOR;
            }
        }

        return badColor;
    }

    /**
     * Determines if the values in a player's hand are valid.
     * @param player the player whose hand requires validation
     * @return a boolean that indicates if the hand contains an issue
     */
    public boolean verifyValue(Player player) {
        boolean badValue = false;
        Hand hand = player.getHand();
        int handSize = hand.getNumOfCards();

        for (int i = 0; i < handSize; i++) {
            Card card = hand.getCard(i);
            if (card.getValue() == Value.INCORRECT) {
                badValue = true;
                this.errorMsg += player.getName() + Language.GAME_ERROR_VALUE;
            }
        }

        return badValue;
    }

    /**
     * Determines if a player's hand contains multiples of a same card.
     * @param player the player whose hand requires validation
     * @return a boolean that indicates if the hand contains an issue
     */
    public boolean verifyCheating(Player player) {
        boolean cheated = false;
        Hand hand = player.getHand();
        int handSize = hand.getNumOfCards();

        for (int i = 0; i < (handSize - 1); i++) {
            Card card = hand.getCard(i);

            for (int j = i + 1; j < handSize; j++) {
                Card card2 = hand.getCard(j);

                if(!cheated) {
                    if (card.getValue() == card2.getValue() && card.getColor() == card2.getColor()) {
                        cheated = true;
                        this.errorMsg += player.getName() + Language.GAME_ERROR_SAME_CARD;
                    }
                }
            }
        }

        return cheated;
    }
}
