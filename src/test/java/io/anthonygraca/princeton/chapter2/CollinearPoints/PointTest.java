package io.anthonygraca.princeton.chapter2.CollinearPoints;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PointTest {
  @Test
  public void compareStrictlyLessThan() {
    Point pointA = new Point(0,0);
    Point pointB = new Point(1,1);
    assertTrue(pointA.compareTo(pointB) < 0);
  }

  @Test
  public void compareEqualPoints() {
    Point pointA = new Point(0,0);
    Point pointB = new Point(0,0);
    assertTrue(pointA.compareTo(pointB) == 0);
  }

  @Test
  public void compareStrictlyGreaterThan() {
    Point pointA = new Point(1,1);
    Point pointB = new Point(0,0);
    assertTrue(pointA.compareTo(pointB) > 0);
  }
}
