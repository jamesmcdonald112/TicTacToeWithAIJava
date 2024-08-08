package tictactoe.player;

import tictactoe.game.PlayGame;

public enum Player {
    PLAYER_X('X'),
    PLAYER_O('O');
    private final char symbol;

    Player(char symbol) {
        this.symbol = symbol;
    }

   public char getSymbol() {
        return this.symbol;
   }
}
