import javax.swing.*;
import java.awt.event.ActionListener;

public class Game {

    private GameBackend backend;
    private JFrame frame;
    private JPanel panel;
    private String selectedGame;
    private String selectedStrategy;

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
        panel.removeAll();

        JTextArea premiseText = new JTextArea("Game premise placeholder text.");
        // Configure premiseText...
        panel.add(premiseText);

        int sentence = backend.getCurrentSentence();
        JLabel sentenceLabel = new JLabel("Sentence for this round: " + sentence + " years");
        panel.add(sentenceLabel);

        JLabel roundsLabel = new JLabel("Rounds remaining: " + numRounds);
        panel.add(roundsLabel);

        addDecisionButton("1. Confess", roundsLabel);
        addDecisionButton("2. Do not confess", roundsLabel);

        panel.revalidate();
        panel.repaint();
    }

    private void addDecisionButton(String decisionText, JLabel roundsLabel) {
        JButton decisionButton = new JButton(decisionText);
        decisionButton.addActionListener(e -> {
            backend.playRound(decisionText);
            updateRound(roundsLabel);
        });
        panel.add(decisionButton);
    }

    private void updateRound(JLabel roundsLabel) {
        int currentRounds = backend.getRemainingRounds();
        roundsLabel.setText("Rounds remaining: " + currentRounds);

        if (currentRounds <= 0) {
            endGame();
        }
    }

    private void endGame() {
        // Placeholder for ending the game logic
        JOptionPane.showMessageDialog(frame, "Game over!");
    }

    public static void main(String[] args) {
        new Game();
    }
}
