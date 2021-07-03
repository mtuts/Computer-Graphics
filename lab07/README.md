# Midpoint Circle Algorithm

Circles have the property of being highly symmetrical, which is handy when it comes to drawing them on a display screen.
- We know that there are 360 degrees in a circle. First we see that a circle is symmetrical about the x axis, so only the first 180 degrees need to be calculated.
- Next we see that it's also symmetrical about the y axis, so now we only need to calculate the first 90 degrees.
- Finally we see that the circle is also symmetrical about the 45 degree diagonal axis, so we only need to calculate the first 45 degrees.
- We only need to calculate the values on the border of the circle in the first octant. The other values may be determined by symmetry.

## Algorithm steps
Given the circle's raduis *R*
1. Put x<sub>0</sub> = 0; y<sub>0</sub> = *round*(*R*)
1. Calculate *h*<sub>0</sub> = 1 - y<sub>0</sub>
1. first pixel (x<sub>0</sub>, y<sub>0</sub>)
1. Sample *x* with step &#8710;x = 1 (i.e. *x* = {*x*<sub>0</sub>, *x*<sub>0</sub> + 1, *x*<sub>0</sub> + 2, ..., *round*(*R* sin(45))})
1. Calculate each succeeding y value as:
    1. *y*<sub>k + 1</sub> = *y*<sub>k</sub> if *h*<sub>k</sub> < 0 (*h*<sub>k + 1</sub> = *d*<sub>k</sub> + 2x<sub>k</sub> + 3)
    1. *y*<sub>k + 1</sub> = *y*<sub>k</sub> - 1 if *h*<sub>k</sub> > 0 (*h*<sub>k + 1</sub> = *h*<sub>k</sub> + 2x<sub>k</sub> - 2y<sub>k</sub> + 5)

## Sample Run

```
Enter circle center point X Y
100 100
Enter Radius
70
```

![Applet Midpoint Circle Algorithm](/images/lab07/mca.png)
