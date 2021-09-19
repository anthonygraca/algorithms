package io.anthonygraca.princeton.chapter2.KdTree;

/*
 * Write a data type to represent a set of points in the unit square (all 
 * points have x- and y-coordinates between 0 and 1) using a 2d-tree to 
 * support efficient range search (find all of the points contained in a query 
 * rectangle) and nearest-neighbor search (find a closest point to a query 
 * point). 2d-trees have numerous applications, ranging from classifying 
 * astronomical objects to computer animation to speeding up neural networks 
 * to mining data to image retrieval.
 */
public class PointSET {
  boolean isEmpty() {
    return size() == 0;
  }

  int size() {
    return 0;
  }
}
