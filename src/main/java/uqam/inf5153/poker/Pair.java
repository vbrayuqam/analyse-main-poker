package uqam.inf5153.poker;

public class Pair extends Combination{
    private Card firstCard;
    private Card secondCard;
    private int strength;


    public Pair() {
    }

    /**
     * Getters.
     */
    public Card getFirstCard() {
        return firstCard;
    }

    public Card getSecondCard() {
        return secondCard;
    }

    public int getStrength() {
        return strength;
    }

    /**
     * Setters.
     */
    public void setFirstCard(Card firstCard) {
        this.firstCard = firstCard;
    }

    public void setSecondCard(Card secondCard) {
        this.secondCard = secondCard;
    }

    /**
     * Calculates the strength of the pair.
     */
    public void calculateStrength() {
        this.strength = 200 + firstCard.getStrength();
    }

    /**
     * Outputs a string
     * @return a formatted string representing the pair
     */
    @Override
    public String toString() {
        return Language.PAIR + firstCard.getValue().toString() + Language.DOT;
    }
}
