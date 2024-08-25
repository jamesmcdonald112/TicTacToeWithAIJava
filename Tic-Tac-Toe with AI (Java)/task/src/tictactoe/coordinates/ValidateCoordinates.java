package tictactoe.coordinates;

public class ValidateCoordinates {

    /**
     * Validates the String provided to make sure it is valid coordinates. The length is checked
     * first, then string is checked to make sure only numeric values are provided and finally
     * the coordinates are parsed and checked to see if they are within the bounds of the game.
     * @param coordinates
     * @return
     * @throws IllegalArgumentException
     */
    public static boolean isValidCoordinates(String coordinates) throws IllegalArgumentException{
        String[] parts = coordinates.split(" ");

        // Is the correct length
        if (!isCorrectLength(parts)) {
            throw new IllegalArgumentException("You should enter numbers!");
        }

        // Check if the coordinates are numeric and parse them
        int[] intCoordinates = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            if (!isNumeric(parts[i])) {
                throw new IllegalArgumentException("You should enter numbers!");
            } else {
                intCoordinates[i] = Integer.parseInt(parts[i]);
            }
        }

        // Is within bounds of the table
        if (!isWithinBounds(intCoordinates)) {
            throw new IllegalArgumentException("Coordinates should be from 1 to 3!");
        }

        // Passes all validation
        return true;
    }

    /**
     * Checks the table to see if there is a symbol at the chosen coordinates.
     *
     * @param coordinates The coordinates to check
     * @param table The table to check
     * @return True of it is occupied; false otherwise.
     */
    public static boolean isOccupied(int[] coordinates, char[][] table) {
        char symbol = table[coordinates[0] - 1][coordinates[1] - 1]; // Minus one for zero index
        return (symbol == 'X' || symbol == 'O');
    }

    /**
     * Checks that the initial input is the correct size.
     *
     * @param coordinates The coordinates to be checked
     * @return True if they are the correct size; false otherwise.
     */
    private static boolean isCorrectLength(String[] coordinates) {
        return coordinates.length == 2;
    }

    /**
     * Checks if a string is numeric
     *
     * @param string The string to be checked
     * @return True if it is numeric; false otherwise.
     */
    private static boolean isNumeric(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Checks to ensure the coordinates are within bounds for the game.
     *
     * @param coordinates The coordinates to be checked.
     * @return True if the coordinates are within bounds; false otherwise.
     */
    private static boolean isWithinBounds(int[] coordinates) {
        return (coordinates[0] >= 1 && coordinates[0] <=3) && (coordinates[1] >=1 && coordinates[1] <=3);
    }

}
