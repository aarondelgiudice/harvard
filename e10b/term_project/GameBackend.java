import java.util.Random;

public class GameBackend {
    private int numRounds;
    private int currentSentence;
    private int[][] payoffMatrix;
    private int playerScore;
    private int computerScore;
    private String computerDecision;
    private boolean roundPlayed = false;
    private int totalRounds;
    private String playerLastDecision;

    public GameBackend() {
    }

    public String getComputerDecision() {
        // Logic to determine the computer's decision
        if (computerDecision == null) {
            // For now, decision is random. Replace this with your game's logic.
            computerDecision = (new Random().nextBoolean()) ? "Confess" : "Do not confess";
        }
        return computerDecision;
    }

    private void initializePayoffMatrix() {
        int midSentence = currentSentence / 2;
        int minSentence = midSentence / 2;

        payoffMatrix = new int[][] {
                { minSentence, 0 }, // Player cooperates, Computer cooperates/defects
                { currentSentence, midSentence } // Player defects, Computer cooperates/defects
        };

    }

    public int getMidSentence() {
        // Access the midSentence from the payoff matrix
        return payoffMatrix[1][1]; // Both players defecting
    }

    public int getMinSentence() {
        // Access the minSentence from the payoff matrix
        return payoffMatrix[0][0]; // Both players cooperating
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public void startPrisonersDilemma(int rounds) {
        this.numRounds = rounds;
        this.totalRounds = rounds;
        this.currentSentence = generateSentence(); // Set sentence for the first round
        initializePayoffMatrix(); // Initialize for the first round
        playerScore = 0;
        computerScore = 0;
    }

    public void startStagHunt() {
        // Placeholder for Stag Hunt logic
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void selectStrategy() {
        // Placeholder for strategy selection logic
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void playRound(String playerDecision) {
        roundPlayed = true;

        currentSentence = generateSentence(); // Ensure currentSentence is set for each round
        initializePayoffMatrix(); // Initialize payoff matrix for the current round

        // Update the player's last decision
        this.playerLastDecision = playerDecision;

        int playerChoice = playerDecision.equals("Confess") ? 1 : 0;
        String computerDecision = getComputerDecision();
        int computerChoice = computerDecision.equals("Confess") ? 1 : 0;

        // Update scores
        playerScore += payoffMatrix[playerChoice][computerChoice];
        computerScore += payoffMatrix[computerChoice][playerChoice];

        this.numRounds--;
        this.computerDecision = null;

        if (this.numRounds <= 0) {
            endGame();
        }
    }

    public boolean hasRoundBeenPlayed() {
        return roundPlayed;
    }

    public int getCurrentSentence() {
        if (currentSentence == -1) {
            currentSentence = generateSentence(); // Generate if not already set
        }
        return currentSentence;
    }

    private int generateSentence() {
        return new Random().nextInt(16) + 5; // Random number between 5 and 20
    }

    public int getRemainingRounds() {
        return this.numRounds;
    }

    public int getTotalRounds() {
        return this.totalRounds; // Assuming there is a member variable totalRounds set at the beginning of the
                                 // game
    }

    public boolean getPlayerLastDecision() {
        // Return the last decision made by the player
        // This method assumes you are tracking the player's last decision
        // If player's last decision was "Confess", return true, otherwise return false
        return this.playerLastDecision.equals("Confess");
    }

    private void endGame() {
        // Logic to conclude the game and determine the winner
        String winner = (playerScore < computerScore) ? "Player" : "Computer";
        if (playerScore == computerScore) {
            winner = "Tie";
        }
        System.out.println("Game over! Winner: " + winner);
        exitGame();
    }

    public void exitGame() {
        System.exit(0);
    }
}
