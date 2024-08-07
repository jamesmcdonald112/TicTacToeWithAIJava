package tictactoe.coordinates;

public class ValidateCoordinates {

    public static boolean isValidSizeCoordinates(String coordinates) {
        // Including the space in the middle
        return coordinates.trim().length() == 3;
    }
}
