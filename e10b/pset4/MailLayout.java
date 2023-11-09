import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MailLayout extends JFrame {
    private JTextField toField, ccField, bccField, subjectField;
    private JComboBox fromBox;
    private JTextArea messageArea;
    private JButton sendButton;

    public MailLayout() {
        setTitle("New Message");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // flow layout
        getContentPane().setLayout(new FlowLayout());

        // add to, cc, bcc, etc. fields
        add(new JLabel("To:"));
        toField = new JTextField(20);
        add(toField);

        add(new JLabel("Cc:"));
        ccField = new JTextField(20);
        add(ccField);

        add(new JLabel("Bcc:"));
        bccField = new JTextField(20);
        add(bccField);

        add(new JLabel("Subject:"));
        subjectField = new JTextField(20);
        add(subjectField);

        add(new JLabel("From:"));
        fromBox = new JComboBox(new String[] { "student1<email1@harvard.edu>", "student2<email2@harvard.edu>",
                "student3<email3@harvard.edu>" });
        add(fromBox);

        messageArea = new JTextArea(5, 20);
        add(new JScrollPane(messageArea));

        sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendEmail();
            }
        });

        add(sendButton);

        // pack and set visibility
        pack();
        setVisible(true);
    }

    private void sendEmail() {
        try {
            FileWriter fw = new FileWriter("outbox.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);

            out.println(messageArea.getText());
            out.close();

            // clear screen
            toField.setText("");
            ccField.setText("");
            bccField.setText("");
            subjectField.setText("");
            messageArea.setText("");
            fromBox.setSelectedIndex(0);

            // confirmation message
            JOptionPane.showMessageDialog(null, "Email sent!");

        } catch (IOException ioException) {
            JOptionPane.showMessageDialog(null, "Error occurred while sending email.");
        }
    }

    public static void main(String[] args) {
        new MailLayout();
    }
}
