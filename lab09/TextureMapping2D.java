package lab09;

import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;

import java.io.File;
import java.io.IOException;

/**
 * Texture Mapping on 2D Primitive Geometries
 * @author Marwan
 */
public class TextureMapping2D implements GLEventListener {

    public static void main(String[] args) {
        Frame frame = new Frame("Lab 09 Texture Mapping on 2D");
        GLCanvas canvas = new GLCanvas();

        canvas.addGLEventListener(new TextureMapping2D());
        frame.add(canvas);
        frame.setSize(680, 480);
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
        
        Texture tex;
        // activate texture mapping for 2D
        gl.glEnable(GL.GL_TEXTURE_2D);
        
        try {
            // load texture
            tex = TextureIO.newTexture(new File("box.jpg"), true);
            tex.bind();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        
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
        gl.glTranslatef(-2.0f, 0.0f, -6.5f); // setup view to make models visiable
        
        // texture image is flipped vertically from the original
        gl.glBegin(GL.GL_QUADS);
        gl.glTexCoord2d(1, 1);
        gl.glVertex2d(-1.0, -1.0);
        gl.glTexCoord2d(0, 1);
        gl.glVertex2d(1.0, -1.0);
        gl.glTexCoord2d(0, 0);
        gl.glVertex2d(1.0, 1.0);
        gl.glTexCoord2d(1, 0);
        gl.glVertex2d(-1.0, 1.0);
        gl.glEnd();
        
        gl.glTranslatef(3.0f, 0.0f, 0.0f); // translate to x by 3
        
        // texture image match the original position
        gl.glBegin(GL.GL_QUADS);
        gl.glTexCoord2d(0, 1);
        gl.glVertex2d(-1.0, -1.0);
        gl.glTexCoord2d(1, 1);
        gl.glVertex2d(1.0, -1.0);
        gl.glTexCoord2d(1, 0);
        gl.glVertex2d(1.0, 1.0);
        gl.glTexCoord2d(0, 0);
        gl.glVertex2d(-1.0, 1.0);
        gl.glEnd();

        // Flush all drawing operations to the graphics card
        gl.glFlush();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
}