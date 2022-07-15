package io.anthonygraca.princeton.chapter2.KdTree;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;

import java.util.Iterator;
import java.util.ArrayList;

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
  private SET<Point2D> set = null;

  public PointSET() {
    set = new SET<Point2D>();
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public int size() {
    return set.size();
  }

  // Should be T:O(log n)
  public void insert(Point2D p) {
    if (p == null) throw new IllegalArgumentException("input is null");
    if (!set.contains(p)) set.add(p);
  }

  // Should be T:O(log n)
  public boolean contains(Point2D p) {
    if (p == null) throw new IllegalArgumentException("input is null");
    return set.contains(p);
  }

  // Should be T:O(n)
  public Point2D nearest(Point2D p) {
    if (p == null) throw new IllegalArgumentException("input is null");
    Point2D neighbor = null;
    double distance = Double.MAX_VALUE;
    for (Point2D point : set) {
      if (distance > point.distanceTo(p)) {
        distance = point.distanceTo(p);
        neighbor = point;
      }
    }
    return neighbor;
  }

  // Should be T:O(n)
  public Iterable<Point2D> range(RectHV rect) {
    if (rect == null) throw new IllegalArgumentException("input is null");
    ArrayList<Point2D> list = new ArrayList<Point2D>();
    for (Point2D p : set) {
      if (rect.contains(p)) {
        list.add(p);
      }
    }
    return list;
  }

  public void draw() {}
}
