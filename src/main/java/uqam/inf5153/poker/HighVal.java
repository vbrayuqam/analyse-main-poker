package uqam.inf5153.poker;

public class HighVal extends Combination{
    private Card card;

    public HighVal(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return this.card.toString();
    }
}
