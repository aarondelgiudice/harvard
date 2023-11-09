import javax.swing.JOptionPane;

public class Age {
    public static void main(String[] args) {
        // lambda expression
        javax.swing.SwingUtilities.invokeLater(() -> {
            // prompt user age
            String input = JOptionPane.showInputDialog("What's your age, cowboy?");

            if (input != null && !input.isEmpty()) {
                try {
                    int age = Integer.parseInt(input);

                    String response = "";

                    if (age < 40) {
                        response = "Yer just a youngin'!";
                    }

                    else {
                        response = "Yer old as dirt, cowpoke!";
                    }

                    JOptionPane.showMessageDialog(null, response);

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid integer for your age.");
                }

            } else {
                JOptionPane.showMessageDialog(null, "No age provided, pardner!");
            }
        });
    }
}
