import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TrafficLight extends JPanel {
    private Color redLight = Color.RED;
    private Color yellowLight = Color.YELLOW;
    private Color greenLight = Color.GREEN;

    public TrafficLight() {
        setPreferredSize(new Dimension(250, 600));
        MouseAdapter mouseAdapter = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int height = getHeight();
                int segment = height / 3;
                int y = e.getY();

                // check which segment is clicked
                if (y < segment) {
                    redLight = Color.RED.brighter();
                    yellowLight = Color.YELLOW.darker();
                    greenLight = Color.GREEN.darker();
                } else if (y < segment * 2) {
                    redLight = Color.RED.darker();
                    yellowLight = Color.YELLOW.brighter();
                    greenLight = Color.GREEN.darker();
                } else {
                    redLight = Color.RED.darker();
                    yellowLight = Color.YELLOW.darker();
                    greenLight = Color.GREEN.brighter();
                }

                repaint();
            }
        };
        addMouseListener(mouseAdapter);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        int diameter = Math.min(width, height / 3) - 50;
        int x = (width - diameter) / 2;
        int y = 25;

        // set background
        g.setColor(Color.BLACK);
        g.fillRect(x - 10, y - 10, diameter + 20, height - 30);

        // add the red, yelloq, green lights
        g.setColor(redLight);
        g.fillOval(x, y, diameter, diameter);

        y += height / 3;
        g.setColor(yellowLight);
        g.fillOval(x, y, diameter, diameter);

        y += height / 3;
        g.setColor(greenLight);
        g.fillOval(x, y, diameter, diameter);
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Traffic Light");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new TrafficLight());
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TrafficLight::createAndShowGUI);
    }
}
