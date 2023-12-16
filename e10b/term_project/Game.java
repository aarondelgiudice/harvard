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
        button.addActionListener(e -> showStrategyOptions(gameName));
        panel.add(button);
    }

    private void showStrategyOptions(String gameName) {
        panel.removeAll();

        JLabel label = new JLabel("Select your opponent's strategy:");
        label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel.add(label);

        String[] strategies = { "Random", "Always Cooperate", "Always Compete", "Tit-for-tat" };
        for (String strategy : strategies) {
            addStrategyButton(strategy, e -> selectStrategy(gameName, strategy));
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
        selectedGame = gameName;
        selectedStrategy = strategy;

        panel.removeAll();

        JLabel label = new JLabel("Enter the number of rounds (default is 10):");
        label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel.add(label);

        JTextField roundInputField = new JTextField(5);
        roundInputField.setMaximumSize(roundInputField.getPreferredSize());
        panel.add(roundInputField);

        JButton startButton = new JButton("Enter");
        startButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        startButton.addActionListener(e -> startGameWithSelectedRounds(strategy, roundInputField.getText()));
        panel.add(startButton);

        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        backButton.addActionListener(e -> showStrategyOptions(gameName));
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
                // Notify about invalid input in the main window
                updateGameConfigPanel("Invalid input. Setting game rounds to 10.");
            }
        } catch (NumberFormatException e) {
            // Notify about invalid input in the main window
            updateGameConfigPanel("Invalid input. Setting game rounds to 10.");
        }

        // Display game configuration in the main window
        updateGameConfigPanel(
                "Playing " + selectedGame + " for " + numRounds + " rounds. Opponent strategy: " + strategy);
    }

    private void updateGameConfigPanel(String message) {
        panel.removeAll();

        JLabel configLabel = new JLabel(message);
        configLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel.add(configLabel);

        // Add a 'Start Game' button
        JButton startGameButton = new JButton("Start Game");
        startGameButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        startGameButton.addActionListener(e -> startGame());
        panel.add(startGameButton);

        // Add a 'Back' button
        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        backButton.addActionListener(e -> showStrategyOptions(selectedGame));
        panel.add(backButton);

        panel.revalidate();
        panel.repaint();
    }

    private void startGame() {
        // Placeholder for starting the game
        // This is where you would add the logic to initialize and start the game based
        // on the selected settings
        JOptionPane.showMessageDialog(frame, "Game started! (Game logic not implemented yet)");
    }

    public static void main(String[] args) {
        new Game();
    }
}
