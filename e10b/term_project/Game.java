import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    private GameBackend backend;

    public Game() {
        backend = new GameBackend();
        setUpGUI();
    }

    private void setUpGUI() {
        JFrame frame = new JFrame("Game Theory Simulations");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        // Set the panel's layout to BoxLayout, aligning components along the Y-axis
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.add(panel);

        JLabel label = new JLabel("Would you like to play a game?");
        label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel.add(label);

        JButton pdButton = new JButton("1. Prisoner's Dilemma");
        pdButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        pdButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    backend.startPrisonersDilemma();
                } catch (UnsupportedOperationException ex) {
                    JOptionPane.showMessageDialog(frame, "Feature not implemented yet.");
                    System.exit(0);
                }
            }
        });
        panel.add(pdButton);

        JButton shButton = new JButton("2. Stag Hunt");
        shButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        shButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    backend.startStagHunt();
                } catch (UnsupportedOperationException ex) {
                    JOptionPane.showMessageDialog(frame, "Feature not implemented yet.");
                    System.exit(0);
                }
            }
        });
        panel.add(shButton);

        JButton exitButton = new JButton("3. No (exit)");
        exitButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backend.exitGame();
            }
        });
        panel.add(exitButton);

        frame.pack(); // Adjusts the window size to fit the components
        frame.setLocationRelativeTo(null); // Centers the window on the screen
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Game();
    }
}
