// import javax.swing.JOptionPane;

// public class Age {
//     public static void main(String[] args) {
//         // lambda expression
//         javax.swing.SwingUtilities.invokeLater(() -> {
//             // prompt user age
//             String input = JOptionPane.showInputDialog("What's your age, cowboy?");

//             if (input != null && !input.isEmpty()) {
//                 try {
//                     int age = Integer.parseInt(input);

//                     String response = "";

//                     if (age < 40) {
//                         response = "Yer just a youngin'!";
//                     }

//                     else {
//                         response = "Yer old as dirt, cowpoke!";
//                     }

//                     JOptionPane.showMessageDialog(null, response);

//                 } catch (NumberFormatException e) {
//                     JOptionPane.showMessageDialog(null, "Please enter a valid integer for your age.");
//                 }

//             } else {
//                 JOptionPane.showMessageDialog(null, "No age provided, pardner!");
//             }
//         });
//     }
// }

import javax.swing.JOptionPane;

class Age {
    public static void main(String[] args) {
        // prompt user
        String user = JOptionPane.showInputDialog(null,
                "What's your age, cowboy?",
                "user input",
                JOptionPane.QUESTION_MESSAGE);

        // sanity check input is not null or empty
        if (user != null && !user.isEmpty()) {
            try {
                int age = Integer.parseInt(user); // parse int from input

                // respond
                if (age < 40) {
                    JOptionPane.showMessageDialog(null,
                            "Yer just a youngin'!",
                            "output",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Yer old as dirt, cowpoke!",
                            "output",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException e) {
                // Handle the case where the input is not a valid integer
                JOptionPane.showMessageDialog(null,
                        "That's no number I ever heard of, pardner!",
                        "error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Handle the case where the user cancels the dialog or presses the close button
            JOptionPane.showMessageDialog(null,
                    "Ain't no age provided!",
                    "error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
