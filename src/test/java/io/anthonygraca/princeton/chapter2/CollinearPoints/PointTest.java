package io.anthonygraca.princeton.chapter2.CollinearPoints;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ComparePointTest {
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
}
