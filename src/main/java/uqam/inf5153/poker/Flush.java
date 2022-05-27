package uqam.inf5153.poker;

public class Flush extends Combination {
    private Hand hand;

    public Flush(Hand hand) {
        this.hand = hand;
    }

    @Override
    public String toString() {
        return this.hand.toString();
    }
}
