import java.util.Random;

public class GameBackend {
    private String currentGameType;
    private int numRounds;
    private int playerScore;
    private int computerScore;
    private String opponentStrategy;
    private int[][] payoffMatrix;
    private String playerLastDecision = null;
    private String computerLastDecision;

    // public GameBackend() {
    // // Initialize the game
    // }

    public void setGameType(String gameType) {
        // Set the current game type
        this.currentGameType = gameType;
        initializeGameEnvironment();
        initializePayoffMatrix(gameType);
    }

    private void initializeGameEnvironment() {
        // Initialize the game environment
        playerScore = 0;
        computerScore = 0;
        initializePayoffMatrix(currentGameType);
    }

    public void startGame(String gameType, int rounds) {
        // Start the game
        setGameType(gameType); // Set the game type
        validateAndSetRounds(rounds); // Set the number of rounds
    }

    private void validateAndSetRounds(int rounds) {
        // Validate and set the number of rounds
        this.numRounds = (rounds > 0) ? rounds : 10;
    }

    public void setStrategy(String strategy) {
        // Set the opponent's strategy
        this.opponentStrategy = strategy;
    }

    public void playRound(String playerDecision) {
        // Play a round of the game
        if ("Prisoner's Dilemma".equals(currentGameType)) {
            // Logic for a round of Prisoner's Dilemma
            computerLastDecision = determineComputerDecision();
            updateScoresBasedOnDecision(playerDecision, computerLastDecision);
        } else if ("Stag Hunt".equals(currentGameType)) {
            // Logic for a round of Stag Hunt
            computerLastDecision = determineComputerDecision();
            updateScoresBasedOnDecision(playerDecision, computerLastDecision);
        }
        numRounds--; // Decrement the number of rounds

        // Update the player's last decision
        this.playerLastDecision = playerDecision;
    }

    private String determineComputerDecision() {
        // Logic to determine the computer's decision
        switch (opponentStrategy) {
            case "Random":
                return new Random().nextBoolean() ? "Cooperate" : "Compete";
            case "Always Cooperate":
                return "Cooperate";
            case "Always Compete":
                return "Compete";
            case "Tit-for-tat":
                // If it's the first round, choose randomly. Otherwise, mimic the player's last
                // decision
                if (playerLastDecision == null) {
                    return new Random().nextBoolean() ? "Cooperate" : "Compete";
                } else {
                    return playerLastDecision;
                }
            default:
                // Default strategy is random
                return new Random().nextBoolean() ? "Cooperate" : "Compete";
        }
    }

    private void updateScoresBasedOnDecision(String playerDecision, String computerDecision) {
        //
        int playerIndex = playerDecision.equals("Cooperate") ? 0 : 1;
        int computerIndex = computerDecision.equals("Cooperate") ? 0 : 1;

        playerScore += payoffMatrix[playerIndex][computerIndex];
        computerScore += payoffMatrix[computerIndex][playerIndex];
    }

    private void initializePayoffMatrix(String gameName) {
        //
        if ("Prisoner's Dilemma".equals(gameName)) {
            // Initialize the payoff matrix for Prisoner's Dilemma
            payoffMatrix = new int[][] {
                    { 3, 0 }, // Both cooperate
                    { 5, 1 } // One competes, the other cooperates or both compete
            };
        } else if ("Stag Hunt".equals(gameName)) {
            // Initialize the payoff matrix for Stag Hunt
            payoffMatrix = new int[][] {
                    { 5, 0 }, // Both cooperate (hunt stag)
                    { 0, 3 } // One competes (hunts rabbit), the other cooperates (hunts stag) or both
                             // compete (hunt rabbits)
            };
        }
    }

    // Getters and Setters for game state
    public int getPlayerScore() {
        // Return the player's score
        return playerScore;
    }

    public int getComputerScore() {
        // Return the computer's score
        return computerScore;
    }

    public int getRemainingRounds() {
        // Return the number of remaining rounds
        return numRounds;
    }

    public int[][] getPayoffMatrix() {
        // Return the payoff matrix
        return payoffMatrix;
    }

    public String getPlayerLastDecision() {
        // Return the player's last decision
        return playerLastDecision;
    }

    public String getComputerLastDecision() {
        // Return the computer's last decision
        return computerLastDecision;
    }

    public String concludeGame() {
        // Conclude the game
        String outcome;
        if ("Prisoner's Dilemma".equals(currentGameType)) {
            // In Prisoner's Dilemma, the player with the shortest sentence wins.
            if (playerScore < computerScore) {
                outcome = "🎉 You win! Your sentence is shorter than your opponent's. 🎉";
            } else if (playerScore > computerScore) {
                outcome = "😭 You lose! Your sentence is longer than your opponent's. 😭";
            } else {
                outcome = "⚖️ It's a tie! You both get the same sentence. ⚖️";
            }
        } else if ("Stag Hunt".equals(currentGameType)) {
            // In Stag Hunt, the player with the most points wins.
            if (playerScore > computerScore) {
                outcome = "🎉 You win! You have more points than your opponent. 🎉";
            } else if (playerScore < computerScore) {
                outcome = "😭 You lose! You have fewer points than your opponent. 😭";
            } else {
                outcome = "⚖️ It's a tie! You both have the same points. ⚖️";
            }
        } else {
            outcome = "Game over! No winner determined.";
        }
        return outcome;

    }

    // public void setupStagHunt() {
    // }
}
