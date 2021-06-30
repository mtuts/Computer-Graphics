
import java.applet.Applet;
import java.awt.Graphics;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marwan
 */
public class BLA extends Applet {
    int x1, y1, x2, y2;

    @Override
    public void init() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter X1 Y1");
        x1 = scan.nextInt();
        y1 = scan.nextInt();
        
        System.out.println("Enter X2 Y2");
        x2 = scan.nextInt();
        y2 = scan.nextInt();
    }

    @Override
    public void paint(Graphics g) {
        try {
            int dx = x2 - x1;
            int dy = y2 - y1;
            int count = dx;
            
            int p = 2 * dy - dx;
            int x, y;
            
            if (x1 > x2) {
                x = x2;
                y = y2;
            } else {
                x = x1;
                y = y1;
            }
            g.drawString(".", x, y);
            
            while (count > 0) {
                x++;
                if (p < 0) {
                    p = p + 2 * dy;
                } else {
                    y++;
                    p = p + 2 * (dy - dx);
                }
                g.drawString(".", x, y);
                count--;
            }
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        }
    }
    
    
    
}
