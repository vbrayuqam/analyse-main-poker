package uqam.inf5153.poker;

public class Card {
    private Color color;
    private Value value;

    public Card(Color color, Value value) {
        this.color = color;
        this.value = value;
    }

    @Override
    public String toString() {
        String cardString = "";
        return color.toString() + value.toString();
    }
}
