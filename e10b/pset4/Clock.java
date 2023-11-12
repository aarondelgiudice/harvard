import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clock extends JPanel implements ActionListener {
    private JTextField hourField;
    private JTextField minuteField;
    private int h;
    private int m;
    private double minuteAngle;
    private double hourAngle;

    public Clock() {
        hourField = new JTextField(2);
        minuteField = new JTextField(2);
        JButton setTimeButton = new JButton("Set Time");
        setTimeButton.addActionListener(this);
        JPanel inputPanel = new JPanel();

        inputPanel.add(new JLabel("Hour:"));
        inputPanel.add(hourField);
        inputPanel.add(new JLabel("Minute:"));
        inputPanel.add(minuteField);
        inputPanel.add(setTimeButton);

        setPreferredSize(new Dimension(350, 375));
        setLayout(new BorderLayout());

        add(inputPanel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent action) {
        try {
            h = Integer.parseInt(hourField.getText());
            m = Integer.parseInt(minuteField.getText());

            if (h < 0 || h > 12 || m < 0 || m > 59) {
                JOptionPane.showMessageDialog(this, "Enter valid time.");
                return;
            }

            // get angles of hands
            minuteAngle = m * 6;
            hourAngle = (h % 12 + m / 60.0) * 30;

            repaint();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Enter numbers only.");
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int w = getWidth();
        int h = getHeight();
        int clockRadius = Math.min(w, h) / 2 - 30;
        int XcenterPoint = w / 2;
        int YcenterPoint = h / 2;

        // clock face
        g.setColor(Color.WHITE);

        g.fillOval(XcenterPoint - clockRadius, YcenterPoint - clockRadius, 2 * clockRadius, 2 * clockRadius);

        g.setColor(Color.BLACK);

        g.drawOval(XcenterPoint - clockRadius, YcenterPoint - clockRadius, 2 * clockRadius, 2 * clockRadius);

        // minute & hour hands
        drawHands(g, XcenterPoint, YcenterPoint, minuteAngle, clockRadius - 20, Color.BLACK);

        drawHands(g, XcenterPoint, YcenterPoint, hourAngle, clockRadius / 2, Color.RED);
    }

    private void drawHands(Graphics g, int x, int y, double ang, int len, Color c) {
        g.setColor(c);

        double rads = Math.toRadians(-ang + 90);

        int XendPoint = x + (int) (len * Math.cos(rads));
        int YendPoint = y - (int) (len * Math.sin(rads));

        g.drawLine(x, y, XendPoint, YendPoint);
    }

    public static void invokeGUI() {
        JFrame frame = new JFrame("Clock Face");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Clock());
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Clock::invokeGUI);
    }
}
