package uqam.inf5153.poker;
import java.util.*;

/**
 * A class to find the winner in a poker game
 */
public class Main {

    // The result of the game

    static String endMessage;

    /**
     * The main function. If no arguments given, we will use stdin to read the data.
     * @param args the arguments (the variable number of hands).
     */
    public static void main(String[] args) {
        // Initialisation of the variables
        RulesHandler rulesHandler = new RulesHandler();
        ErrorHandler errorHandler = new ErrorHandler();
        List<Player> players;
        GameState gameState;

        // Determine the number of players and initiate them
        if (args.length != 0) {
            players = generatePlayersFromArguments(args);
        } else {
            players = generatePlayersFromInput();
        }

        // Verify if the game is valid
        gameState = determineGameValidity(players, errorHandler);

        // If valid proceed query the rules handler, if not query the error handler
        if (gameState == GameState.VALID) {
            endMessage = determineEndgameState(players, rulesHandler);
        } else {
            endMessage = errorHandler.getErrorMsg();
        }

        // Output the result of the query
        System.out.println(endMessage);
    }

    private static String determineEndgameState(List<Player> players, RulesHandler rh) {
        String endgameState = "TOASTIE";
        int numPlayers = players.size();

        for (int i = 0; i < numPlayers; i++) {
            rh.findStrongestCombination(players.get(i));

        }

        // Compare those combinations
        // Build endstate

        return endgameState;
    }

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
        String[] data = s.split(" ");

        return data;
    }
}
