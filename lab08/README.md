# 3D Transormation

Appling different type of transformations such rtation, translation, and scaling.

## Translation

`glTranslate()` method moves origin of the coordinate system to the point specified by the parameters (*x, y, z*), passed to `glTranslate()` method as argument. In order to save and restore the untranslated coordinate system: `glPushMatrix()` and `glPopMatrix()` methods are used.

`glTranslatef(float x, float y float z)`

### Example
```java
    gl.glTranslatef(1.5f, 1.5f, -6.0f);
```

### Sample Run
# 3D Transormation

Appling different type of transformations such rtation, translation, and scaling.

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
<img src="/screen-shots/lab08/translate-b.png" alt="Before translation" width="auto">
</td><td>
<img src="/screen-shots/lab08/translate-a.png" alt="After translation" width="100%">
</td></tr>
<tr>
<th>Before translation<br>
```java
gl.glTranslatef(0.0f, 0.0f, -6.5f);
```
</th>
<th>After translation</th>
</tr>
</table>