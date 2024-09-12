package tictactoe.game;

import tictactoe.player.Player;

public class AnalyseGameState {

    /**
     * The state of the game is analysed to see if there is a winner, draw or if the game is
     * still in progress.
     *
     * @param table The table to be checked.
     */
    public static boolean isGameFinished(char[][] table, Player playerX, Player playerO) {
        if (isWinner(table, playerO)) {
            System.out.println(GameState.O_WINS.getMessage());
            return true;
        } else if (isWinner(table, playerX)) {
            System.out.println(GameState.X_WINS.getMessage());
            return true;
        } else if (isDraw(table, playerX, playerO)) {
            System.out.println(GameState.DRAW.getMessage());
            return true;
        } else {
            return false;
        }
    }



    /**
     * Checks if the player has won the game by places three of their own symbols in a row
     * vertical, horizontally, or diagonally.
     *
     * @param table  The table to be checked.
     * @param player The player to match three in a row.
     * @return True if the player has won; false otherwise.
     */
    public static boolean isWinner(char[][] table, Player player) {
        char symbol = player.getSymbol();
        return isWinnerRow(table, symbol) || isWinnerCol(table, symbol) || isWinnerDiagonally(table, symbol);
    }

    /**
     * Checks the state of the table to see if it is a draw.
     *
     * @param table The table to be checked.
     * @return True if it is a draw; false otherwise.
     */
    private static boolean isDraw(char[][] table, Player playerX, Player playerO) {
        int count = 0;
        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++) {
                if (table[row][col] == playerX.getSymbol() || table[row][col] == playerO.getSymbol()) {
                    count++;
                }
            }
        }
        boolean playerXWins = isWinner(table, playerX);
        boolean playerOWins = isWinner(table, playerO);

        return !playerXWins && !playerOWins && (count == 9);
    }

    /**
     * Checks if the rows have three matching symbols
     *
     * @param table  The table to be checked
     * @param symbol The symbol to match
     * @return True if a row contains 3 matching symbols; false otherwise
     */
    private static boolean isWinnerRow(char[][] table, char symbol) {
        for (int row = 0; row < table.length; row++) {
            int symbolCount = 0;
            for (int col = 0; col < table[row].length; col++) {
                if (table[row][col] == symbol) {
                    symbolCount++;
                }
            }
            if (symbolCount == 3) {
                return true; // Found a row with three symbols
            }
        }

        return false; // No row has three symbols
    }

    /**
     * Checks the columns for three matching symbols.
     *
     * @param table  The table to be checked.
     * @param symbol The symbol to be matched.
     * @return True if three matching symbols are found in a column; false otherwise
     */
    private static boolean isWinnerCol(char[][] table, char symbol) {
        for (int col = 0; col < table[0].length; col++) {
            int symbolCount = 0;
            for (int row = 0; row < table.length; row++) {
                if (table[row][col] == symbol) {
                    symbolCount++;
                }
            }
            if (symbolCount == 3) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if there is a matching symbol both diagonal directions.
     *
     * @param table  The table to be checked
     * @param symbol The symbol to check
     * @return True if there are three matching symbols diagonally; false otherwise.
     */
    private static boolean isWinnerDiagonally(char[][] table, char symbol) {
        // Checks from top left (0,0) to bottom right (2,2) of the table
        int symbolCount = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i][i] == symbol) {
                symbolCount++;
            }
        }
        // Return true if the symbols match three in a row.
        if (symbolCount == 3) {
            return true;
        }

        symbolCount = 0;
        // Checks from bottom left (2,0) to top right (0,2) of the table
        for (int row = 0; row < table.length; row++) {
            int col = table.length - 1 - row;
            if (table[row][col] == symbol) {
                symbolCount++;
            }
        }

        return symbolCount == 3;
    }

}
