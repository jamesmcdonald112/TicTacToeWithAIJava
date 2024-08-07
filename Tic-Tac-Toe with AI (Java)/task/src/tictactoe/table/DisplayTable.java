package tictactoe.table;

public class DisplayTable {

    /**
     * Formats and displays the formatted table to the console
     *
     * @param table The table to be formatted and displayed
     */
    public static void displayTable(char[][] table) {
        String formattedTable = createFormattedTable(table);
        System.out.println(formattedTable);

    }

    /**
     * Creates a formatted table and returns it as a String.
     *
     * @param table The table to be formatted
     * @return The formatted table as a string.
     */
    private static String createFormattedTable(char[][] table) {
        StringBuilder formattedTable = new StringBuilder();

        // Append dashes to the top
        formattedTable.append(dashes());

        // Append each row with proper formatting
        for (int row = 0; row < table.length; row++) {
            formattedTable.append(formatRow(table[row]));
        }

        // Append dashes to the bottom
        formattedTable.append(dashes());

        return formattedTable.toString();
    }

    /**
     * Returns a string of '-'s
     *
     * @return Return '-'s as a string
     */
    private static String dashes() {
        return "---------\n";
    }


    /**
     * Formats a single row of the table for display
     *
     * @param row The row to be formatted.
     * @return The formatted row as a string.
     */
    private static String formatRow(char[] row) {
        StringBuilder formattedRow = new StringBuilder("| ");

        for (char cell : row) {
            formattedRow.append(cell).append(" ");
        }
        // Append a pipe at the end;
        formattedRow.append("|\n");
        return formattedRow.toString();
    }


}
