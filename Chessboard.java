import java.awt.*;
import java.awt.Graphics;
import java.awt.Shape;
import javax.swing.*;
import java.lang.*;
import java.awt.geom.*;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.AlphaComposite;
import javax.swing.JFrame;


/*
   A simple chessboard using Graphics2D
@author Fjolla Pllana
*/



public class Chessboard extends JApplet {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JApplet applet = new Chessboard();
        applet.init();
        frame.getContentPane().add(applet);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(525,525);
    }

    public void init() {
        JPanel panel = new Panel();
        getContentPane().add(panel);
    }

    class Panel extends JPanel {
        public Panel() {
            setPreferredSize(new Dimension(500, 500));
            setBackground(Color.gray);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            AffineTransform transform = new AffineTransform();

            Font font = new Font("Tahoma", Font.PLAIN, 28);

            g2.setColor(Color.lightGray);
            int fontSize = 40;

            g2.setFont(font);
            g2.drawString(" 1    2    3    4    5    6    7    8", 50, 40);
            g2.drawString(" 1    2    3    4    5    6    7    8", 50, 480);
            int x0 = 20;
            int x1 = 460;
            int y1 = 80;

            g2.drawString("a", x0, y1);
            g2.drawString("b", x0, y1 + 50);
            g2.drawString("c", x0, y1 + 100);
            g2.drawString("d", x0, y1 + 150);
            g2.drawString("e", x0, y1 + 200);
            g2.drawString("f", x0, y1 + 250);
            g2.drawString("g", x0, y1 + 300);
            g2.drawString("h", x0, y1 + 350);


            g2.drawString("a", x1, y1);
            g2.drawString("b", x1, y1 + 50);
            g2.drawString("c", x1, y1 + 100);
            g2.drawString("d", x1, y1 + 150);
            g2.drawString("e", x1, y1 + 200);
            g2.drawString("f", x1, y1 + 250);
            g2.drawString("g", x1, y1 + 300);
            g2.drawString("h", x1, y1 + 350);

            g2.setColor(Color.lightGray);

            int x = 50;
            int y = 50;
            int co_x = x;
            int co_y = y;
            int no = 8;
            int size = 50;
            boolean b = false;
            setBackground(Color.gray);

            for (int i = 0; i < no; i++) {
                if (i % 2 == 0) {
                    b = false;
                } else if (i % 2 == 1) {
                    b = true;
                }


                co_x = x;
                for (int j = 0; j < no; j++) {
                    if (b == true) {
                        g2.setPaint(Color.white);
                        g2.fill(new Rectangle2D.Double(co_x, co_y, size, size));
                        b = false;
                    } else {
                        g2.setPaint(Color.black);
                        g2.fill(new Rectangle2D.Double(co_x, co_y, size, size));
                        b = true;
                    }
                    co_x += size;
                }

                co_y += size;
            }
            /* Draws a transparent circle
            Shape circle = new Ellipse2D.Double(160, 110, 70, 70);

            g2.setColor(Color.RED);
            {
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 7 * 0.0909f));
                g2.draw(circle);
                g2.fill(circle);
            }*/
        }
    }
}
