import javax.swing.*;
import java.awt.event.ActionListener;

public class Game {

    private GameBackend backend;
    private JFrame frame;
    private JPanel panel;
    private String selectedGame;
    private String selectedStrategy;
    private JTextArea premiseText;
    private JLabel roundsLabel;
    private JLabel scoreLabel;
    private JTextArea roundOutcomeText;

    public Game() {
        backend = new GameBackend();
        setUpGUI();
    }

    private void setUpGUI() {
        frame = new JFrame("Game Theory Simulations");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.add(panel);

        addGameOptions();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void addGameOptions() {
        panel.removeAll();

        JLabel label = new JLabel("Would you like to play a game?");
        label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel.add(label);

        addGameButton("1. Prisoner's Dilemma", "Prisoner's Dilemma");
        addGameButton("2. Stag Hunt", "Stag Hunt");

        JButton exitButton = new JButton("3. No (exit)");
        exitButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        exitButton.addActionListener(e -> backend.exitGame());
        panel.add(exitButton);

        panel.revalidate();
        panel.repaint();
    }

    private void addGameButton(String buttonText, String gameName) {
        JButton button = new JButton(buttonText);
        button.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        button.addActionListener(e -> {
            selectedGame = gameName;
            showStrategyOptions();
        });
        panel.add(button);
    }

    private void showStrategyOptions() {
        panel.removeAll();

        JLabel label = new JLabel("Select your opponent's strategy:");
        label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel.add(label);

        String[] strategies = { "Random", "Always Cooperate", "Always Compete", "Tit-for-tat" };
        for (String strategy : strategies) {
            addStrategyButton(strategy, e -> selectStrategy(strategy));
        }

        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        backButton.addActionListener(e -> addGameOptions());
        panel.add(backButton);

        panel.revalidate();
        panel.repaint();
    }

    private void addStrategyButton(String strategy, ActionListener action) {
        JButton button = new JButton(strategy);
        button.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        button.addActionListener(action);
        panel.add(button);
    }

    private void selectStrategy(String strategy) {
        selectedStrategy = strategy;
        showRoundSelection();
    }

    private void showRoundSelection() {
        panel.removeAll();

        JLabel label = new JLabel("Enter the number of rounds (default is 10):");
        label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel.add(label);

        JTextField roundInputField = new JTextField(5);
        roundInputField.setMaximumSize(roundInputField.getPreferredSize());
        panel.add(roundInputField);

        ActionListener roundInputListener = e -> startGameWithSelectedRounds(roundInputField.getText());
        roundInputField.addActionListener(roundInputListener);

        JButton enterButton = new JButton("Enter");
        enterButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        enterButton.addActionListener(roundInputListener);
        panel.add(enterButton);

        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        backButton.addActionListener(e -> showStrategyOptions());
        panel.add(backButton);

        panel.revalidate();
        panel.repaint();
    }

    private void startGameWithSelectedRounds(String roundsInput) {
        int numRounds = 10; // Default value
        try {
            int inputVal = Integer.parseInt(roundsInput);
            numRounds = Math.max(inputVal, 1); // Ensure at least 1 round
        } catch (NumberFormatException ignored) {
            // Default to 10 rounds if input is invalid
        }

        backend.startPrisonersDilemma(numRounds); // Start the game
        showGameScreen(numRounds);
    }

    private void showGameScreen(int numRounds) {
        // Clear the panel before adding new components only if it's the first time
        if (!backend.hasRoundBeenPlayed()) {
            panel.removeAll();
        }

        // Initialize the roundOutcomeText if it's null
        if (roundOutcomeText == null) {
            roundOutcomeText = new JTextArea();
            roundOutcomeText.setWrapStyleWord(true);
            roundOutcomeText.setLineWrap(true);
            roundOutcomeText.setOpaque(false);
            roundOutcomeText.setEditable(false);
            roundOutcomeText.setFocusable(false);
            roundOutcomeText.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            panel.add(roundOutcomeText);
        }

        // Only update the round outcome text if a round has been played
        if (backend.hasRoundBeenPlayed()) {
            String computerDecision = backend.getComputerDecision();
            roundOutcomeText.setText(
                    "Round outcome:\n" +
                            "Your choice: " + backend.getPlayerLastDecision() + "\n" +
                            "Opponent's choice: " + computerDecision + "\n" +
                            "Your Score: " + backend.getPlayerScore() + " | Computer Score: "
                            + backend.getComputerScore());
        } else {
            // If no rounds have been played yet, we can set this text to empty or to a
            // welcome message
            roundOutcomeText.setText("");
        }

        if (premiseText == null) {
            premiseText = new JTextArea();
            premiseText.setWrapStyleWord(true);
            premiseText.setLineWrap(true);
            premiseText.setOpaque(false);
            premiseText.setEditable(false);
            premiseText.setFocusable(false);
            premiseText.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            panel.add(premiseText);
        }

        if (roundsLabel == null) {
            roundsLabel = new JLabel();
            roundsLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            panel.add(roundsLabel);
        }

        if (scoreLabel == null) {
            scoreLabel = new JLabel();
            scoreLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            panel.add(scoreLabel);
        }

        // Update the text of the premiseText, roundsLabel, and scoreLabel instead of
        // creating new ones
        int sentence = backend.getCurrentSentence();
        int midSentence = backend.getMidSentence();
        int minSentence = backend.getMinSentence();
        premiseText.setText(
                "Welcome to the Prisoner's Dilemma.\n" +
                        "In this round, your sentence is: " + sentence + " years.\n" +
                        "Will you confess or not?\n" +
                        "If you confess, but your opponent does not, you will receive the maximum sentence of "
                        + sentence + " years, and your opponent will go free.\n" +
                        "If you do not confess, but your opponent does, you will receive no sentence and be let go, but your opponent will receive the maximum sentence of "
                        + sentence + " years.\n" +
                        "If you both confess, you will both receive a moderate sentence of " + midSentence + " years.\n"
                        +
                        "If neither of you confess, you will both receive the minimum sentence of " + minSentence
                        + " years.\n" +
                        "(Remember, Your opponent's strategy is: " + selectedStrategy + ".)");

        roundsLabel.setText("Rounds remaining: " + numRounds);
        scoreLabel.setText(
                "Your Score: " + backend.getPlayerScore() + " | Computer Score: " + backend.getComputerScore());

        // Add decision buttons only if it's the first time
        if (!backend.hasRoundBeenPlayed()) {
            addDecisionButton("1. Confess", roundsLabel);
            addDecisionButton("2. Do not confess", roundsLabel);
        }

        panel.revalidate();
        panel.repaint();
    }

    private void addDecisionButton(String decisionText, JLabel roundsLabel) {
        JButton decisionButton = new JButton(decisionText);
        decisionButton.addActionListener(e -> {
            backend.playRound(decisionText); // Player's decision is sent to backend
            updateRound(decisionText, roundsLabel); // Update the UI based on the new game state
        });

        // Only add the button if it's the first round
        if (!backend.hasRoundBeenPlayed()) {
            panel.add(decisionButton);
        }
    }

    private void updateRound(String playerDecision, JLabel roundsLabel) {
        int currentRounds = backend.getRemainingRounds();
        String computerDecision = backend.getComputerDecision(); // Method to get computer's last decision
        int playerScore = backend.getPlayerScore();
        int computerScore = backend.getComputerScore();

        // Convert the boolean decision to a String
        String playerDecisionText = playerDecision.equals("1. Confess") ? "Confess" : "Do not confess";

        // Update the UI with the round's outcome
        if (roundOutcomeText != null) {
            roundOutcomeText.setText(
                    "Round outcome:\n" +
                            "Your choice: " + backend.getPlayerLastDecision() + "\n" + // Directly use the String
                            "Opponent's choice: " + computerDecision + "\n" +
                            "Your Score: " + playerScore + " | Computer Score: " + computerScore);

        }

        // Update the rounds remaining and score labels
        roundsLabel.setText("Rounds remaining: " + currentRounds);
        scoreLabel.setText("Your Score: " + playerScore + " | Computer Score: " + computerScore);

        // Revalidate and repaint the panel to show the updates
        panel.revalidate();
        panel.repaint();

        // Determine next steps based on game state
        if (currentRounds <= 0) {
            endGame();
        } else {
            prepareForNextRound(currentRounds); // Pass current rounds to prepare UI for next round
        }
    }

    private void prepareForNextRound(int currentRounds) {
        // Remove decision buttons or any other round-specific components
        // For example:
        // panel.remove(decisionButton1);
        // panel.remove(decisionButton2);

        // Add new decision buttons for the next round
        // addDecisionButton("1. Confess", roundsLabel);
        // addDecisionButton("2. Do not confess", roundsLabel);

        // Call showGameScreen to refresh the UI for the next round
        showGameScreen(currentRounds);
    }

    private void endGame() {
        // Show game over message or any other finalization logic
        JOptionPane.showMessageDialog(frame, "Game over! Final scores - Player: " + backend.getPlayerScore()
                + ", Computer: " + backend.getComputerScore());
    }

    public static void main(String[] args) {
        new Game();
    }
}
