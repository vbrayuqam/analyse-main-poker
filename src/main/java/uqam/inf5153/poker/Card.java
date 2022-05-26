package uqam.inf5153.poker;

public class Card {
    private Color color;
    private Value value;

    public Card(String textCard) {
        this.color = extractColor(textCard.charAt(1));
        this.value = extractValue(textCard.charAt(0));
    }

    public Color getColor() {
        return color;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public String toString() {
        String cardString = "";
        return color.toString() + value.toString();
    }

    private static Color extractColor(char colorChar) {
        Color color;
        switch (colorChar) {
            case 'H':
                color = Color.HEARTS;
                break;
            case 'C':
                color = Color.CLUBS;
                break;
            case 'D':
                color = Color.DIAMONDS;
                break;
            case 'S':
                color = Color.SPADES;
                break;
            default :
                color = Color.INCORRECT;
        }
        return color;
    }

    private static Value extractValue(char valueChar) {
        Value value = null;
        switch (valueChar)
        {
            case '1':
                value = Value.ACE;
                break;
            case '2':
                value = Value.TWO;
                break;
            case '3':
                value = Value.THREE;
                break;
            case '4':
                value = Value.FOUR;
                break;
            case '5':
                value = Value.FIVE;
                break;
            case '6':
                value = Value.SIX;
                break;
            case '7':
                value = Value.SEVEN;
                break;
            case '8':
                value = Value.EIGHT;
                break;
            case '9':
                value = Value.NINE;
                break;
            case 'T':
                value = Value.TEN;
                break;
            case 'J':
                value = Value.JACK;
                break;
            case 'Q':
                value = Value.QUEEN;
                break;
            case 'K':
                value = Value.KING;
                break;
            default :
                value = Value.INCORRECT;
        }
        return value;
    }
}
