package tictactoe.gameSettings;

import tictactoe.player.PlayerType;

public class ValidateGameSettings {

    /**
     * Validates the settings by making sure they are not null or empty, and that the setting are
     * valid.
     *
     * @param userInput The input to be validated.
     * @return True if they are valid, false otherwise;
     */
    public static boolean isValidSettings(String userInput) {
        // Check if the input is null or empty
        if (isNullOrEmpty(userInput)) {
            System.out.println("Input cannot be null or empty");
            return false;
        }

        String[] parts = userInput.trim().split(" ");

        // Check if the user has entered the exit command
        if (isExitCommand(parts)) {
            return true;
        }

        // Check if the commands are valid or starting the game.
        if (isValidStartCommand(parts)) {
            return true;
        }

        // Return false otherwise.
        return false;
    }

    /**
     * Checks if the user input is null or empty
     *
     * @param userInput The input to be checked.
     * @return True if the input is null or empty; flase otherwise.
     */
    private static boolean isNullOrEmpty(String userInput) {
        return userInput == null || userInput.trim().isEmpty();
    }

    /**
     * Validates that the exit command is entered correctly.
     *
     * @param parts The user input for the settings seperated into String parts.
     * @return True if the exit input is valid; false otherwise.
     */
    private static boolean isExitCommand(String[] parts) {
        return parts.length == 1 && parts[0].equalsIgnoreCase(Command.EXIT.name());
    }

    /**
     * Checks if the command is a valid start command.
     *
     * @param parts The input the user entered for the settings.
     * @return True if it is a valid start input; false otherwise.
     * @return
     */
    private static boolean isValidStartCommand(String[] parts) {
        return parts.length == 3
                && parts[0].equalsIgnoreCase(Command.START.name())
                && isValidPlayerType(parts[1])
                && isValidPlayerType(parts[2]);
    }

    /**
     * Checks if the player type is a valid player type.
     *
     * @param playerType The input the user selected as a player type to be validated.
     * @return True if it is a valid player type; false otherwise.
     */
    private static boolean isValidPlayerType(String playerType) {
        return playerType.equalsIgnoreCase(PlayerType.EASY.name())
                || playerType.equalsIgnoreCase(PlayerType.USER.name());
    }


}
