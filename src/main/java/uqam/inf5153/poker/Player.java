package uqam.inf5153.poker;

public class Player {
    private String name;
    private Hand hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    /**
     * Getters.
     */
    public Hand getHand() {
        return this.hand;
    }

    public String getName() {
        return this.name;
    }

    /**
     * Take a card in order to add it to your hand.
     * @param card the card that is to be taken
     */
    public void takeCard(Card card) {
        this.hand.addCard(card);
    }
}
