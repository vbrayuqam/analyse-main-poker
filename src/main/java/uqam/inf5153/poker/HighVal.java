package uqam.inf5153.poker;

public class HighVal extends Combination{
    private Card card;
    private int strength;

    public HighVal(Card card) {
        this.card = card;
        this.strength = 100 + card.getStrength();
    }

    /**
     * Getter.
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Outputs a string.
     * @return a formatted string representing the highest value card
     */
    @Override
    public String toString() {
        return Language.HIGH_VAL + card.getValue() + Language.DOT;
    }
}
