package io.anthonygraca.princeton.chapter2.CollinearPoints;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PointTest {
  @Test
  public void compareStrictlyLessThan() {
    Point pointA = new Point(0,0);
    Point pointB = new Point(1,1);
    assertTrue(pointA.compareTo(pointB) < 0);
  }

  @Test
  public void compareLessThanOnlyY() {
    Point pointA = new Point(0,0);
    Point pointB = new Point(0,1);
    assertTrue(pointA.compareTo(pointB) < 0);
  }

  @Test
  public void compareLessThanOnlyYGreaterX() {
    Point pointA = new Point(1,0);
    Point pointB = new Point(0,1);
    assertTrue(pointA.compareTo(pointB) < 0);
  }

  @Test
  public void compareEqualPoints() {
    Point pointA = new Point(0,0);
    Point pointB = new Point(0,0);
    assertTrue(pointA.compareTo(pointB) == 0);
  }

  @Test
  public void compareEqualYGreaterX() {
    Point pointA = new Point(1,0);
    Point pointB = new Point(0,0);
    assertTrue(pointA.compareTo(pointB) > 0);
  }

  @Test
  public void compareEqualYLessX() {
    Point pointA = new Point(0,0);
    Point pointB = new Point(1,0);
    assertTrue(pointA.compareTo(pointB) < 0);
  }

  @Test
  public void compareStrictlyGreaterThan() {
    Point pointA = new Point(1,1);
    Point pointB = new Point(0,0);
    assertTrue(pointA.compareTo(pointB) > 0);
  }

  @Test
  public void compareGreaterYEqualX() {
    Point pointA = new Point(1,1);
    Point pointB = new Point(1,0);
    assertTrue(pointA.compareTo(pointB) > 0);
  }

  @Test
  public void compareGreaterYLeserX() {
    Point pointA = new Point(0,1);
    Point pointB = new Point(1,0);
    assertTrue(pointA.compareTo(pointB) > 0);
  }
/*
 * The slopeTo() method should return the slope between the invoking point 
 * (x0, y0) and the argument point (x1, y1), which is given by the formula 
 * (y1 − y0) / (x1 − x0). Treat the slope of a horizontal line segment as 
 * positive zero; treat the slope of a vertical line segment as positive 
 * infinity; treat the slope of a degenerate line segment (between a point and 
 * itself) as negative infinity.
 */
  @Test
  public void givesSlopeOfVerticalLine() {
    int x0 = 0, y0 = 0;
    int x1 = 0, y1 = 1;
    Point pointA = new Point(x0, y0);
    Point pointB = new Point(x1, y1);
    assertEquals(pointA.slopeTo(pointB), Double.POSITIVE_INFINITY, 0.1);
  }

  @Test
  public void givesSlopeOfHorizontalLine() {
    int x0 = 0, y0 = 0;
    int x1 = 1, y1 = 0;
    Point pointA = new Point(x0, y0);
    Point pointB = new Point(x1, y1);
    double expected = (double)(y1 - y0)/(x1 - x0);
    assertEquals(pointA.slopeTo(pointB), expected, 0.1);
  }

  @Test
  public void givesSlopeOfArbitraryPoints() {
    int x0 = 3, y0 = 7;
    int x1 = -1, y1 = 11;
    Point pointA = new Point(x0, y0);
    Point pointB = new Point(x1, y1);
    double expected = (double)(y1 - y0)/(x1 - x0);
    assertEquals(pointA.slopeTo(pointB), expected, 0.1);
  }

  @Test
  public void givesSlopeOfArbitraryPointsIntegerDivision() {
    int x0 = 3, y0 = 7;
    int x1 = -1, y1 = 10;
    Point pointA = new Point(x0, y0);
    Point pointB = new Point(x1, y1);
    double expected = (double)(y1 - y0)/(x1 - x0);
    assertEquals(pointA.slopeTo(pointB), expected, 0.1);
  }

  @Test
  public void givesSlopeOfDegenerativeLineSegment() {
    int x0 = 0, y0 = 0;
    int x1 = 0, y1 = 0;
    Point pointA = new Point(x0, y0);
    Point pointB = new Point(x1, y1);
    assertEquals(pointA.slopeTo(pointB), Double.NEGATIVE_INFINITY, 0.1);
  }
}

