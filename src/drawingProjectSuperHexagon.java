import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class drawingProjectSuperHexagon {
    public static void drawImage(Graphics graphics) {
        int size = WIDTH / 12;
        int x = WIDTH / 2;
        int y = HEIGHT / 2;

        drawingprojectSuperHexagon(x, y, size, graphics);

        for (int k = 0; k < 6; k++) {
            for (int i = 0; i < 6; i++) {
                double angle = 2 * Math.PI / 6 * i;
                int offsetX = (int) (size * 1.7 * Math.sin(angle));
                int offsetY = (int) (size * 1.7 * Math.cos(angle));
                drawingprojectSuperHexagon(x + offsetX, y + offsetY, size, graphics);
                for (int j = 0; j < 6; j++) {
                    double angle2 = 2 * Math.PI / 6 * j;
                    int offsetX2 = (int) (size * 1.7 * Math.sin(angle2));
                    int offsetY2 = (int) (size * 1.7 * Math.cos(angle2));
                    drawingprojectSuperHexagon(x + offsetX + offsetX2, y + offsetY + offsetY2, size, graphics);
                    for (int l = 0; l < 6; l++) {
                        double angle3 = 2 * Math.PI / 6 * l;
                        int offsetX3 = (int) (size * 1.7 * Math.sin(angle3));
                        int offsetY3 = (int) (size * 1.7 * Math.cos(angle3));
                        drawingprojectSuperHexagon(x + offsetX + offsetX2 + offsetX3, y + offsetY + offsetY2 + offsetY3, size, graphics);
                    }
                }
            }
        }

    }

    public static void drawingprojectSuperHexagon(int x, int y, int size, Graphics graphics) {
        int[] xPoints = new int[6];
        int[] yPoints = new int[6];

        for (int i = 0; i < 6; i++) {
            double angle = 2 * Math.PI / 6 * i;
            xPoints[i] = x + (int) (size * Math.cos(angle));
            yPoints[i] = y + (int) (size * Math.sin(angle));
        }

        graphics.setColor(Color.BLACK);
        graphics.drawPolygon(xPoints, yPoints, 6);
    }

    // ezt a részt nem kell módosítani
    static int WIDTH = 320;
    static int HEIGHT = 320;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImagePanel panel = new ImagePanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.pack();
    }

    static class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            drawImage(graphics);
        }
    }
}
