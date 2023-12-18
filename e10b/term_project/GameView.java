import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Color;

public class GameView {
    private JFrame frame;
    private JPanel panel;
    private JButton btnPrisonersDilemma;
    private JButton btnStagHunt;
    private Game controller;
    private JButton btnRandomStrategy;
    private JButton btnAlwaysCooperate;
    private JButton btnAlwaysCompete;
    private JButton btnTitForTat;
    private JLabel strategyLabel;
    private JTextField roundsInputField;
    private JLabel payoffMatrixLabel;
    private JLabel roundsRemainingLabel;
    private JLabel playerScoreLabel;
    private JLabel computerScoreLabel;
    private String selectedGameType;
    private JTextArea premiseTextArea;

    public GameView(Game controller) {
        this.controller = controller;
        setUpGUI();
        initializeComponents();
    }

    private void setUpGUI() {
        // Setting up the main frame and other general GUI components
        frame = new JFrame("Game Theory Simulations");
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.add(panel);
    }

    public void displayGameSelectionOptions() {
        // Clear existing components
        JLabel welcomeLabel = new JLabel("Would you like to play a game?");
        welcomeLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel.add(welcomeLabel);

        // Create and add game selection buttons
        btnPrisonersDilemma = new JButton("Prisoner's Dilemma");
        btnStagHunt = new JButton("Stag Hunt");

        // Register action listeners for game selection buttons
        btnPrisonersDilemma.addActionListener(e -> {
            selectedGameType = "Prisoner's Dilemma";
            controller.selectGame(selectedGameType);
        });
        btnStagHunt.addActionListener(e -> {
            selectedGameType = "Stag Hunt";
            controller.selectGame(selectedGameType);
        });

        panel.add(btnPrisonersDilemma);
        panel.add(btnStagHunt);

        // Add an exit button
        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(e -> controller.exitGame()); // Register action listener
        panel.add(btnExit);

        frame.pack();
        frame.setVisible(true);
    }

    public String getSelectedGameType() {
        // This method returns the selected game type.
        return selectedGameType;
    }

    public void displayStrategyOptions() {
        // Clear existing components
        panel.removeAll();

        // Create and add a label
        btnRandomStrategy = new JButton("Random");
        btnAlwaysCooperate = new JButton("Always Cooperate");
        btnAlwaysCompete = new JButton("Always Compete");
        btnTitForTat = new JButton("Tit-for-tat");

        // Create a common ActionListener for strategy buttons
        ActionListener strategyListener = e -> {
            String strategy = ((JButton) e.getSource()).getText(); // Get the text of the clicked button
            controller.selectStrategy(strategy); // Notify the controller about the selected strategy
            displayRoundInputOptions(); // Transition to round input
        };

        //
        btnRandomStrategy.addActionListener(strategyListener);
        btnAlwaysCooperate.addActionListener(strategyListener);
        btnAlwaysCompete.addActionListener(strategyListener);
        btnTitForTat.addActionListener(strategyListener);

        panel.add(btnRandomStrategy);
        panel.add(btnAlwaysCooperate);
        panel.add(btnAlwaysCompete);
        panel.add(btnTitForTat);

        frame.pack();
        frame.setVisible(true);
    }

    public String getSelectedStrategy() {
        // Return the selected strategy
        return "Always Cooperate";
    }

    public void updateViewForStrategy(String strategy) {
        // Update the view based on the selected strategy
        if (strategyLabel == null) {
            strategyLabel = new JLabel();
            panel.add(strategyLabel);
        }
        strategyLabel.setText("Selected Strategy: " + strategy);
        frame.pack();
    }

    public void displayRoundInputOptions() {
        // Clear existing components
        panel.removeAll();

        // Create and add a label
        JLabel roundsLabel = new JLabel("Enter the number of rounds (default is 10):");
        roundsInputField = new JTextField(5);
        JButton enterButton = new JButton("Start Game");
        enterButton.addActionListener(e -> controller.startGame());

        panel.add(roundsLabel);
        panel.add(roundsInputField);
        panel.add(enterButton);

        frame.pack();
        frame.setVisible(true);
    }

