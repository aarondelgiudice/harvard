import java.util.Random;

public class GameBackend {
    private int numRounds;
    private int currentSentence;
    private int[][] payoffMatrix;

    public GameBackend() {
        // Initialize the payoff matrix here
        initializePayoffMatrix();
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

    public void startPrisonersDilemma(int rounds) {
        this.numRounds = rounds;
        this.currentSentence = generateSentence(); // Generate sentence at game start
        initializePayoffMatrix(); // Reinitialize payoff matrix with the new sentence
        // Additional setup for the game (if needed)
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
        // Convert decisions to 0 or 1
        int playerChoice = playerDecision.equals("Confess") ? 1 : 0;
        int computerChoice = 0;// Determine the computer's choice (0 or 1)

        int playerOutcome = payoffMatrix[playerChoice][computerChoice];

        this.numRounds--; // Update the rounds
        // Handle the end of the game
        if (this.numRounds <= 0) {
            endGame();
        }
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

    private void endGame() {
        // Logic to conclude the game
        exitGame();
    }

    public void exitGame() {
        System.exit(0);
    }
}
