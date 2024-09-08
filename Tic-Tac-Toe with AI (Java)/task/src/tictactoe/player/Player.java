package tictactoe.player;

public class Player {

    private char symbol; // 'X' or 'O'
    private PlayerType playerType; // USER or COMPUTER
    private DifficultyLevel difficultyLevel; // Can be null for USER

    // Constructor for human players
    public Player(char symbol, PlayerType playerType) {
        this.symbol = symbol;
        this.playerType = playerType;
        this.difficultyLevel = null;
    }

    // Constructor for AI players
    public Player(char symbol, DifficultyLevel difficultyLevel) {
        this.symbol = symbol;
        this.playerType = PlayerType.COMPUTER; // Computer player type
        this.difficultyLevel = difficultyLevel; // Set difficulty level
    }

    public char getSymbol() {
        return symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public boolean isHuman() {
        return playerType == PlayerType.USER;
    }

    public boolean isComputer() {
        return playerType == PlayerType.COMPUTER;
    }
}