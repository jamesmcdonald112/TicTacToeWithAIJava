package tictactoe.gameSettings;

import tictactoe.io.input.UserInputManager;

/**
 * This class is responsible for prompting the user for game settings and validating them.
 * It allows the user to either start a game or exit the application.
 */
public class GameSettings {

    // INSTANCE VARIABLES
    private String[] settings;
    private boolean isExitCommand = false;

    // CONSTRUCTOR

    /**
     * Constructor that initialises and prompts for game settings.
     */
    public GameSettings() {
        initialiseGameSettings();
    }

    // GETTERS AND SETTERS

    /**
     * Returns the game settings that were provided by the user
     *
     * @return String Array of settings
     */
    public String[] getSettings() {
        return this.settings;
    }

    /**
     * Returns whether the user chose to exit the game.
     *
     * @return true if the user chose to exit; false otherwise.
     */
    public boolean isExitCommand() {
        return isExitCommand;
    }

    /**
     * Prompts the user to enter the game settings and validates the input.
     * If the user inputs "exit", the game will exit.
     * If the input is invalid, the user is prompted again until valid settings are provided.
     */
    public void initialiseGameSettings() {
        boolean isValidSettings = false;

        while (!isValidSettings) {
            System.out.println("Input command: ");
            String userInput = UserInputManager.getUserInputString();

            // Check if the user entered the exit command
            if (userInput.equalsIgnoreCase("exit")) {
                isExitCommand = true;
                settings = new String[0];
                return;
            }

            // Validate and parse the settings
            if (ValidateGameSettings.isValidSettings(userInput)) {
                this.settings = parseSettings(userInput);
                isValidSettings = true;
            } else {
                System.out.println("Bad parameters!");
            }

        }
    }

    /**
     * Provides a string representation of the current game settings.
     *
     * @return A formatted string representing the game settings.
     */
    @Override
    public String toString() {
        StringBuilder currentSettings = new StringBuilder("The current setting are: ");
        for (String setting : settings) {
            currentSettings.append(setting).append(" ");
        }
        return currentSettings.toString().trim();
    }

    /**
     * Parses the user's input and splits it into game settings
     *
     * @param userInput The user's input
     * @return A String array of parsed game settings
     */
    private static String[] parseSettings(String userInput) {
        return userInput.split(" ");
    }
}
