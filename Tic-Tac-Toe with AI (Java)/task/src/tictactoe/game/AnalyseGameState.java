package tictactoe.game;

import tictactoe.player.Player;

public class AnalyseGameState {

    public static boolean isWinner(char[][] table, Player player) {
        char symbol = player.getSymbol();
        return isWinnerRow(table, symbol) || isWinnerCol(table, symbol) || isWinnerDiagonally(table, symbol);
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
