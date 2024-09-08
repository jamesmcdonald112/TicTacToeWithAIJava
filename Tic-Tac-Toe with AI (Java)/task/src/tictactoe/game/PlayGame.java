package tictactoe.game;

import tictactoe.gameSettings.GameSettings;
import tictactoe.io.input.UserInputManager;
import tictactoe.player.AnalysePlayerTurn;
import tictactoe.player.MakeMove;
import tictactoe.player.Player;
import tictactoe.player.PlayerType;
import tictactoe.table.CreateTableArray;
import tictactoe.table.DisplayTable;

public class PlayGame {

    public void startGame() {
        boolean running = true;
        while (running) {
            // The user will be prompted for the game setting
            GameSettings gameSettings = new GameSettings();

            if (gameSettings.isExitCommand()) {
                running = false;
                System.out.println("Exiting the game...");
            } else {
                // Get the settings and save the player type to the players array.
                String[] settings = gameSettings.getSettings();
                // Create a new array to store whether Player X and Player O are human or AI
                String[] playersSettings = {settings[1], settings[2]};

                // Create an empty table
                char[][] table = CreateTableArray.createEmptyTable();
                runGame(table, playersSettings);
            }
        }

    }

    private static void runGame(char[][] table, String[] playerSettings) {
        // Display the table
        DisplayTable.displayTable(table);

        // Flag to loop the game.
        boolean running = true;
        while (running) {

            // Analyse the players turn based on the state of the game.
            Player currentPlayer = AnalysePlayerTurn.analysePlayerTurn(table);

            // Determine the current player type (X or O)
            String currentPlayerType;
            if (currentPlayer == Player.PLAYER_X) {
                currentPlayerType = playerSettings[0];
            } else {
                currentPlayerType = playerSettings[1];
            }

            // Execute the move based on whether it's a human or AI
            if (currentPlayerType.equalsIgnoreCase(PlayerType.USER.name())) {
                MakeMove.execute(table, currentPlayer);
            } else {
                System.out.println("Making move level \"easy\"\n");
                MakeMove.executeRandomMove(table, currentPlayer);
            }

            // Display the updated table.
            DisplayTable.displayTable(table);

            // Check to see if the game is finsihed.
            if (AnalyseGameState.isGameFinished(table)) {
                running = false;
            }
        }
    }
}
