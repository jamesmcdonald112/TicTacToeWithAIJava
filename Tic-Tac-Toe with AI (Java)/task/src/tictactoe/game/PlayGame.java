package tictactoe.game;

import tictactoe.coordinates.UserCoordinatesHandler;
import tictactoe.player.AnalysePlayerTurn;
import tictactoe.player.Player;
import tictactoe.table.CreateTableArray;
import tictactoe.table.DisplayTable;

import java.util.Arrays;

public class PlayGame {

    public void startGame() {
        System.out.println("Enter the cells: ");
        // TODO: Use this in the final version
//        String cells = UserInputManager.getUserInputString();

        // Create the table from the input and display it in the console.
        String cells = "_XXOOXOXX";
        char[][] table = CreateTableArray.createTableFromString(cells);
        DisplayTable.displayTable(table);
        // TODO: Use this in the final version
//        int[] coordinates = UserCoordinatesHandler.promptUserCoordinates();

        
        int[] coordinates = {1, 1};

        Player currentPlayer = AnalysePlayerTurn.analysePlayerTurn(table);
        boolean winnerO = AnalyseGameState.isWinner(table, Player.PLAYER_O);
        boolean winnerX = AnalyseGameState.isWinner(table, Player.PLAYER_X);

        System.out.println("X wins: " + winnerX);
        System.out.println("O wins: " + winnerO);

    }
}
