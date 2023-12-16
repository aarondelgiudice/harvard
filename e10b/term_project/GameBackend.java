import java.util.Random;

public class GameBackend {
    private int numRounds;
    private int currentSentence;

    public void startPrisonersDilemma(int rounds) {
        this.numRounds = rounds;
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
        // Game logic based on the player's decision
        // Update the game state

        this.numRounds--; // Update the rounds
        // Handle the end of the game
        if (this.numRounds <= 0) {
            endGame();
        }
    }

    public int getCurrentSentence() {
        // Logic to generate a random sentence
        if (this.numRounds == 10) { // For example, generate new sentence only at the start
            this.currentSentence = new Random().nextInt(16) + 5; // Random number between 5 and 20
        }
        return this.currentSentence;
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
