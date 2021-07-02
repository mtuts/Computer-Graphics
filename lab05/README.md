# Bresenham’s Line Drawing Algorithm

Bresenham’s line algorithm is an algorithm which determines which order to form a close approximation to a straight line between two given points. Write a C program for determining pixel activation list between two given points in order to draw line segment using Bresenham’s Line drawing algorithm.

h<sub>&theta;</sub>(x) = &theta;<sub>o</sub> x + &theta;<sub>1</sub>x

1. Input the two line end-points, storing the left end-point in (x<sub>0</sub>, y<sub>0</sub>)
2. Plot the point $(x<sub>0</sub>, y<sub>0</sub>)
3. Calculate the constants &delta;x, ?y, 2?y, and (2?y - 2?x) and get the first value for the decision
parameter as:
P0 = 2? y - ? x
4. At each xk along the line, starting at k = 0, perform the following test. If pk < 0, the next point to plot
is (xk+1, yk ) and:
Pk+1 = Pk + 2? y
Otherwise, the next point to plot is (xk+1, y k+1) and:
Pk+1 = Pk + 2? y - 2?x
5. Repeat step 4 (?x – 1) times
NOTE: The algorithm and derivation above assumes slopes are less than 1. For other slopes we need
to adjust the algorithm slightly

## Sample Run

```
Enter X1 Y1
16 30
Enter X2 Y2
140 88
```

![Applet Bresenham's Line Drawing Algorithm](/screen-shots/lab05/bld.png)