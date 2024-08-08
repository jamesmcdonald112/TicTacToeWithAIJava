package tictactoe.coordinates;

import tictactoe.io.input.UserInputManager;

import java.util.InputMismatchException;

public class UserCoordinatesHandler {

    /**
     * Handles the logic for prompting the user for the coordinates, validating and parsing the
     * coordinates.
     *
     * @return Valid coordinates as an int array.
     * @throws IllegalArgumentException If the input is invalid.
     */
    public static int[] promptUserCoordinates() {
        boolean isValidCoordinates = false;
        int[] coordinates = null;

        while (!isValidCoordinates) {
            System.out.println("Enter the coordinates: ");
            String userInput = UserInputManager.getUserInputString();
            try {
                coordinates = parseCoordinates(userInput);
                isValidCoordinates = true; // If no exception is thrown, the coordinates are valid
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return coordinates;
    }

    /**
     * Validates the input and parses it into an int array.
     *
     * @param input The input to be validated and parsed as ints.
     * @return An int array.
     * @throws IllegalArgumentException If the input is invalid.
     */
    private static int[] parseCoordinates(String input) throws InputMismatchException {
        ValidateCoordinates.isValidCoordinates(input);
        String[] parts = input.split(" ");
        int[] coordinates = new int[2];
        coordinates[0] = Integer.parseInt(parts[0]);
        coordinates[1] = Integer.parseInt(parts[1]);
        return coordinates;
    }

}
