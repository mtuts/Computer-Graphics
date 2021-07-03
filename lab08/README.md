# 3D Transormation

Applying different type of transformations such rtation, translation, and scaling.

## Translation

`glTranslate()` method moves origin of the coordinate system to the point specified by the parameters (*x, y, z*), passed to `glTranslate()` method as argument. In order to save and restore the untranslated coordinate system: `glPushMatrix()` and `glPopMatrix()` methods are used.

```java
glTranslatef(float x, float y float z)
```

### Example
```java
gl.glTranslatef(1.5f, 1.5f, -6.0f);
```

### Sample Run

<table><tr><td>
<img src="/images/lab08/translate-b.png" alt="Before translation" width="auto">
</td><td>
<img src="/images/lab08/translate-a.png" alt="After translation" width="100%">
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
<img src="/images/lab08/rotate-b.png" alt="Before rotation" width="auto">
</td><td>
<img src="/images/lab08/rotate-a.png" alt="After rotation" width="100%">
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
<img src="/images/lab08/scale-b.png" alt="Before scaling" width="auto">
</td><td>
<img src="/images/lab08/scale-a.png" alt="After scaling" width="100%">
</td></tr>
<tr>
<th>Before scaling</th>
<th>After scaling</th>
</tr>
</table>