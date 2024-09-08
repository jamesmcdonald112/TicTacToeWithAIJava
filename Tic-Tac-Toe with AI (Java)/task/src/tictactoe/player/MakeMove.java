package tictactoe.player;

import tictactoe.coordinates.UserCoordinatesHandler;
import tictactoe.coordinates.ValidateCoordinates;

import java.util.Random;

public class MakeMove {

    /**
     * Executes a move based on the player type
     *
     * @param table         The game board
     * @param currentPlayer The player making the move.
     */
    public static void executeMove(char[][] table, Player currentPlayer) {
        if (currentPlayer.isHuman()) {
            executeHumanMove(table, currentPlayer);
        } else {
            // Print the message for the AI's difficulty level
            System.out.println("Making move level \"" + currentPlayer.getDifficultyLevel().name().toLowerCase() + "\"");
            executeRandomMove(table, currentPlayer);
        }
    }

    /**
     * The human player is prompted for valid coordinates and the player's symbol is entered at
     * the selected coordinates.
     *
     * @param table         The table to place to symbol in.
     * @param currentPlayer The current player making the move.
     */
    private static void executeHumanMove(char[][] table, Player currentPlayer) {
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
    private static void executeRandomMove(char[][] table, Player currentPlayer) {
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
