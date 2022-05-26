package uqam.inf5153.poker;

public class Player {
    private String name;
    private Hand hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public Hand getHand() {
        return this.hand;
    }

    public String getName() {
        return this.name;
    }

    public void takeCard(Card card) {
        this.hand.addCard(card);
    }

    @Override
    public String toString() {
        return hand.toString();
    }
}