    public int getNumberOfRounds() {
        // Return the number of rounds
        try {
            int rounds = Integer.parseInt(roundsInputField.getText());
            return rounds > 0 ? rounds : -1;
        } catch (NumberFormatException e) {
            showError("Invalid input. Defaulting to 10 rounds.");
            return -1;
        }
    }

    private void initializeComponents() {
        // Initialize components for the game screen
        payoffMatrixLabel = new JLabel();
        roundsRemainingLabel = new JLabel();
        playerScoreLabel = new JLabel();
        computerScoreLabel = new JLabel();
        strategyLabel = new JLabel();

        // Add components to the panel
        panel.add(payoffMatrixLabel);
        panel.add(roundsRemainingLabel);
        panel.add(playerScoreLabel);
        panel.add(computerScoreLabel);
        panel.add(strategyLabel);

        premiseTextArea = new JTextArea(4, 20);
        // premiseTextArea.setWrapStyleWord(true);
        // premiseTextArea.setLineWrap(true);
        premiseTextArea.setEditable(false);
        premiseTextArea.setOpaque(false);
        premiseTextArea.setFocusable(false);
        // premiseTextArea.setMaximumSize(new Dimension(300, 100));
        // premiseTextArea.setPreferredSize(new Dimension(300, 100));

        JScrollPane premiseScrollPane = new JScrollPane(premiseTextArea);
        // premiseScrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        premiseScrollPane.setOpaque(false);
        premiseScrollPane.getViewport().setOpaque(false);

        premiseScrollPane.setPreferredSize(new Dimension(300, 100));

        panel.add(premiseScrollPane);
    }

    public void setPremiseText(String text) {
        // Set the premise text
        premiseTextArea.setText(text);
    }

    public void updatePremiseText(String gameType, int[][] payoffMatrix) {
        // Update the premise text based on the selected game type
        StringBuilder premiseBuilder = new StringBuilder();
        if ("Prisoner's Dilemma".equals(gameType)) {
            premiseBuilder.append("In the Prisoner's Dilemma, two suspects are interrogated separately. If both\n");
            premiseBuilder.append("cooperate (stay silent), they each get a small sentence. If one defects\n");
            premiseBuilder
                    .append("and the other cooperates, the defector goes free while the cooperator gets a long\n");
            premiseBuilder.append("sentence. If both defect, they both get a moderate sentence.\n\n");
            // Add the specific payoff matrix explanation for Prisoner's Dilemma
            premiseBuilder.append("Payoff Matrix:\nCooperate/Cooperate: ").append(payoffMatrix[0][0])
                    .append(" years each.\n");
            premiseBuilder.append("Defect/Cooperate: Defector: 0 years, Cooperator: ").append(payoffMatrix[1][0])
                    .append(" years.\n");
            premiseBuilder.append("Cooperate/Defect: Cooperator: 0 years, Defector: ").append(payoffMatrix[0][1])
                    .append(" years.\n");
            premiseBuilder.append("Defect/Defect: ").append(payoffMatrix[1][1]).append(" years each.\n");
        } else if ("Stag Hunt".equals(gameType)) {
            premiseBuilder.append("In the Stag Hunt, two hunters must decide independently whether to hunt a stag\n");
            premiseBuilder.append("together or hunt rabbits alone. Hunting stags yields a large payoff but requires\n");
            premiseBuilder.append("cooperation. Hunting rabbits yields a payoff that is less but does not require\n");
            premiseBuilder.append("cooperation.\n\n");
            // Add the specific payoff matrix explanation for Stag Hunt
            premiseBuilder.append("Payoff Matrix:\nStag/Stag: ").append(payoffMatrix[0][0]).append(" points each.\n");
            premiseBuilder.append("Rabbit/Stag: Rabbit Hunter: ").append(payoffMatrix[1][0])
                    .append(" points, Stag Hunter: 0 points.\n");
            premiseBuilder.append("Stag/Rabbit: Stag Hunter: ").append(payoffMatrix[0][1])
                    .append(" points, Rabbit Hunter: 0 points.\n");
            premiseBuilder.append("Rabbit/Rabbit: ").append(payoffMatrix[1][1]).append(" points each.\n");
        }
        premiseTextArea.setText(premiseBuilder.toString());
    }

