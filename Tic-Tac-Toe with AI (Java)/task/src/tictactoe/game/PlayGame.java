package tictactoe.game;

import tictactoe.coordinates.ValidateCoordinates;
import tictactoe.io.input.UserInputManager;
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

        System.out.println("Enter the coordinates: ");
        int[] coordinates = UserInputManager.getUserCoordinates();


    }
}
