package tictactoe.io.input;

import java.util.Scanner;

public class UserInputManager {
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Returns the user input as a string.
     *
     * @return The user's input as a string.
     */
    public static String getUserInputString() {
        return SCANNER.nextLine();
    }

    public static int[] getUserCoordinates() {
        int[] coordinates = new int[2];
        String userInput = getUserInputString();
        String[] parts = userInput.split(" ");

        if (parts.length != 2) {
            System.out.println("Error: You must enter exactly two numbers.");
        }
        try {
            coordinates[0] = Integer.parseInt(userInput);
            coordinates[1] = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            System.out.println("Input must be a number!");
        }
        return coordinates;
    }

}
