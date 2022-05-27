package uqam.inf5153.poker;

public class Pair extends Combination{
    private Card firstCard;
    private Card secondCard;

    public Pair() {
    }

    public Card getFirstCard() {
        return firstCard;
    }

    public Card getSecondCard() {
        return secondCard;
    }

    public void setFirstCard(Card firstCard) {
        this.firstCard = firstCard;
    }

    public void setSecondCard(Card secondCard) {
        this.secondCard = secondCard;
    }

    @Override
    public String toString() {
        return this.firstCard.toString() + this.secondCard.toString();
    }
}
