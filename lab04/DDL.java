package lab04;
import java.applet.Applet;
import java.awt.Graphics;
import java.util.Scanner;

/**
 * 
 * @author Marwan
 */
public class DDL extends Applet {
    double x1, y1, x2, y2;

    @Override
    public void init() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter X1 Y1");
        x1 = scan.nextDouble();
        y1 = scan.nextDouble();
        
        System.out.println("Enter X2 Y2");
        x2 = scan.nextDouble();
        y2 = scan.nextDouble();
    }

    @Override
    public void paint(Graphics g) {
        try {
            double dx = x2 - x1;
            double dy = y2 - y1;
            double steps;
            
            if (Math.abs(dx) > Math.abs(dy)) {
                steps = Math.abs(dx);
            } else {
                steps = Math.abs(dy);
            }
            double xc = dx / steps;
            double yc = dy / steps;
            
            double x = x1,
                    y = y1;
            for (int k = 1; k <= steps; k++) {
                x = x + xc;
                y = y + yc;
                g.drawString(".", (int) x, (int) y);
            }
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        }
    }
}

