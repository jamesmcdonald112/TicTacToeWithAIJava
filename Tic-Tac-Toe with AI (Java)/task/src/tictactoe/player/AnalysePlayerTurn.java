package tictactoe.player;

public class AnalysePlayerTurn {

    /**
     * Takes in the current table and decides who's turn it is based on the amount of symbols
     * placed by each player.
     *
     * @param table   The table to be analysed
     * @return Return the player with the next turn.
     */
    public static Player analysePlayerTurn(char[][] table, Player playerX, Player playerO) {
        int playerXCount = 0;
        int playerOCount = 0;

        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++) {
                if (table[row][col] == playerX.getSymbol()) {
                    playerXCount++;
                } else if (table[row][col] == playerO.getSymbol()) {
                    playerOCount++;
                }
            }
        }

        return (playerXCount <= playerOCount) ? playerX: playerO;
    }
}
