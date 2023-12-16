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
        try {
            backend.selectStrategy();
        } catch (UnsupportedOperationException ex) {
            JOptionPane.showMessageDialog(frame, "Strategy '" + strategy + "' not implemented yet.");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Game();
    }
}
