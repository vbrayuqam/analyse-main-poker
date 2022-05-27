package uqam.inf5153.poker;

public class Flush extends Combination {
    private Hand hand;
    private Color color;

    public Flush(Hand hand, Color color) {
        this.hand = hand;
        this.color = color;
    }

    @Override
    public String toString() {

        return Language.FLUSH + color + Language.DOT;
    }
}
