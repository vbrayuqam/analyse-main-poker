package uqam.inf5153.poker;

public class Card {
    private Color color;
    private Value value;
    private int strength;

    public Card(String textCard) {
        this.color = extractColor(textCard.charAt(1));
        this.value = extractValue(textCard.charAt(0));
        this.strength = extractStrength(textCard.charAt(0));
    }

    /**
     * Getters.
     */
    public Color getColor() {
        return color;
    }

    public Value getValue() {
        return value;
    }

    public int getStrength() {
        return strength;
    }

    /**
     * Extracts a Color from a formatted string.
     * @param colorChar a char that represents the value of a card
     * @return the Color
     */
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

    /**
     * Extracts a Value from a formatted string.
     * @param valueChar a char that represents the value of a card
     * @return the Value
     */
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

    /**
     * Extracts a strength from a formatted string.
     * @param valueChar a char that represents the value of a card
     * @return an int representing the strength
     */
    private int extractStrength(char valueChar) {
        int strength;
        switch (valueChar)
        {
            case '1':
                strength = 1;
                break;
            case '2':
                strength = 2;
                break;
            case '3':
                strength = 3;
                break;
            case '4':
                strength = 4;
                break;
            case '5':
                strength = 5;
                break;
            case '6':
                strength = 6;
                break;
            case '7':
                strength = 7;
                break;
            case '8':
                strength = 8;
                break;
            case '9':
                strength = 9;
                break;
            case 'T':
                strength = 10;
                break;
            case 'J':
                strength = 11;
                break;
            case 'Q':
                strength = 12;
                break;
            case 'K':
                strength = 13;
                break;
            default :
                strength = 0;
        }
        return strength;
    }
}
