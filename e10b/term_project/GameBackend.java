import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;

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

    public String getPlayerLastDecision() {
        // Return the last decision made by the player as a String
        // This method assumes you are tracking the player's last decision
        return this.playerLastDecision; // Assuming playerLastDecision is a String variable
    }

    private void endGame() {
        // Logic to conclude the game and determine the winner
        String winner = (playerScore < computerScore) ? "Player 🎉" : "Computer 😭";
        if (playerScore == computerScore) {
            winner = "Tie ⚖️";
        }

        // Create a JDialog to show the result
        JDialog resultDialog = new JDialog();
        resultDialog.setTitle("Game Over");
        resultDialog.setModal(true);
        resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultDialog.setSize(300, 200);
        resultDialog.setLayout(new BorderLayout());

        JLabel resultLabel = new JLabel("Game over! Winner: " + winner, SwingConstants.CENTER);
        resultDialog.add(resultLabel, BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> System.exit(0));
        resultDialog.add(closeButton, BorderLayout.PAGE_END);

        // Center the dialog in the screen
        resultDialog.setLocationRelativeTo(null);

        // Display the dialog
        resultDialog.setVisible(true);
    }

    public void exitGame() {
        System.exit(0);
    }
}
