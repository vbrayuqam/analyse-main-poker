package uqam.inf5153.poker;
import java.util.*;

/**
 * A class to find the winner in a poker game
 */
public class Main {

    // The result of the game
    static String result;


    /**
     * The main function. If no arguments given, we will use stdin to read the data.
     * @param args the arguments (the variable number of hands).
     */
    public static void main(String[] args) {
        List<Player> players =  new ArrayList<Player>();

        // Determine number of players and initiate them
        if (args.length != 0) {
            players = generatePlayersFromArguments(args);
        } else {
            players = generatePlayersFromInput();
        }

        // Safeproofing
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i));
        }




        // Check if error in the data
        //if(result != null && result.equals("ERROR")) {
        //    System.out.println("Result: " + result);
        //    return;
        //}
        // Do the comparison and store the result
        //result = comp(findComb(players.get(0).getHand()), findComb(players.get(1).getHand()));
        //Display the winner.
        //System.out.println("Result: " + result);
    }

    private static List<Player> generatePlayersFromArguments(String[] args) {
        List<Player> players =  new ArrayList<Player>();

        for (int i = 0; i < args.length; i++) {
            players.add(new Player(Language.PLAYER_NAME + (i + 1)));
            String [] textCards = str2Array(args[i].trim().toUpperCase());
            for (int j = 0; j < textCards.length; j++) {
                players.get(i).takeCard(createCard(textCards[j]));
            }
        }

        return players;
    }

    private static List<Player> generatePlayersFromInput() {
        List<Player> players =  new ArrayList<Player>();
        Scanner sc = new Scanner(System.in);

        System.out.print(Language.PLAYER_NUMBER_QUERY);
        int numPlayers = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numPlayers; i++) {
            System.out.print(Language.PLAYER_NAME + (i + 1) + Language.PLAYER_HAND_QUERY);
            String [] textCards = str2Array(sc.nextLine().trim().toUpperCase());
            players.add(new Player(Language.PLAYER_NAME + (i + 1)));
            for (int j = 0; j < textCards.length; j++) {
                players.get(i).takeCard(createCard(textCards[j]));
            }
        }

        sc.close();
        return players;
    }

    private static Card createCard(String textCard) {
        char valueChar = textCard.charAt(0);
        char colorChar = textCard.charAt(1);

        Color color = extractColor(colorChar);
        Value value = extractValue(valueChar);

        return new Card(color, value);
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

    /**
     * Transform a data String into an array of Strings. Handle errors if not containing 5 cards,
     * or of a card is not a regular one (not a good value, not a good suit). If encountering an
     * error, we store "ERROR" in the result string.
     * @param s the hand of the player, e.g., "1C 2C TD JH JS"
     * @return the hand as separated card encoded as strings, ["1C", "2C", "TD", "JH", "JS"]
     */
    private static String[] str2Array(String s) {
        Character[] vSymb = { '1', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K' };
        Set<Character> vs = new HashSet<>(Arrays.asList(vSymb));
        Character[] sSymb = { 'C', 'D', 'H', 'S' };
        Set<Character> ss = new HashSet<>(Arrays.asList(sSymb));
        String[] data = s.split(" ");
        if (data.length != 5)
            result = "ERROR";
        for(String d: data) {
            if(d.length() != 2)
                result = "ERROR";
            if(!vs.contains(d.charAt(0)) || !ss.contains(d.charAt(1)))
                result = "ERROR";
        }
        return data;
    }

    /**
     * Find the highest combination in a hand. We detect flush (F), pair (P), and highest card (H)
     * for now. The result is the combination detected, followed by its highest card (to avoid ex-aequo).
     * @param cs the hand, e.g., ["1C", "2C", "TD", "JH", "JS"]
     * @return the highest combination, e.g., "P J" (as the example contains a Pair of Jacks)
     */
    private static String findComb(String[] cs) {
        // Detect a flush
        char col = cs[0].charAt(1);
        boolean f = true;
        for(String c: cs) {
            if (c.charAt(1) != col)
                f = false;
        }
        if(f)
            return "F " + maxVal(cs);

        // Detect a pair
        char vMax = 'X';
        for(int i = 0; i < cs.length; i++) {
            for(int j = i+1; j < cs.length; j++) {
                if (cs[i].charAt(0) == cs[j].charAt(0)
                        && (vMax == 'X' || getTable().get(cs[i].charAt(0)) > getTable().get(vMax))) {
                    vMax = cs[i].charAt(0);
                }
            }
        }
        if(vMax != 'X')
            return "P " + vMax;

        // Nothing interesting => Highest card
        return "H " + maxVal(cs);
    }

    /**
     * Compare two combinations, and returns the winner among p1 or p2, or tie if ex-aequo.
     * We support full (F), pair (P), and highest card (H) for now.
     * @param p1 the combination of p1, e.g., "P J"
     * @param p2 the combination of p2, e.g., "F T"
     * @return P1 if p1 wins, P2 if p2 wins, TIE elsewhere (here P2)
     */
    private static String comp(String p1, String p2) {
        if(p1.startsWith("F")) {
            if (p2.startsWith("F"))
                return tie(p1,p2);
            else {
                return "P1";
            }
        } else if (p1.startsWith("P")) {
            if (p2.startsWith("F"))
                return "P2";
            else if (p2.startsWith("P"))
                return tie(p1,p2);
            else {
                return "P1";
            }
        } else { // P1 is "Highest card"
            if(p2.startsWith("F") || p2.startsWith("P")) {
                return "P2";
            }
            return tie(p1,p2);
        }
    }

    /**
     * find the highest card in a given hand
     * @param cs the hand to analyse, e.g., ["1C", "2C", "TD", "JH", "JS"]
     * @return the highest card code, here "J"
     */
    private static char maxVal(String[] cs) {
        int max = getTable().get(cs[0].charAt(0));
        char result = cs[0].charAt(0);
        for(String c: cs) {
            if (getTable().get(c.charAt(0)) > max) {
                max = getTable().get(c.charAt(0));
                result = c.charAt(0);
            }
        }
        return result;
    }

    /**
     * When to hands contains the same combination, returns the highest one, or tie if truly equivalent;
     * @param p1 the combination in p1's hand, e.g., "P J"
     * @param p2 the combination in p2's hand, e.g., "P Q"
     * @return P1 if p1 wins, P2 if p2 wins, TIE elsewhere (here P2)
     */
    private static String tie(String p1, String p2) {
        if(getTable().get(p1.charAt(2)).equals(getTable().get(p2.charAt(2))))
            return "TIE";
        return (getTable().get(p1.charAt(2)) > getTable().get(p2.charAt(2)) ? "P1" : "P2");
    }

    /**
     * Build the comparaison table used to compare cards (ace is 1, two is 2, ..., queen is 12 and King is 13).
     * @return the comparison table stored in a Map.
     */
    private static Map<Character, Integer> getTable() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('1', 1);  map.put('2', 2);  map.put('3', 3);
        map.put('4', 4);  map.put('5', 5);  map.put('6', 6);
        map.put('7', 7);  map.put('8', 8);  map.put('9', 9);
        map.put('T', 10); map.put('J', 11); map.put('Q', 12);
        map.put('K', 13);
        return map;
    }

}
