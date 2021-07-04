# Digital Differential Analyzer Line Algorithm 
Digital differential analyzer (DDA) is used for linear interpolation of variables over an interval between given start, end points and for rasterization of lines, triangles and polygons. Using DDA Algorithm, Write a C-Program to draw a line segment between two given points? DDA algorithm is an incremental scan conversion method. Here we perform calculations at each step using the results from the preceding step. The characteristic of the DDA algorithm is to take unit steps along one coordinate and compute the corresponding values along the other coordinate. The unit steps are always along the coordinate of greatest change, e.g. if `dx = 10` and `dy = 5`, then we would take unit steps along `x` and compute the steps along `y`.

In DDA we need to consider two cases; One is slope of the line less than or equal to one (|m| &le; 1) and slope of the line greater than one (|m| &gt; 1).

## Sample Run
