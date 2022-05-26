package uqam.inf5153.poker;

public class ErrorHandler {
    final int POKER_HAND_SIZE = 5;
    private String errorMsg = Language.GAME_ERROR;

    public ErrorHandler() {
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public boolean verifyBigHand(Player player) {
        boolean isBig = false;
        Hand hand = player.getHand();

        if (hand.getNumOfCards() > POKER_HAND_SIZE) {
            isBig = true;
            this.errorMsg += player.getName() + Language.GAME_ERROR_BIG_HAND;
        }

        return isBig;
    }

    public boolean verifySmallHand(Player player) {
        boolean isSmall = false;
        Hand hand = player.getHand();

        if (hand.getNumOfCards() < POKER_HAND_SIZE) {
            isSmall = true;
            this.errorMsg += player.getName() + Language.GAME_ERROR_SMALL_HAND;
        }

        return isSmall;
    }


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
