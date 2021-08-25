package io.anthonygraca.princeton.chapter2.CollinearPoints;

public class FastCollinearPoints {
  public FastCollinearPoints(Point[] points) {
    if (checkIfNull(points) || checkRepeated(points)) {
      throw new IllegalArgumentException("Invalid Input");
    }
    //m_segments = findLineSegmentsContainingFourPoints(points);
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

}
