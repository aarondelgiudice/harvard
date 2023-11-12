import javax.swing.*;
import java.awt.*;

public class Olympics extends JPanel {
    private int ringDiameter = 150;
    private int ringStrokeWidth = 6;

    public Olympics() {
        setPreferredSize(new Dimension(750, 500));
        setBackground(Color.WHITE);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(ringStrokeWidth));


        drawRing(g2d, 300, 150, Color.BLACK);
        drawRing(g2d, 150, 150, Color.BLUE);
        drawRing(g2d, 375, 225, Color.GREEN);
        drawRing(g2d, 450, 150, Color.RED);
        drawRing(g2d, 225, 225, Color.YELLOW);
    }

    private void drawRing(Graphics2D g2d, int x, int y, Color color) {
        g2d.setColor(color);
        g2d.drawOval(x, y, ringDiameter, ringDiameter);
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Olympic Rings");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Olympics());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Olympics::createAndShowGUI);
    }
}
