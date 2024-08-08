package tictactoe.coordinates;

public class ValidateCoordinates {


    public static boolean isValidCoordinates(String coordinates) throws IllegalArgumentException{
        String[] parts = coordinates.split(" ");

        // Is the correct length
        if (!isCorrectLength(parts)) {
            throw new IllegalArgumentException("Error! Coordinates must be two numbers");
        }

        // Check if the coordinates are numeric and parse them
        int[] intCoordinates = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            if (!isNumeric(parts[i])) {
                throw new IllegalArgumentException("Error! Numbers must be provided as " +
                        "coordinates");
            } else {
                intCoordinates[i] = Integer.parseInt(parts[i]);
            }
        }

        // Is within bounds of the table
        if (!isWithinBounds(intCoordinates)) {
            throw new IllegalArgumentException("Error! Must be within bounds of the game.");
        }

        // Passes all validation
        return true;
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
