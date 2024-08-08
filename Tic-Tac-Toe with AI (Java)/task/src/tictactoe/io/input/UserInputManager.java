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



}
