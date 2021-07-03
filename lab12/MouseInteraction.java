package lab12;

import com.sun.opengl.util.GLUT;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;


/**
 * Mouse Interaction
 * @author Marwan
 */
public class MouseInteraction extends Frame implements GLEventListener, MouseListener, MouseMotionListener {

    private int width;
    private int height;
    private final GLCanvas canvas;
    
    private double rotationX = 0;
    private double rotationY = 0;
    
    private int mouseMotionStartX;
    private int mouseMotionStartY;
    
    public MouseInteraction(int width, int height) {
        this.width = width;
        this.height = height;
        
        setSize(width, height);
        
        canvas = new GLCanvas();
        canvas.addGLEventListener(this);
        add(canvas);
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new MouseInteraction(640, 640);
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
        
        drawable.addMouseListener(this);
        drawable.addMouseMotionListener(this);
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        
        this.width = width;
        this.height = height;

        if (height <= 0) { // avoid a divide by zero error!
        
            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        
        gl.glOrtho(-1, 1, -1, 1, -1, 1);
//        glu.gluPerspective(45.0f, h, 1.0, 20.0);
//        gl.glMatrixMode(GL.GL_MODELVIEW);
//        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();

        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();

        gl.glRotated(rotationY, 0, 1, 0);
        gl.glRotated(rotationX, 1, 0, 0);

        
        GLUT glut = new GLUT();
        glut.glutWireTeapot(0.3f);


        // Flush all drawing operations to the graphics card
        gl.glFlush();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseMotionStartX = e.getX();
        mouseMotionStartY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        
        rotationX += (y - mouseMotionStartY) * 180.0 / height;
        rotationY += (x - mouseMotionStartX) * 180.0 / width;
        
        mouseMotionStartX = e.getX();
        mouseMotionStartY = e.getY();
        
        canvas.display();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}

