# Texture Mapping

Applying textures on 2D and 3D objects

## Using textures with JOGL

JOGL comes with several classes that make it fairly easy to use textures in Java. An object of type Texture represents a texture that has already been loaded into OpenGL. Once you have an object, texture, of type Texture, you just need to
call:

```java
texture.bind(gl);
```

to tell OpenGL to use the texture for objects that it will draw. Before the texture will actually be applied, however, you still have to enable texturing by calling `gl.glEnable(GL2.GL_TEXTURE_2D)` or, equivalently

```java
texture.enable(gl);
```

## Applying texture on 2D object

We need to import following libraries:

```java
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import java.io.File;
import java.io.IOException;
```

In `init()` method after defining gl object line add texture initialization:

```java
Texture tex;
// activate texture mapping for 2D
gl.glEnable(GL.GL_TEXTURE_2D);

try {
  tex = TextureIO.newTexture(new File("path-to-image.jpg"), true);
  tex.bind();
} catch (IOException e) {
  System.err.println(e.getMessage());
}
```

In `display()` method we add our primitive shape for example Quad and apply texture on it:

```java
gl.glBegin(GL.GL_QUADS);

gl.glTexCoord2d(1.0, 1.0);
gl.glVertex2d(0.0, 0.0);

gl.glTexCoord2d(0.0, 1.0);
gl.glVertex2d(1.0, 0.0);

gl.glTexCoord2d(0.0, 0.0);
gl.glVertex2d(1.0, 1.0);

gl.glTexCoord2d(1.0, 0.0);
gl.glVertex2d(0.0, 1.0);

gl.glEnd();
```

As you can see texture coordinate (1.0, 0.0) maps to vertex 1, texture coordinate (0.0, 0.0) maps to vertex 2, and so on.


### Sample Run
![Applying texture on quad](/screen-shots/lab09/2d.png)

## Applying texture on 3D object

We need same libraries that we imported before and `GLUT` library:

```java
import com.sun.opengl.util.GLUT;
import com.sun.opengl.util.texture.TextureIO;
import java.io.File;
import java.io.IOException;
```

In `init()` method, it will be same as in 2D . In `display()` method, add pre-defined object (`Teapot`):

```java
GLUT glut = new GLUT();
glut.glutSolidTeapot(1.0f);
```

### Sample Run
![Applying texture on quad](/screen-shots/lab09/3d.png)