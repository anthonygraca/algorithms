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
  private ArrayList<LineSegment> findLineSegmentsContainingFourPoints(Point[] points) {
    Point[] copy = new Point[points.length];
    for (int i = 0; i < points.length; i++) {
      copy[i] = points[i];
    }
    for (int p = 0; p < points.length; p++) {
      Arrays.sort(copy, p, copy.length, points[p].slopeOrder());
      int start = 1;
      int end = 1;
      Point point = points[p];
      while (start < points.length && end+1 < points.length) {
        double start_slope = point.slopeTo(copy[start]);
        double end_slope = point.slopeTo(copy[end+1]);
        if (start_slope == end_slope) {
          end++;
        }
        else {
          addLineSegment(start, end, copy, point);
          start = end+1;
        }
      }
      addLineSegment(start, end, copy, point);
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

  private Comparator<Point> bestOrder(Point p) {
    return new ByBestOrder(p);
  }

  private class ByBestOrder implements Comparator<Point> {
    Point p;
    public ByBestOrder(Point p) {
      this.p = p;
    }
    public int compare(Point x, Point y) {
      double slopeToX = this.p.slopeTo(x);
      double slopeToY = this.p.slopeTo(y);
      if (slopeToX != slopeToY) return 1;
      return 0;
    }
  }

  private void addLineSegment(int start, int end, Point[] copy, Point p) {
    Point[] collinear = new Point[end-start+2];
    collinear[0] = p;
    for (int i = start, j = 1; i <= end; i++, j++) {
      collinear[j] = copy[i];
    }
    if (end - start >= 2) {
      Arrays.sort(collinear);
      if (p == collinear[0] || p == collinear[collinear.length-1])
        m_segments.add(new LineSegment(collinear[0], collinear[collinear.length-1]));
    }
  }

}
