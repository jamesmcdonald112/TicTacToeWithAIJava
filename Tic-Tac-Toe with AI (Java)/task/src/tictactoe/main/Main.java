package tictactoe.main;

import tictactoe.game.TicTacToeGame;

/**
 * Main class to start the Tic-Tac-Toe game.
 */
public class Main {

    /**
     * The entry point of the application.
     * It initiates the game by creating an instance of PlayGame.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // write your code here
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        ticTacToeGame.startGame();
    }
}
