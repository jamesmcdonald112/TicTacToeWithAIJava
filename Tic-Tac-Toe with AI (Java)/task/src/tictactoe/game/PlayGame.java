package tictactoe.game;

import tictactoe.coordinates.UserCoordinatesHandler;
import tictactoe.coordinates.ValidateCoordinates;
import tictactoe.io.input.UserInputManager;
import tictactoe.player.AnalysePlayerTurn;
import tictactoe.player.MakeMove;
import tictactoe.player.Player;
import tictactoe.table.CreateTableArray;
import tictactoe.table.DisplayTable;

import java.util.Arrays;

public class PlayGame {

    public void startGame() {
        System.out.println("Enter the cells: ");
        // TODO: Use this in the final version
        String cells = UserInputManager.getUserInputString();

        // Create the table from the input and display it in the console.
//        String cells = "_XXOO_OX_";
        char[][] table = CreateTableArray.createTableFromString(cells);
        DisplayTable.displayTable(table);

        Player currentPlayer = AnalysePlayerTurn.analysePlayerTurn(table);

        // TODO: Use this in the final version
        MakeMove.execute(table, currentPlayer);

        DisplayTable.displayTable(table);

        AnalyseGameState.analyseGameState(table);



    }
}
