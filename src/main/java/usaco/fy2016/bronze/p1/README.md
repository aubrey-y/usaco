# USACO 2016 US Open Contest, Bronze

### [Problem 1. Diamond Collector](http://www.usaco.org/index.php?page=viewproblem2&cpid=639)

![](results.PNG)

Nothing too complicated here. Although it feels like a sin, the only way to arrive at an accurate solution I could come
up with is semi-optimized brute-force, because in the worst case scenario, starting at every single index of a sorted
array could yield a different answer. So we have to try every index.

#### Time Complexity

Probably ~ `n^2` :(
