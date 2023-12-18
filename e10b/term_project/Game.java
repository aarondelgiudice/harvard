import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game implements ActionListener {
    private GameBackend backend;
    private GameView view;
    private String selectedGameType;
    private String selectedStrategy;

    public Game() {
        // Initialize the game
        backend = new GameBackend();
        view = new GameView(this); // Pass the Game instance to the view
        setUpGUI();
    }

    private void setUpGUI() {
        // Set up the GUI
        view.displayGameSelectionOptions(); // Display game selection options in view
    }

    public void selectGame(String gameType) {
        // Set the game type in the backend
        this.selectedGameType = gameType;
        backend.setGameType(gameType); // Set the game type in the backend

        // Update the view based on the selected game type
        view.displayStrategyOptions(); // Display strategy options in view

        String premiseText = gameType.equals("Prisoner's Dilemma") ? "Prisoner's Dilemma premise text here"
                : "Stag Hunt premise text here";
        view.setPremiseText(premiseText);
    }

    // private void initializeGame() {
    // // Method to initialize the game
    // }

    public void selectStrategy(String strategy) {
        // Set the strategy in the backend
        this.selectedStrategy = strategy;
        backend.setStrategy(strategy); // Set the strategy in the backend
        view.updateViewForStrategy(strategy); // Update the view based on the selected strategy
        view.displayRoundInputOptions(); // Display round input options in view
    }

    public void startGame() {
        // Start the game
        int rounds = view.getNumberOfRounds();
        if (rounds < 1) {
            rounds = 10; // Default to 10 rounds if input is invalid
        }
        backend.startGame(selectedGameType, rounds);
        updateGameInterface(); // Update the game interface
    }

    private void updateGameInterface() {
        // Update the game interface
        view.showGameScreen(
                backend.getPayoffMatrix(),
                backend.getRemainingRounds(),
                backend.getPlayerScore(),
                backend.getComputerScore(),
                selectedStrategy);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle action events from the view
        String command = e.getActionCommand();
        if ("Game Selection".equals(command)) {
            selectGame(view.getSelectedGameType());
        } else if ("Strategy Selection".equals(command)) {
            selectStrategy(view.getSelectedStrategy());
        } else if ("Start Game".equals(command)) {
            startGame();
        }
    }

    // private void startPrisonersDilemma(int rounds) {
    // // Initialize the backend for Prisoner's Dilemma
    // }

    // private void startStagHunt(int rounds) {
    // // Initialize the backend for Stag Hunt
    // }

    public void playRound(String playerDecision) {
        // Play a round of the game
        backend.playRound(playerDecision);
        String computerDecision = backend.getComputerLastDecision();

        view.displayRoundResults(playerDecision, computerDecision);

        if (backend.getRemainingRounds() > 0) {
            updateGameInterface(); // Update the game interface
        } else {
            endGame(); // End the game
        }
    }

    private void endGame() {
        // End the game
        String outcome = backend.concludeGame();
        view.displayEndGameResults(outcome);
        exitGame(); // Exit the game
    }

    public void exitGame() {
        // Exit the game
        System.exit(0);
    }

    public static void main(String[] args) {
        // Create a new Game instance
        new Game();
    }
}
