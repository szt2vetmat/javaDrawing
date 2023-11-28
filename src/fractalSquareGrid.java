import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class fractalSquareGrid {
    public static void drawImage(Graphics graphics) {
        int size = WIDTH / 2;
        /*
        graphics.setColor(new Color(0, 49, 63));
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
        graphics.setColor(Color.yellow);
        */
        drawSomething(0, 0, size, graphics);
    }

    public static void drawSomething(int x, int y ,int size, Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setStroke(new BasicStroke(10));
        Point p1 = new Point(300,300);
        Point p2 = new Point(600,300);
        Point p3 = new Point(600,600);
        Point p4 = new Point(300,600);
        DrawSquare(g2, p1, p2, p3, p4, 3);
    }



    public static void DrawSquare(Graphics graphics, Point2D p1, Point2D p2, Point2D p3, Point2D p4, int depth){
        if(depth == 0){

            int[] xPoints = {(int)p1.getX(),(int)p2.getX(),(int)p3.getX(),(int)p4.getX()};
            int[] YPoints = {(int)p1.getY(),(int)p2.getY(),(int)p3.getY(),(int)p4.getY()};

            graphics.drawPolygon(xPoints, YPoints, xPoints.length);


        }else{
            int[] xPoints = {(int)p1.getX(),(int)p2.getX(),(int)p3.getX(),(int)p4.getX()};
            int[] YPoints = {(int)p1.getY(),(int)p2.getY(),(int)p3.getY(),(int)p4.getY()};

            graphics.drawPolygon(xPoints, YPoints, xPoints.length);

            Point2D topLeftMidPoint = MidPointOfASide(p1, p2);
            double distance = DistanceOfTwoPoints(p1, topLeftMidPoint) / 2 ;

            DrawSquare(graphics, TranslateTopLeft(p1,distance), TranslateTopRight(p1, distance), TranslateBottomRight(p1, distance), TranslateBottomLeft(p1, distance), depth -1);
            DrawSquare(graphics, TranslateTopLeft(p2,distance), TranslateTopRight(p2, distance), TranslateBottomRight(p2, distance), TranslateBottomLeft(p2, distance), depth -1);
            DrawSquare(graphics, TranslateTopLeft(p3,distance), TranslateTopRight(p3, distance), TranslateBottomRight(p3, distance), TranslateBottomLeft(p3, distance), depth -1);
            DrawSquare(graphics, TranslateTopLeft(p4,distance), TranslateTopRight(p4, distance), TranslateBottomRight(p4, distance), TranslateBottomLeft(p4, distance), depth -1);
        }

    }

    public static Point2D ThirdOfASide(Point2D p1, Point2D p2){
        return new Point((int)(2*p1.getX() + p2.getX())/3,(int)(2*p1.getY() + p2.getY())/3 );
    }
    public static Point2D MidPointOfASide(Point2D p1, Point2D p2){
        return new Point((int)(p1.getX() + p2.getX())/ 2, (int)(p1.getY() + p2.getY()) / 2 );
    }

    public static Point2D TranslateTopLeft(Point2D p1, double distance){
        return new Point((int)(p1.getX() - distance), (int)(p1.getY()-distance));
    }
    public static Point2D TranslateTopRight(Point2D p1, double distance){
        return new Point((int)(p1.getX() + distance), (int)(p1.getY()-distance));
    }
    public static Point2D TranslateBottomRight(Point2D p1, double distance){
        return new Point((int)(p1.getX() + distance), (int)(p1.getY()+distance));
    }
    public static Point2D TranslateBottomLeft(Point2D p1, double distance){
        return new Point((int)(p1.getX() - distance), (int)(p1.getY()+distance));
    }


    public static double DistanceOfTwoPoints(Point2D p1, Point2D p2){
        double tav1 = Math.pow((p1.getX()-p2.getX()), 2);
        double tav2 = Math.pow((p1.getY()-p2.getY()), 2);

        return Math.sqrt(tav1 + tav2);
    }

    
    static int WIDTH = 900;
    static int HEIGHT = 900;

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
