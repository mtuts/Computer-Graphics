package lab07;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.Scanner;

/**
 * Midpoint Circle Algorithm
 * @author Marwan
 */
public class MCA extends Applet {
    int xc, yc, rad;

    @Override
    public void init() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter circle center point X Y");
        xc = scan.nextInt();
        yc = scan.nextInt();
        
        System.out.println("Enter Radius");
        rad = scan.nextInt();
    }

    @Override
    public void paint(Graphics g) {
        int x = 0, y = rad;
        int p = 5 / 4 - rad;
        
        while (x < y) {
            if (p < 0) {
                x++;
                p = p + 2 * x + 3;
            } else {
                x++; y--;
                p = p + 2 * x + 3 - 2 * y + 2;
            }
            g.drawString(".", xc + x, yc + y);
            g.drawString(".", xc + y, yc - x);
            g.drawString(".", xc - y, yc + x);
            g.drawString(".", xc - x, yc + y);
            g.drawString(".", xc + x, yc - y);
            g.drawString(".", xc + y, yc + x);
            g.drawString(".", xc - y, yc - x);
            g.drawString(".", xc - x, yc - y);
        }
    }
}

