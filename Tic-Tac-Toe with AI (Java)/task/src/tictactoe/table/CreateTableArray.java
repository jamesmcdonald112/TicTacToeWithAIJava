package tictactoe.table;

public class CreateTableArray {

    /**
     * Creates a 3 * 3 char matrix from a string input.
     *
     * @param cells The cells to enter each cell of the char[][]
     * @return The table as a char[][].
     */
    public static char[][] createTableFromString(String cells) {
        char[][] table = new char[3][3];

        // Keep track of the index for the cell String
        int cellIndex = 0;
        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++) {
                // Assign each character of the string to the table
                char currentChar = cells.charAt(cellIndex);

                // Replace underscores with blank spaces.
                if (currentChar == '_') {
                    table[row][col] = ' ';
                } else {
                    table[row][col] = cells.charAt(cellIndex);
                }
                cellIndex++;
            }
        }
        return table;
    }
}
