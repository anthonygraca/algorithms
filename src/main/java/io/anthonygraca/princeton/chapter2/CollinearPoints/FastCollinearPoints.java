package io.anthonygraca.princeton.chapter2.CollinearPoints;

import java.util.ArrayList;
import java.util.Comparator;

public class FastCollinearPoints {
  ArrayList<LineSegment> m_segments = new ArrayList<LineSegment>();
  public FastCollinearPoints(Point[] points) {
    if (checkIfNull(points) || checkRepeated(points)) {
      throw new IllegalArgumentException("Invalid Input");
    }
    if (points.length >= 4) {
      m_segments = findLineSegmentsContainingFourPoints(points);
    }
  }

  private boolean checkIfNull(Point[] points) {
    if (points == null) {
      return true;
    }
    for (Point point : points) {
      if (point == null) {
        return true;
      }
    }
    return false;
  }

  private boolean checkRepeated(Point[] points) {
    for (int i = 0; i < points.length; i++) {
      for (int j = i+1; j < points.length; j++) {
        if (points[i].compareTo(points[j]) == 0) {
          return true;
        }
      }
    }
    return false;
  }

  // should be T(n^2 * logn) and S(n)
  /*
   * A faster, sorting-based solution. Remarkably, it is possible to solve the 
   * problem much faster than the brute-force solution described above. Given 
   * a point p, the following method determines whether p participates in a 
   * set of 4 or more collinear points.
   *
   *  @ Think of p as the origin.
   *  @ For each other point q, determine the slope it makes with p.
   *  @ Sort the points according to the slopes they makes with p.
   *  @ Check if any 3 (or more) adjacent points in the sorted order have equal 
   *    slopes with respect to p. If so, these points, together with p, are 
   *    collinear.
   *
   *  Applying this method for each of the n points in turn yields an 
   *  efficient algorithm to the problem. The algorithm solves the problem 
   *  because points that have equal slopes with respect to p are collinear, 
   *  and sorting brings such points together. The algorithm is fast because 
   *  the bottleneck operation is sorting.
   */
  private ArrayList<LineSegment> 
    findLineSegmentsContainingFourPoints(Point[] points) {
    for (int p = 0; p < points.length; p++) {
      ArrayList<Point> slope_order = new ArrayList<Point>();
      for (int q = p+1; q  < points.length; q++) {
        slope_order.add(points[q]);
      }
      slope_order.sort(points[p].slopeOrder());
      findAdjacentPoints(points[p], slope_order);
    }
    return m_segments;
  }

  private void findAdjacentPoints(Point p, ArrayList<Point> a) {
    if (a.size() >= 3) {
      if (p.slopeTo(a.get(2)) == p.slopeTo(a.get(1))) {
        m_segments.add(new LineSegment(p, a.get(2)));
      }
    }
  }

  public LineSegment[] segments() {
    LineSegment[] line_segments = new LineSegment[m_segments.size()];
    for (int i = 0; i < m_segments.size(); i++) {
      line_segments[i] = m_segments.get(i);
    }
    return line_segments;
  }

  public int numberOfSegments() {
    return m_segments.size();
  }
}
