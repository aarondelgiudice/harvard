import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField textfield;
    private CalcBackend backend;
    private JTextArea paperTape;
    private JFrame paperTapeFrame;
    private boolean isPaperTapeVisible;

    // Constructor to set up the calculator
    public Calculator() {
        backend = new CalcBackend();
        textfield = new JTextField();
        textfield.setHorizontalAlignment(JTextField.RIGHT);
        textfield.setEditable(false);

        // Setup paper tape
        paperTape = new JTextArea(10, 20);
        paperTape.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(paperTape);
        paperTapeFrame = new JFrame("Paper Tape");
        paperTapeFrame.add(scrollPane);
        paperTapeFrame.pack();
        paperTapeFrame.setLocationRelativeTo(null);

        // Add a button to toggle paper tape visibility
        JButton paperTapeToggle = new JButton("Paper Tape");
        paperTapeToggle.addActionListener(this);

        // Create the buttons and add ActionListener to each, excluding memory buttons
        String[] buttonTexts = {
                "7", "8", "9", "/", "4", "5", "6", "*",
                "1", "2", "3", "-", "0", ".", "=", "+",
                "C", "√", "±"
        };

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 4, 2, 2)); // Adjust the GridLayout to accommodate all buttons

        for (String buttonText : buttonTexts) {
            JButton button = new JButton(buttonText);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        // Adding components to the frame
        add(textfield, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(paperTapeToggle, BorderLayout.SOUTH);

        // Set frame attributes
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("Paper Tape".equals(command)) {
            isPaperTapeVisible = !isPaperTapeVisible;
            paperTapeFrame.setVisible(isPaperTapeVisible);
        } else {
            backend.feedChar(command.charAt(0));
        }

        // Update display and paper tape
        updateDisplayAndPaperTape();
    }

    private void updateDisplayAndPaperTape() {
        String result = backend.getDisplayVal();
        textfield.setText(result);

        // Update the paper tape if it's visible
        if (isPaperTapeVisible) {
            paperTape.append(result + "\n");
            paperTape.setCaretPosition(paperTape.getDocument().getLength());
        }
    }

    // Main method to run the calculator program
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Calculator();
            }
        });
    }
}
