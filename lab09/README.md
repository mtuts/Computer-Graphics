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

## Applying texture on 2d object

We need to import following libraries:

```java
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import java.io.File;
import java.io.IOException;
```

then adding texture in `init()` method:

```java
// after defining gl object
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

Then in `display()` method we add our primitive shape for example Quad:



### Sample Run

<table><tr><td>
<img src="/screen-shots/lab08/translate-b.png" alt="Before translation" width="auto">
</td><td>
<img src="/screen-shots/lab08/translate-a.png" alt="After translation" width="100%">
</td></tr>
<tr>
<th>Before translation</th>
<th>After translation</th>
</tr>
</table>

## Rotation

Rotation of objects can be done along any of the 3 axes, using `glRotatef(angle, x, y, z)`. You need to pass angle of rotation and x, y, z axes as parameters to this method.

```java
glRotatef(float, angle, float x, float y float z)
```

### Example
```java
gl.glRotatef(angle, 0.0f, 1.0f, 0.0f);
```

### Sample Run

<table><tr><td>
<img src="/screen-shots/lab08/rotate-b.png" alt="Before rotation" width="auto">
</td><td>
<img src="/screen-shots/lab08/rotate-a.png" alt="After rotation" width="100%">
</td></tr>
<tr>
<th>Before rotation</th>
<th>After rotation</th>
</tr>
</table>



## Scaling

Scaling an object is done by using `glScalef(x, y, z)`. This method accepts three floating point parameters, using which we specify the scale factors along the x, y, and z axes respectively.

```java
glScalef(float x, float y float z)
```

### Example
```java
gl.glScalef(0.5f, 0.5f, 0.5f);
```

### Sample Run

<table><tr><td>
<img src="/screen-shots/lab08/scale-b.png" alt="Before scaling" width="auto">
</td><td>
<img src="/screen-shots/lab08/scale-a.png" alt="After scaling" width="100%">
</td></tr>
<tr>
<th>Before scaling</th>
<th>After scaling</th>
</tr>
</table>