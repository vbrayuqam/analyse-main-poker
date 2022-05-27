package uqam.inf5153.poker;

public class Pair extends Combination{
    private Card firstCard;
    private Card secondCard;
    private int strength;


    public Pair() {
    }

    public Card getFirstCard() {
        return firstCard;
    }

    public Card getSecondCard() {
        return secondCard;
    }

    public int getStrength() {
        return strength;
    }

    public void setFirstCard(Card firstCard) {
        this.firstCard = firstCard;
    }

    public void setSecondCard(Card secondCard) {
        this.secondCard = secondCard;
    }

    public void calculateStrength() {
        this.strength = 200 + firstCard.getStrength();
    }

    @Override
    public String toString() {
        return Language.PAIR + firstCard.getValue().toString() + Language.DOT;
    }
}