    public void showGameScreen(int[][] payoffMatrix, int remainingRounds, int playerScore, int computerScore,
            String strategy) {
        // Clear existing components
        panel.removeAll();

        // Create and add a label
        String premiseText = getPremiseText(selectedGameType);
        JLabel premiseTextLabel = new JLabel(premiseText);
        panel.add(premiseTextLabel);

        // Update the labels with the current game state
        payoffMatrixLabel.setText("Payoff Matrix: " + formatMatrix(payoffMatrix));
        roundsRemainingLabel.setText("Rounds Remaining: " + remainingRounds);
        playerScoreLabel.setText("Your Score: " + playerScore);
        computerScoreLabel.setText("Computer Score: " + computerScore);
        strategyLabel.setText("Selected Strategy: " + strategy);

        // Create decision buttons
        JButton cooperateButton = new JButton("Cooperate");
        JButton competeButton = new JButton("Compete");

        // Register action listeners for decision buttons
        cooperateButton.addActionListener(e -> controller.playRound("Cooperate"));
        competeButton.addActionListener(e -> controller.playRound("Compete"));

        updatePremiseText(getSelectedGameType(), payoffMatrix);

        // Add components to the panel
        panel.add(payoffMatrixLabel);
        panel.add(roundsRemainingLabel);
        panel.add(playerScoreLabel);
        panel.add(computerScoreLabel);
        panel.add(cooperateButton);
        panel.add(competeButton);

        panel.revalidate();
        panel.repaint();

        // Update the frame
        frame.pack();
        frame.setVisible(true);
    }

    private String getPremiseText(String gameType) {
        // Return the premise text for the selected game type
        if ("Prisoner's Dilemma".equals(gameType)) {
            return "In the Prisoner's Dilemma, you and another prisoner are suspected of committing a crime together. You are interrogated\n"
                    + "separately and cannot communicate with each other. You have two options: cooperate with your partner by staying silent\n"
                    + "or compete by betraying them. If you both cooperate, you get a minor sentence due to lack of evidence. If one cooperates\n"
                    + "and the other competes, the cooperator receives a heavy sentence while the competitor goes free. If both compete, you\n"
                    + "both get a moderate sentence. Your decisions impact both your fate and your partner's.";
        } else if ("Stag Hunt".equals(gameType)) {
            return "In the Stag Hunt, you and another hunter must decide whether to cooperate or compete while hunting. You can either\n"
                    + "jointly hunt a stag (cooperate) or individually hunt a rabbit (compete). Successfully hunting a stag requires cooperation and\n"
                    + "brings greater rewards, but if one hunter defects to chase a rabbit, they guarantee themselves a smaller reward\n"
                    + "while leaving the other with nothing. Cooperation leads to the best mutual outcome, but the temptation to secure an individual\n"
                    + "reward is ever-present.";
        }

        return "Select a game to see its description.";
    }

    private String formatMatrix(int[][] matrix) {
        // Format the payoff matrix for display
        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix) {
            for (int value : row) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void displayRoundResults(String playerDecision, String computerDecision) {
        // Display the results of the round
        String message = String.format("Player chose: %s | Opponent chose: %s", playerDecision, computerDecision);
        JOptionPane.showMessageDialog(frame, message, "Round Results", JOptionPane.INFORMATION_MESSAGE);
    }

    public void displayEndGameResults(String message) {
        // Display the end game results
        JOptionPane.showMessageDialog(frame, message, "Game Over", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showError(String message) {
        // Display an error message
        JOptionPane.showMessageDialog(frame, message, "Input Error", JOptionPane.ERROR_MESSAGE);
    }
}
