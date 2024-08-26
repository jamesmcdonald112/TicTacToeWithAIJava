package tictactoe.game;

import tictactoe.gameSettings.GameSettings;
import tictactoe.io.input.UserInputManager;
import tictactoe.player.AnalysePlayerTurn;
import tictactoe.player.MakeMove;
import tictactoe.player.Player;
import tictactoe.table.CreateTableArray;
import tictactoe.table.DisplayTable;

public class PlayGame {

    public void startGame() {
        boolean running = true;
        while (running) {
            // Input commands and validate them
            GameSettings gameSettings = new GameSettings();

            // Create an empty table
            char[][] table = CreateTableArray.createEmptyTable();
            runGame(table);
        }

    }

    private static void runGame(char[][] table) {
        // Display the table
        DisplayTable.displayTable(table);

        // Flag to loop the game.
        boolean running = true;
        while (running) {

            // Analyse the players turn based on the state of the game.
            Player currentPlayer = AnalysePlayerTurn.analysePlayerTurn(table);

            // Player's turn
            if (currentPlayer == Player.PLAYER_X) {
                MakeMove.execute(table, currentPlayer);
            } else {
                // Computers turn.
                System.out.println("Making move level \"easy\"\n");
                MakeMove.executeRandomMove(table, Player.PLAYER_O);
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
