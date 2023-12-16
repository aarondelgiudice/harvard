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

        // frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void addGameOptions() {
        panel.removeAll();

        JLabel label = new JLabel("Would you like to play a game?");
        label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel.add(label);

        // Pass the game name to the method that will be called on button click
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
        // Update the action listener to directly call showStrategyOptions with the
        // gameName
        button.addActionListener(e -> {
            selectedGame = gameName; // Set the selected game
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
            addStrategyButton(strategy, e -> selectStrategy(selectedGame, strategy));
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

    private void selectStrategy(String gameName, String strategy) {
        if (strategy.equals("Random")) {
            showRoundSelection(gameName, strategy);

        } else {
            try {
                backend.selectStrategy();
            } catch (UnsupportedOperationException ex) {
                JOptionPane.showMessageDialog(frame, "Strategy '" + strategy + "' not implemented yet.");
                System.exit(0);
            }
        }
    }

    private void showRoundSelection(String gameName, String strategy) {
        panel.removeAll();

        JLabel label = new JLabel("Enter the number of rounds (default is 10):");
        label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel.add(label);

        JTextField roundInputField = new JTextField(5);
        roundInputField.setMaximumSize(roundInputField.getPreferredSize());
        panel.add(roundInputField);

        // ActionListener for processing round input
        ActionListener roundInputListener = e -> startGameWithSelectedRounds(strategy,
                roundInputField.getText());

        // Set the ActionListener for the text field to accept input on pressing Return
        // key
        roundInputField.addActionListener(roundInputListener);

        // 'Enter' button now uses the same ActionListener
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

    private void startGameWithSelectedRounds(String strategy, String roundsInput) {
        int numRounds = 10; // default value
        try {
            int inputVal = Integer.parseInt(roundsInput);
            if (inputVal > 0) {
                numRounds = inputVal;
            } else {
                // Notify about invalid input and set the default number of rounds
                updateGameConfigPanel("Invalid input. Setting game rounds to 10.", numRounds, strategy);
            }
        } catch (NumberFormatException e) {
            // Notify about invalid input and set the default number of rounds
            updateGameConfigPanel("Invalid input. Setting game rounds to 10.", numRounds, strategy);
        }

        // Display game configuration and start the game with the selected settings
        updateGameConfigPanel(
                "Playing " + selectedGame + " for " + numRounds + " rounds. Opponent strategy: " + strategy, numRounds,
                strategy);

        startGame(numRounds, strategy);
    }

    private void showGameScreen(String gameName, int numRounds, String strategy) {
        panel.removeAll();

        // Display the game premise
        JTextArea premiseText = new JTextArea("Game premise placeholder text.");
        premiseText.setWrapStyleWord(true);
        premiseText.setLineWrap(true);
        premiseText.setOpaque(false);
        premiseText.setEditable(false);
        premiseText.setFocusable(false);
        premiseText.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel.add(premiseText);

        // Display the rounds remaining
        JLabel roundsLabel = new JLabel("Rounds remaining: " + numRounds);
        roundsLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel.add(roundsLabel);

        // Add buttons for player's decisions (e.g., "Confess" and "Don't Confess")
        // Add ActionListener to these buttons to call backend.playRound with the
        // decision
        // Update the roundsLabel after each decision

        panel.revalidate();
        panel.repaint();
    }

    private void updateGameConfigPanel(String message, int numRounds, String strategy) {
        panel.removeAll();

        JLabel configLabel = new JLabel(message);
        configLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel.add(configLabel);

        // Add a 'Start Game' button
        JButton startGameButton = new JButton("Start Game");
        startGameButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        startGameButton.addActionListener(e -> startGame(numRounds, strategy)); // Updated to pass correct arguments
        panel.add(startGameButton);

        // Add a 'Back' button
        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        backButton.addActionListener(e -> showStrategyOptions());
        panel.add(backButton);

        panel.revalidate();
        panel.repaint();
    }

    private void startGame(int numRounds, String strategy) {
        // Start the game with the specified number of rounds
        try {
            if (selectedGame.equals("Prisoner's Dilemma")) {
                backend.startPrisonersDilemma(numRounds);
            } else if (selectedGame.equals("Stag Hunt")) {
                backend.startStagHunt();
            }
        } catch (UnsupportedOperationException e) {
            JOptionPane.showMessageDialog(frame, "Game '" + selectedGame + "' not implemented yet.");
            System.exit(0);
        }

        // Show the game screen
        showGameScreen(selectedGame, numRounds, strategy);
    }

    public static void main(String[] args) {
        new Game();
    }
}
