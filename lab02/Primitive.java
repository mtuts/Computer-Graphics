package lab02;

import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

/**
 * Draw Primitive Geometries
 * @author Marwan
 */
public class Primitive implements GLEventListener {

    public static void main(String[] args) {
        Frame frame = new Frame("Lab 02 Primitive Geometries");
        GLCanvas canvas = new GLCanvas();

        canvas.addGLEventListener(new Primitive());
        frame.add(canvas);
        frame.setSize(1050, 480);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        // Center frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
    }

    public void init(GLAutoDrawable drawable) {
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));

        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());

        // Enable VSync
        gl.setSwapInterval(1);

        // Setup the drawing area and shading mode
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        if (height <= 0) { // avoid a divide by zero error!
        
            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();

        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();

        // Move the "drawing cursor" around
        gl.glTranslatef(-4.5f, 0.0f, -6.0f);
        
        // Drawing Lines
        gl.glBegin(GL.GL_LINES);
        gl.glColor3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 0.0f, 0.0f);
        gl.glColor3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glColor3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 1.0f);
        gl.glEnd();
        
        gl.glTranslatef(-1.0f, 2.0f, -6.0f);
        // Line Strip as 5 shape
        gl.glBegin(GL.GL_LINE_STRIP);
        gl.glColor3f(0.0f, 1.0f, 0.0f);
        gl.glVertex2f(1.0f, 2.5f);
        gl.glVertex2f(-1.0f, 2.5f);
        gl.glVertex2f(-1.0f, 0.5f);
        gl.glVertex2f(1.0f, 0.5f);
        gl.glVertex2f(1.0f, -1.5f);
        gl.glVertex2f(-1.0f, -1.5f);
        gl.glEnd();
        
        gl.glTranslatef(0.0f, -4.8f, 0.0f);
        
        // Line Strip as 5 shape closed
        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glColor3f(0.0f, 1.0f, 0.0f);
        gl.glVertex2f(1.0f, 2.5f);
        gl.glVertex2f(-1.0f, 2.5f);
        gl.glVertex2f(-1.0f, 0.5f);
        gl.glVertex2f(1.0f, 0.5f);
        gl.glVertex2f(1.0f, -1.5f);
        gl.glVertex2f(-1.0f, -1.5f);
        gl.glEnd();
        
        gl.glTranslatef(3.0f, 1.0f, 0.0f);
        
        // Regular Pentagon (5 edges polygon)
        int number_of_edge = 5;
        float polygon_angle = (number_of_edge - 2) * 180.0f / number_of_edge;
        double in_angle = Math.toRadians(polygon_angle);        // 5-edges-polygon angle 108 deg
        double re_angle = Math.toRadians(180 - polygon_angle);  // 180 - 108
        double angle2 = in_angle - re_angle;
        float edge = 3.0f;                                      // edge length
        float x1 = 0, y1 = 0;
        
        gl.glBegin(GL.GL_POLYGON);
        gl.glColor3f(1.0f, 1.0f, 1.0f);
        gl.glVertex2f(x1,   y1);
        gl.glVertex2f(edge, y1);
        gl.glVertex2f(edge + (float) (Math.cos(re_angle) * edge), (float) (Math.sin(re_angle) * edge));
        gl.glVertex2f(edge / 2.0f, (float) ((Math.sin(re_angle) * edge) + Math.sin(angle2) * edge));
        gl.glVertex2f(-(float) (Math.cos(re_angle) * edge), (float) (Math.sin(re_angle) * edge));
        gl.glEnd();
        
        
        gl.glTranslatef(5.0f, 3.0f, 0.0f);
        
        // Quad Strip
        
        gl.glBegin(GL.GL_QUAD_STRIP);
        gl.glColor3f(0.0f, 0.0f, 1.0f);
        gl.glVertex2f(0.0f,  0.0f);
        gl.glVertex2f(0.0f,  2.0f);
        gl.glVertex2f(2.0f, -0.5f);
        gl.glVertex2f(2.0f,  2.25f);
        
        gl.glColor3f(1.0f, 0.0f, 0.0f);
        gl.glVertex2f(2.0f, -0.5f);
        gl.glVertex2f(2.0f,  2.25f);
        gl.glVertex2f(3.8f,  0.0f);
        gl.glVertex2f(4.0f,  2.25f);
        
        gl.glColor3f(0.0f, 1.0f, 0.0f);
        gl.glVertex2f(3.8f,  0.0f);
        gl.glVertex2f(4.0f,  2.25f);
        gl.glVertex2f(6.0f, -0.5f);
        gl.glVertex2f(6.5f,  1.8f);
        gl.glEnd();
        
        
        gl.glTranslatef(0.0f, -4.0f, 0.0f);
        // Trinagle Strip
        
        gl.glBegin(GL.GL_TRIANGLE_STRIP);
        gl.glColor3f(1.0f, 1.0f, 1.0f);
        gl.glVertex2f(0.0f,  0.0f);
        gl.glVertex2f(1.0f,  2.0f);
        gl.glVertex2f(2.5f,  0.0f);
        gl.glColor3f(0.0f, 1.0f, 0.0f);
        
        gl.glVertex2f(3.0f, 2.0f);
        gl.glVertex2f(4.0f, 0.0f);
        gl.glVertex2f(5.0f, 2.0f);
        gl.glEnd();

        // Flush all drawing operations to the graphics card
        gl.glFlush();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
}

