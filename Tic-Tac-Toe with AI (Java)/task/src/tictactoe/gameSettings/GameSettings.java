package tictactoe.gameSettings;

import tictactoe.io.input.UserInputManager;

public class GameSettings {
    String[] settings;

    public GameSettings() {
        this.settings = promptForGameSettings();
    }

    public static String[] promptForGameSettings() {
        boolean isValidSettings = false;
        String[] settings = null;

        while (!isValidSettings) {
            System.out.println("Input command: ");
            String userInput = UserInputManager.getUserInputString();
            try {
                settings = parseSettings(userInput);
                isValidSettings = true; // If no exception is thrown, the settings are valid
            } catch (IllegalArgumentException e) {
                System.out.println("Bad parameters!");
            }
        }
        return settings;
    }

    private static String[] parseSettings(String userInput) {
        return null;

    }



    public static void main(String[] args) {
        GameSettings gameSettings = new GameSettings();
    }


    /*
    Null or empty check
    Enum for commands
    Enum for player type

     */

}
