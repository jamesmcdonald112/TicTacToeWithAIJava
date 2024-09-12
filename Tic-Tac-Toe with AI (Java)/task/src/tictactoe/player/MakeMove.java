package tictactoe.player;

import tictactoe.coordinates.UserCoordinatesHandler;
import tictactoe.coordinates.ValidateCoordinates;
import tictactoe.game.AnalyseGameState;

import java.util.Random;

public class MakeMove {

    /**
     * Executes a move based on the player type
     *
     * @param table         The game board
     * @param currentPlayer The player making the move.
     */
    public static void executeMove(char[][] table, Player currentPlayer, Player opponent) {
        if (currentPlayer.isHuman()) {
            executeHumanMove(table, currentPlayer);
        } else {
            // Print the message for the AI's difficulty level
            System.out.println("Making move level \"" + currentPlayer.getDifficultyLevel().name().toLowerCase() + "\"");
            switch (currentPlayer.getDifficultyLevel()) {
                case EASY :
                    executeRandomMove(table, currentPlayer);
                    break;
                case MEDIUM :
                    executeMediumMove(table, currentPlayer, opponent);
                    break;
                case HARD :
                    executeHardMove(table, currentPlayer, opponent);
                    break;
            }

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

    private static void executeMediumMove(char[][] table, Player currentPlayer, Player opponent) {
        // If the current player can win, then win
        if (canWinThisMove(table, currentPlayer, opponent)) {
            executeWinningMove(table, currentPlayer);
        } else if (isBlockingMove(table, currentPlayer, opponent)) { // If the opponent can win, block
            executeBlockingMove(table, currentPlayer, opponent);
        } else { // Else randon
            executeRandomMove(table, currentPlayer);
        }
    }

    private static boolean canWinThisMove(char[][] table, Player currentPlayer, Player opponent) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (table[row][col] == ' ') {
                    table[row][col] = currentPlayer.getSymbol();

                    if (AnalyseGameState.isWinner(table, currentPlayer)) {
                        table[row][col] = ' '; // Reset board after checking
                        return true;
                    }
                    table[row][col] = ' '; // Reset spot if no win is found
                }
            }
        }
        return false;
    }

    private static void executeWinningMove(char[][] table, Player currentPlayer) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (table[row][col] == ' ') {
                    table[row][col] = currentPlayer.getSymbol();

                    if (AnalyseGameState.isWinner(table, currentPlayer)) {
                        return; // Winning move executed
                    }
                    table[row][col] = ' '; // Reset if not a winning move
                }
            }
        }
    }
    private static boolean isBlockingMove(char[][] table, Player currentPlayer,  Player opponent) {
      return canWinThisMove(table, opponent, currentPlayer); // The opponent and player are
        // swapped to see if the opponent can win next turn

    }

    private static void executeBlockingMove(char[][] table, Player currentPlayer, Player opponent) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (table[row][col] == ' ') {
                    // Simulate opponent move
                    table[row][col] = opponent.getSymbol();

                    // If the opponent would win with this move, block it
                    if (AnalyseGameState.isWinner(table, opponent)) {
                        table[row][col] = currentPlayer.getSymbol(); // Block with current player
                        // symbol
                        return;
                    }

                    // Reset the spot if its not a winning move for the opponent
                    table[row][col] = ' ';
                }
            }
        }
    }


    private static void executeHardMove(char[][] table, Player currentPlayer,  Player opponent) {
    }

}
