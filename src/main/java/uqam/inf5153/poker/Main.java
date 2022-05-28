package uqam.inf5153.poker;
import java.util.*;

/**
 * A class to find the winner in a poker game
 */
public class Main {

    static String endMessage;

    /**
     * The main function. If no arguments given, we will use stdin to read the data.
     * @param args the arguments (the variable number of hands).
     */
    public static void main(String[] args) {
        RulesHandler rulesHandler = new RulesHandler();
        ErrorHandler errorHandler = new ErrorHandler();
        List<Player> players;
        GameState gameState;

        if (args.length != 0) {
            players = generatePlayersFromArguments(args);
        } else {
            players = generatePlayersFromInput();
        }

        gameState = determineGameValidity(players, errorHandler);

        if (gameState == GameState.VALID) {
            endMessage = determineEndgameState(players, rulesHandler);
        } else {
            endMessage = errorHandler.getErrorMsg();
        }

        System.out.println(endMessage);
    }

    /**
     * Determines the end state of the game.
     * @param players The list of players in the game
     * @param rh A reference to the rules handler
     * @return a string representing the end state of the game
     */
    private static String determineEndgameState(List<Player> players, RulesHandler rh) {
        String endgame;
        int numPlayers = players.size();

        for (int i = 0; i < numPlayers; i++) {
            rh.findStrongestCombination(players.get(i));
        }

        rh.determineEndstate(players);
        rh.determineWinner(players);
        endgame = rh.getEndgame();

        return endgame;
    }

    /**
     * Dertemines if one the players has a hand that invalidates the game.
     * @param players The list of players in the game
     * @param eh A reference to the error handler
     * @return the state of the game, whether it is valid or invalid
     */
    private static GameState determineGameValidity(List<Player> players, ErrorHandler eh) {
        GameState gameState = GameState.VALID;
        int numplayers = players.size();

        for (int i = 0; i < numplayers; i++) {
            Player currentPlayer = players.get(i);

            if (eh.verifyBigHand(currentPlayer)) {
                gameState = GameState.INVALID;
            }

            if(eh.verifySmallHand(currentPlayer)) {
                gameState = GameState.INVALID;
            }

            if(eh.verifyColor(currentPlayer)) {
                gameState = GameState.INVALID;
            }

            if(eh.verifyValue(currentPlayer)) {
                gameState = GameState.INVALID;
            }

            if (eh.verifyCheating(currentPlayer)) {
                gameState = GameState.INVALID;
            }
        }
        return gameState;
    }

    /**
     * Reads the arguments given and generates the players accordingly.
     * @param args A list of string, each string containing the data for the associated player's hand
     * @return the list of players
     */
    private static List<Player> generatePlayersFromArguments(String[] args) {
        List<Player> players =  new ArrayList<Player>();

        for (int i = 0; i < args.length; i++) {
            players.add(new Player(Language.PLAYER_NAME + (i + 1)));
            String [] textCards = stringToArray(args[i].trim().toUpperCase());

            for (int j = 0; j < textCards.length; j++) {
                players.get(i).takeCard(new Card(textCards[j]));
            }
        }

        return players;
    }

    /**
     * Reads the inputs from the terminal and generates the players accordingly.
     * @return the list of players
     */
    private static List<Player> generatePlayersFromInput() {
        List<Player> players =  new ArrayList<Player>();
        Scanner sc = new Scanner(System.in);

        System.out.print(Language.PLAYER_NUMBER_QUERY);
        int numPlayers = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numPlayers; i++) {
            System.out.print(Language.PLAYER_NAME + (i + 1) + Language.PLAYER_HAND_QUERY);

            String [] textCards = stringToArray(sc.nextLine().trim().toUpperCase());
            players.add(new Player(Language.PLAYER_NAME + (i + 1)));

            for (int j = 0; j < textCards.length; j++) {
                players.get(i).takeCard(new Card(textCards[j]));
            }
        }

        sc.close();
        return players;
    }

    /**
     * Transform a data String into an array of Strings.
     * @param s the hand of the player, e.g., "1C 2C TD JH JS"
     * @return the hand as separated card encoded as strings, ["1C", "2C", "TD", "JH", "JS"]
     */
    private static String[] stringToArray(String s) {
        return s.split(" ");
    }
}
