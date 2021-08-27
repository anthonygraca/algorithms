package io.anthonygraca.princeton.chapter2.CollinearPoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FastCollinearPoints {
  private ArrayList<LineSegment> m_segments = new ArrayList<LineSegment>();
  public FastCollinearPoints(Point[] points) {
    if (checkIfNull(points) || checkRepeated(points)) {
      throw new IllegalArgumentException("Invalid Input");
    }
    if (points.length >= 4) {
      m_segments = findLineSegments(points);
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
  private ArrayList<LineSegment> findLineSegments(Point[] points) {
    Point[] sorted_by_slope_order = Arrays.copyOf(points, points.length);
    Point[] sorted_by_nominal_order = Arrays.copyOf(points, points.length);
    Arrays.sort(sorted_by_nominal_order);
    for (int i = 0; i < sorted_by_nominal_order.length; ++i) {
      Point origin = sorted_by_nominal_order[i];
      // take advantage of stability in sorting algorithm
      Arrays.sort(sorted_by_slope_order); 
      Arrays.sort(sorted_by_slope_order, origin.slopeOrder());
      int count = 1;
      Point lineBeginning = null;
      for (int j = 0; j < sorted_by_slope_order.length-1; ++j) {
        if (sorted_by_slope_order[j].slopeTo(origin) == 
            sorted_by_slope_order[j+1].slopeTo(origin)) {
          count++;
          if (count == 2) {
            lineBeginning = sorted_by_slope_order[j];
            count++;
          }
          else if (count >= 4 && j + 1 == sorted_by_slope_order.length - 1) {
            if (lineBeginning.compareTo(origin) > 0) {
              m_segments.add(
                  new LineSegment(origin, sorted_by_slope_order[j+1]));
            }
            count = 1;
          }
        }
        else if (count >= 4) {
          if (lineBeginning.compareTo(origin) > 0) {
            m_segments.add(new LineSegment(origin, sorted_by_slope_order[j]));
          }
          count = 1;
        }
        else {
          count = 1;
        }
      }
    }
    return m_segments;
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
