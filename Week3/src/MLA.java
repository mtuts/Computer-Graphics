
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
public class MLA extends Applet {
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
        int x = 0, y = 0, dx = 0, dy = 0;
        int incE, incNE, c;
        dx = x2 - x1;
        dy = y2 - y1;
        c = dy * 2 - dx;
        incE = dy * 2;
        incNE = (dy - dx) * 2;
        y = y1;
        
        for (int i = x1; i < x2; i++) {
            g.drawString(".",i, y);
            if (c <= 0) {
                c += incE;
            } else {
                c += incNE;
                y++;
            }
        }
        g.drawString(".", x2, y);
    }
    
    
    
}
