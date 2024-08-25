package tictactoe.player;

import tictactoe.coordinates.UserCoordinatesHandler;
import tictactoe.coordinates.ValidateCoordinates;

import java.util.Random;

public class MakeMove {

    /**
     * The current player is prompted for valid coordinates and the player's symbol is entered at
     * the selected coordinates.
     *
     * @param table         The table to place to symbol in.
     * @param currentPlayer The current player making the move.
     */
    public static void execute(char[][] table, Player currentPlayer) {
        boolean validMove = false;
        while (!validMove) {
            int[] coordinates = UserCoordinatesHandler.promptUserCoordinates();
            if (ValidateCoordinates.isOccupied(coordinates, table)) {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                table[coordinates[0] - 1][coordinates[1] - 1] = currentPlayer.getSymbol();
                validMove = true;
            }
        }
    }

    /**
     * A valid move is made randomly for the players turn.
     *
     * @param table         The table for the symbol to be placed on.
     * @param currentPlayer The current player
     */
    public static void executeRandomMove(char[][] table, Player currentPlayer) {
        Random random = new Random();
        boolean validMove = false;
        while (!validMove) {
            int row = random.nextInt(1, 4);
            int col = random.nextInt(1, 4);
            int[] coordinates = new int[]{row, col};
            if (!ValidateCoordinates.isOccupied(coordinates, table)) {
                table[coordinates[0] - 1][coordinates[1] - 1] = currentPlayer.getSymbol();
                validMove = true;
            }
        }
    }
}
