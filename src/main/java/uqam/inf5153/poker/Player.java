package uqam.inf5153.poker;

public class Player {
    private String name;
    private String[] hand;

    public Player(String name) {
        this.name = name;
    }

    public void setHand(String[] hand) {
        this.hand = hand;
    }

    public String[] getHand() {
        return hand;
    }
}
