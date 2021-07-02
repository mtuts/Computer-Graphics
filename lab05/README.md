# Bresenham's Line Drawing Algorithm

Bresenham's line algorithm is an algorithm which determines which order to form a close approximation to a straight line between two given points. Write a C program for determining pixel activation list between two given points in order to draw line segment using Bresenham's Line drawing algorithm.

1. Input the two line end-points, storing the left end-point in (x<sub>0</sub>, y<sub>0</sub>)
2. Plot the point (x<sub>0</sub>, y<sub>0</sub>)
3. Calculate the constants &#8710;x, &#8710;y, 2&#8710;y, and (2&#8710;y - 2&#8710;x) and get the first value for the decision
parameter as:
P<sub>0</sub> = 2&#8710;y - &#8710;x
4. At each x<sub>k</sub> along the line, starting at k = 0, perform the following test. If p<sub>k</sub> < 0, the next point to plot is (x<sub>k+1</sub>, y<sub>k</sub> ) and:
P<sub>k+1</sub> = P<sub>k</sub> + 2&#8710;y
Otherwise, the next point to plot is (x<sub>k+1</sub>, y<sub>k+1</sub>) and:
P<sub>k+1</sub> = P<sub>k</sub> + 2&#8710;y - 2&#8710;x
5. Repeat step 4 (&#8710;x - 1) times..
NOTE: The algorithm and derivation above assumes slopes are less than 1. For other slopes we need to adjust the algorithm slightly

## Sample Run

```
Enter X1 Y1
16 30
Enter X2 Y2
140 88
```

![Applet Bresenham's Line Drawing Algorithm](/screen-shots/lab05/bld.png)