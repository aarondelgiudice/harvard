import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class FifteenPuzzle extends JFrame {
    private int SIZE = 4; // 4x4 grid == 15 buttons + 1 empty space
    private JButton[][] buttons = new JButton[SIZE][SIZE];
    private int emptyX = SIZE - 1;
    private int emptyY = SIZE - 1;

    public FifteenPuzzle() {
        setTitle("Fifteen Puzzle Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(SIZE, SIZE));

        // initialize buttons listeners
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int number = i * SIZE + j + 1;
                JButton button = new JButton(number == SIZE * SIZE ? "" : String.valueOf(number));
                button.setFocusable(true);
                button.setActionCommand(i + "," + j);
                button.addActionListener(new ButtonClickListener(i, j));
                buttons[i][j] = button;
                add(button);
            }
        }

        // shuffle button
        JButton shuffleButton = new JButton("Shuffle");
        shuffleButton.addActionListener(e -> shuffleBoard());
        add(shuffleButton);

        setSize(450, 450);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private class ButtonClickListener implements ActionListener {
        private int x, y;

        public ButtonClickListener(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void actionPerformed(ActionEvent e) {
            if (Math.abs(emptyX - x) + Math.abs(emptyY - y) == 1) {
                buttons[emptyX][emptyY].setText(buttons[x][y].getText());
                buttons[x][y].setText("");
                emptyX = x;
                emptyY = y;
                checkSolution();
            }
            // System.out.println("Button clicked: " + e.getActionCommand()); // debugging

        }
    }

    private void shuffleBoard() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int[] dx = { 1, 0, -1, 0 };
            int[] dy = { 0, 1, 0, -1 };
            int direction = random.nextInt(4);
            int newX = emptyX + dx[direction];
            int newY = emptyY + dy[direction];
            if (newX >= 0 && newX < SIZE && newY >= 0 && newY < SIZE) {
                buttons[emptyX][emptyY].setText(buttons[newX][newY].getText());
                buttons[newX][newY].setText("");
                emptyX = newX;
                emptyY = newY;
            }
        }
    }

    private void checkSolution() {
        boolean solved = true;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == SIZE - 1 && j == SIZE - 1) {
                    continue; // Skip the empty space
                }
                if (!buttons[i][j].getText().equals(String.valueOf(i * SIZE + j + 1))) {
                    solved = false;
                    break;
                }
            }
        }
        if (solved) {
            JOptionPane.showMessageDialog(this, "Congrats! You solved the puzzle!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FifteenPuzzle::new);
    }
}
