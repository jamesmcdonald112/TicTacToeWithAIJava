package tictactoe.gameSettings;

import tictactoe.io.input.UserInputManager;

public class GameSettings {
    String[] settings;
    private boolean isExitCommand = false;

    public GameSettings() {
        promptForGameSettings();
    }

    public String[] getSettings() {
        return this.settings;
    }

    public boolean isExitCommand() {
        return isExitCommand;
    }

    public void promptForGameSettings() {
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

            try {
                if (ValidateGameSettings.isValidSettings(userInput)) {
                    this.settings = parseSettings(userInput);
                    isValidSettings = true;
                } else {
                    System.out.println("Bad parameters!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Bad parameters!: " + e.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder currentSettings = new StringBuilder("The current setting are: ");
        for(String setting : settings) {
            currentSettings.append(setting).append(" ");
        }
        return currentSettings.toString().trim();
    }

    private static String[] parseSettings(String userInput) {
        return userInput.split(" ");
    }
}
