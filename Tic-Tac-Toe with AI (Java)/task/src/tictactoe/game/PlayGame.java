package tictactoe.game;

import tictactoe.player.AnalysePlayerTurn;
import tictactoe.player.MakeMove;
import tictactoe.player.Player;
import tictactoe.table.CreateTableArray;
import tictactoe.table.DisplayTable;

public class PlayGame {

    public void startGame() {
        // Create an empty table
        char[][] table = CreateTableArray.createEmptyTable();
        DisplayTable.displayTable(table);

        // Flag to keep the game in a loop.
        boolean running = true;
        while (running) {

            Player currentPlayer = AnalysePlayerTurn.analysePlayerTurn(table);

            if (currentPlayer == Player.PLAYER_X) {
                MakeMove.execute(table, currentPlayer);
            } else {
                System.out.println("Making move level \"easy\"\n");
                MakeMove.executeRandomMove(table, Player.PLAYER_O);
            }

            DisplayTable.displayTable(table);

            if (AnalyseGameState.isGameFinished(table)) {
                running = false;
            }
        }




    }
}
