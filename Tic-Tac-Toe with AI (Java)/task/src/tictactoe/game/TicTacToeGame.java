package tictactoe.game;

import tictactoe.gameSettings.GameSettings;
import tictactoe.player.*;
import tictactoe.table.CreateTableArray;
import tictactoe.table.DisplayTable;

public class TicTacToeGame {

    /**
     * Starts the Tic-Tac-Toe game. It loops until the user chooses to exit the game.
     * The method prompts for game settings, initialises the board, and begins the game loop.
     */
    public void startGame() {
        boolean isGameRunning = true;
        while (isGameRunning) {
            // Prompt user for the game settings
            GameSettings gameSettings = new GameSettings();

            // Check if the user requested to exit the game
            if (gameSettings.isExitCommand()) {
                isGameRunning = false;
                System.out.println("Exiting the game...");
            } else {
                // Initialise player setting and game board
                Player[] players = initialisePlayerSettings(gameSettings);
                char[][] table = CreateTableArray.createEmptyTable();
                runGame(table, players);
            }
        }

    }

    /**
     * Initialises the player settings (human or AI)
     *
     * @param gameSettings The GameSettings object containing the game settings
     * @return A string array with the player types for Player X and Player O
     */
    private Player[] initialisePlayerSettings(GameSettings gameSettings) {
        String[] settings = gameSettings.getSettings();

       // Create player X
        Player playerX = settings[1].equalsIgnoreCase("user")
                ? new Player('X', PlayerType.USER)
                : new Player('X', getDifficultyLevel(settings[1]));

        // Create Player O
        Player playerO = settings[2].equalsIgnoreCase("user")
                ? new Player('O', PlayerType.USER)
                : new Player('O', getDifficultyLevel(settings[2]));

        return new Player[]{playerX, playerO};
    }

    private DifficultyLevel getDifficultyLevel(String input) {
        switch (input.toLowerCase()) {
            case "easy" :
                return DifficultyLevel.EASY;
            case "medium" :
                return DifficultyLevel.MEDIUM;
            case "hard" :
                return DifficultyLevel.HARD;
            default:
                throw new IllegalArgumentException("Invalid difficulty level: " + input);
        }
    }

    private static void runGame(char[][] table, Player[] players) {
        Player playerX = players[0];
        Player playerO = players[1];

        // Display the table
        DisplayTable.displayTable(table);

        // Flag to loop the game.
        boolean running = true;
        while (running) {

            // Analyse the players turn based on the state of the game.
            Player currentPlayer = AnalysePlayerTurn.analysePlayerTurn(table, playerX, playerO);

            MakeMove.executeMove(table, currentPlayer);

            // Display the updated table.
            DisplayTable.displayTable(table);

            // Check to see if the game is finsihed.
            if (AnalyseGameState.isGameFinished(table, playerX, playerO)) {
                running = false;
            }
        }
    }
}
