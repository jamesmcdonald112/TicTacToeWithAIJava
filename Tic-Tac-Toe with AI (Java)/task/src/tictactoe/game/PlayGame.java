package tictactoe.game;

import tictactoe.coordinates.UserCoordinatesHandler;
import tictactoe.table.CreateTableArray;
import tictactoe.table.DisplayTable;

import java.util.Arrays;

public class PlayGame {

    public void startGame() {
        System.out.println("Enter the cells: ");
//        String cells = UserInputManager.getUserInputString();

        // Create the table from the input and display it in the console.
        String cells = "_XXOO_OX_";
        char[][] table = CreateTableArray.createTableFromString(cells);
        DisplayTable.displayTable(table);

        int[] coordinates = UserCoordinatesHandler.promptUserCoordinates();







    }
}
