# Midpoint Line Algorithm

## Algorithm steps
Given two points (start and end points) (x<sub>0</sub> , y<sub>0</sub> ) , (x<sub>1</sub>, y<sub>1</sub>)
1. Calculate &#8710;*NE* = 2&#8710;y - 2&#8710;x, &#8710;*E* = 2&#8710;y, *d*<sub>0</sub> 2&#8710;y - &#8710;x
1. first pixel (*round*(x<sub>0</sub>), *round*(y<sub>0))
1. *x*<sub>0</sub> &larr; (*round*(x<sub>0</sub>), *round*(y<sub>0</sub>))
1. Sample *x* with step &#8710;*x* = 1 (i.e. *x* = {*x*<sub>0</sub>, *x*<sub>0</sub> + 1, *x*<sub>0</sub> + 2, ..., *x*<sub>1</sub>})
1. Calculate each succeeding y value as:
    1. *y*<sub>k + 1</sub> = *y*<sub>k</sub> if *d*<sub>k</sub> < 0 (*d*<sub>k + 1</sub> = *d*<sub>k</sub> + 2&#8710;*E*)
    1. *y*<sub>k + 1</sub> = *y*<sub>k</sub> + 1 if *d*<sub>k</sub> > 0 (*d*<sub>k + 1</sub> = *d*<sub>k</sub> + 2&#8710;*NE*)

## Sample Run

```
Enter X1 Y1
50 40
Enter X2 Y2
178 279
```

![Applet Midpoint Line Algorithm](/screen-shots/lab06/mla.png)
