import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class MailLayout {
    private JFrame frame;
    private JTextField to, cc, bcc, subject;
    private JComboBox<String> from;
    private JTextArea message;
    private JButton send;
    private String[] emailList = { "aarondelgiudice@gmail.com", "dwhabermehl@gmail.com", "hleitner@harvard.edu" };

    public MailLayout() {
        // create the JFrame
        frame = new JFrame("New Message");
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // top, cc, bcc, subject, from fields
        JPanel topPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        topPanel.add(new JLabel("To:"));
        to = new JTextField();
        topPanel.add(to);

        topPanel.add(new JLabel("Cc:"));
        cc = new JTextField();
        topPanel.add(cc);

        topPanel.add(new JLabel("Bcc:"));
        bcc = new JTextField();
        topPanel.add(bcc);

        topPanel.add(new JLabel("Subject:"));
        subject = new JTextField();
        subject.addActionListener(e -> updateTitle());
        topPanel.add(subject);

        topPanel.add(new JLabel("From:"));
        from = new JComboBox<>(emailList);
        topPanel.add(from);

        frame.add(topPanel, BorderLayout.NORTH);

        // message field
        message = new JTextArea();
        frame.add(new JScrollPane(message), BorderLayout.CENTER);

        // send button
        send = new JButton("Send");
        send.addActionListener(e -> sendMessage());
        frame.add(send, BorderLayout.SOUTH);

    }

    private void updateTitle() {
        String title = subject.getText().isEmpty() ? "New Message" : subject.getText();
        frame.setTitle(title);
    }

    private void sendMessage() {
        try (FileWriter writer = new FileWriter("outbox.txt")) {
            writer.write(message.getText());
            message.setText("");
            frame.setTitle("New Message");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MailLayout app = new MailLayout();
            app.frame.setVisible(true);
        });
    }
}