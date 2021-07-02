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

{% include image.html url="/screen-shots/lab08/translate-b.png" description="Before translation" %}
{% include image.html url="/screen-shots/lab08/translate-a.png" description="After translation" %}
