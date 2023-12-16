import javax.swing.*;
import java.awt.event.ActionListener;

public class Game {

    private GameBackend backend;
    private JFrame frame;
    private JPanel panel;

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

        addGameButton("1. Prisoner's Dilemma", e -> showStrategyOptions());
        addGameButton("2. Stag Hunt", e -> showStrategyOptions());

        JButton exitButton = new JButton("3. No (exit)");
        exitButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        exitButton.addActionListener(e -> backend.exitGame());
        panel.add(exitButton);

        panel.revalidate();
        panel.repaint();
    }

    private void addGameButton(String buttonText, ActionListener action) {
        JButton button = new JButton(buttonText);
        button.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        button.addActionListener(action);
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
        if (strategy.equals("Random")) {
            showRoundSelection(strategy);
        } else {
            try {
                backend.selectStrategy();
            } catch (UnsupportedOperationException ex) {
                JOptionPane.showMessageDialog(frame, "Strategy '" + strategy + "' not implemented yet.");
                System.exit(0);
            }
        }
    }

    private void showRoundSelection(String strategy) {
        panel.removeAll();

        JLabel label = new JLabel("Enter the number of rounds (default is 10):");
        label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel.add(label);

        JTextField roundInputField = new JTextField(5);
        roundInputField.setMaximumSize(roundInputField.getPreferredSize());
        panel.add(roundInputField);

        JButton startButton = new JButton("Start Game");
        startButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        startButton.addActionListener(e -> startGameWithSelectedRounds(strategy, roundInputField.getText()));
        panel.add(startButton);

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
                JOptionPane.showMessageDialog(frame, "'" + roundsInput
                        + "' is not a valid input, expected a positive integer value. Setting game rounds to 10.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame,
                    "Invalid input, expected a positive integer value. Setting game rounds to 10.");
        }
        JOptionPane.showMessageDialog(frame, "Playing for " + numRounds + " rounds. Opponent strategy: " + strategy);
        // Here you will eventually start the game with the specified number of rounds
        // and strategy
    }

    public static void main(String[] args) {
        new Game();
    }
}
