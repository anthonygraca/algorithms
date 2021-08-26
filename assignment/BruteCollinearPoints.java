import java.util.ArrayList;

public class BruteCollinearPoints {
  private ArrayList<LineSegment> m_segments = new ArrayList<LineSegment>();
  public BruteCollinearPoints(Point[] points) {
    if (checkIfNull(points) || checkRepeated(points)) {
      throw new IllegalArgumentException("Invalid Input");
    }
    m_segments = findLineSegmentsContainingFourPoints(points);
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

/*
 * Brute force. Write a program BruteCollinearPoints.java that examines 4 
 * points at a time and checks whether they all lie on the same line segment, 
 * returning all such line segments. To check whether the 4 points p, q, r, 
 * and s are collinear, check whether the three slopes between p and q, 
 * between p and r, and between p and s are all equal.
 */
  private ArrayList<LineSegment> findLineSegmentsContainingFourPoints(Point[] points) {
    for (int p = 0; p < points.length-3; p++) {
      for (int q = p+1; q < points.length-2; q++) {
        for (int r = q+1; r < points.length-1; r++) {
          for (int s = r+1; s < points.length; s++) {
            double slopePQ = points[p].slopeTo(points[q]);
            double slopePR = points[p].slopeTo(points[r]);
            double slopePS = points[p].slopeTo(points[s]);
            if (slopePQ == slopePR && slopePR == slopePS) {
              m_segments.add(new LineSegment(points[p], points[s]));
            }
          }
        }
      }
    }
    return m_segments;
  }

/*
  The method segments() should include each line segment containing 4 points 
  exactly once. If 4 points appear on a line segment in the order p→q→r→s, 
  then you should include either the line segment p→s or s→p (but not both) 
  and you should not include subsegments such as p→r or q→r. For simplicity, 
  we will not supply any input to BruteCollinearPoints that has 5 or more 
  collinear points.
*/
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
