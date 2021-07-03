# Interact with Keyboard

Interaction between users and computers occurs at the user interface (or simply interface), which includes both software and hardware; for example, characters or objects displayed by software on a personal computer's monitor, input received from users via hardware peripherals such as keyboards and mouse etc..

## Applying interaction to object

Assume that create new project as simple JOGL application. The project by default draws a triangle and quad shapes. In this example we add 3D interaction to these objects via keyboard.

1. Import required libraries:  
```java
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
```
2. Let the class implements `KeyListener`. In addition you will need to implement all the abstract methods:  
```java
public class SimpleJOGL implements GLEventListener, KeyListener {
    // default code
    
    @Override
    public void keyTyped(KeyEvent e) {    }

    @Override
    public void keyPressed(KeyEvent e) {    }

    @Override
    public void keyReleased(KeyEvent e) {    }
}
```
3. Add required variables to class properties:  
```java
float rotateY = 0.0f;
float translateZ = 0.0f;
```
4. Add listener to the GLCanvas. Inside `main()` method replace `canvas.addEventListener(new SampleJOGL());` to following code:
```java
SimpleJOGL demo = new SimpleJOGL();
canvas.addGLEventListener(demo);
frame.addKeyListener(demo);
canvas.addKeyListener(demo);
```
5. Add interaction to the object in `display()` method before drawing the triangle code:  
```java
gl.glTranslatef(0.0f, 0.0f, translateZ);
gl.glRotatef(rotateY, 0.0f, 1.0f, 0.0f);
```
6. Update `keyPressed()` body with your keyboard handler:  
```java
public void keyPressed(KeyEvent e) {
  if (e.getKeyCode() == KeyEvent.VK_UP) {
    translateZ += 0.1f;
  } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
    translateZ -= 0.1f;
  } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
    rotateY += 1.0f;
  } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
    rotateY -= 1.0f;
  }
}
```
7. Run your program and use arrow keys to interact with objects.

### Sample Run
![Keyboard Interaction](/images/lab11/1.png)
![Keyboard Interaction](/images/lab11/2.png)
![Keyboard Interaction](/images/lab11/3.png)
![Keyboard Interaction](/images/lab11/4.png)
![Keyboard Interaction](/images/lab11/5.png)

