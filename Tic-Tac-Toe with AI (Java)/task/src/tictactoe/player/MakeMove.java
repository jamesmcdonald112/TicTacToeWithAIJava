package tictactoe.player;

import tictactoe.coordinates.UserCoordinatesHandler;
import tictactoe.coordinates.ValidateCoordinates;

public class MakeMove {

    /**
     * The current player is prompted for valid coordinates and the player's symbol is entered at
     * the selected coordinates.
     *
     * @param table The table to place to symbol in.
     * @param currentPlayer The current player making the move.
     */
    public static void execute(char[][] table, Player currentPlayer) {
        boolean validMove = false;
        while (!validMove) {
            int[] coordinates = UserCoordinatesHandler.promptUserCoordinates();
            if (ValidateCoordinates.isOccupied(coordinates, table)) {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                table[coordinates[0] -1][coordinates[1] - 1] = currentPlayer.getSymbol();
                validMove = true;
            }
        }
    }
}
