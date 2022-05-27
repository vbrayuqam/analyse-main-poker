package uqam.inf5153.poker;

public class Flush extends Combination {
    private Hand hand;
    private Color color;
    private int strength;


    public Flush(Hand hand, Color color, int strength) {
        this.hand = hand;
        this.color = color;
        this.strength = 600 + strength;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public String toString() {
        return Language.FLUSH + color + Language.DOT;
    }
}
