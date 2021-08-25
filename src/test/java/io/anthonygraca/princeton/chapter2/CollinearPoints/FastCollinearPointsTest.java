package io.anthonygraca.princeton.chapter2.CollinearPoints;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FastCollinearPointsTest {
  @Test(expected=IllegalArgumentException.class)
  public void handleNullArgumentInConstructor() {
    FastCollinearPoints algo = new FastCollinearPoints(null);
  }

  @Test(expected=IllegalArgumentException.class)
  public void handleNullPointInConstructor() {
    Point[] points = {null};
    FastCollinearPoints algo = new FastCollinearPoints(points);
  }

  @Test(expected=IllegalArgumentException.class)
  public void handleNullPointAnywhereInConstructor() {
    Point[] points = {new Point(1,1), null, new Point(1,2)};
    FastCollinearPoints algo = new FastCollinearPoints(points);
  }

  @Test(expected=IllegalArgumentException.class)
  public void handleRepeatedPointInConstructor() {
    Point[] points = {new Point(1,1), new Point(1,1)};
    FastCollinearPoints algo = new FastCollinearPoints(points);
  }

  @Test
  public void verifyCollinearPointsIncreaseNumberOfLineSegments() {
    Point[] points = {new Point(1,1), new Point(1,2), 
                      new Point(1,3), new Point(1,4)};
    FastCollinearPoints algo = new FastCollinearPoints(points);
    assertEquals(algo.numberOfSegments(), 1);
  }

  @Test
  public void verifyValidLineSegment() {
    Point[] points = {new Point(1,1), new Point(1,2), 
                      new Point(1,3), new Point(1,4)};
    FastCollinearPoints algo = new FastCollinearPoints(points);
    assertEquals(algo.segments()[0].toString(), "(1, 1) -> (1, 4)");
  }

  @Test
  public void verifyNonCollinearPointsDoesNotIncreaseNumberOfLineSegments() {
    Point[] points = {new Point(1,1), new Point(1,2), 
                      new Point(1,3), new Point(2,4)};
    FastCollinearPoints algo = new FastCollinearPoints(points);
    assertTrue(algo.numberOfSegments() == 0);
  }

  /*
   * For Points A, B, C, D, E
   *
   * There are 5 ways to choose them:
   * A,B,C,D aka (1,1) -> (1,4)
   * A,B,C,E aka (1,1) -> (1,5)
   * A,B,D,E aka (1,1) -> (1,5)
   * A,C,D,E aka (1,1) -> (1,5)
   * B,C,D,E aka (1,2) -> (1,5)
   *
   * The method segments() should include each maximal line segment containing 
   * 4 (or more) points exactly once. For example, if 5 points appear on a 
   * line segment in the order p→q→r→s→t, then do not include the subsegments 
   * p→s or q→t.
   */
  /*
  @Test
  public void verifyMultipleValidLineSegments() {
    Point[] points = {new Point(1,1), new Point(1,2), 
                      new Point(1,3), new Point(1,4), new Point(1,5)};
    FastCollinearPoints algo = new FastCollinearPoints(points);
    assertEquals(algo.segments()[0].toString(), "(1, 1) -> (1, 5)");
  }

  @Test
  public void verifyMultipleCollinearPoints() {
    Point[] points = {new Point(1,1), new Point(1,2), 
                      new Point(1,3), new Point(1,4), new Point(1,5)};
    FastCollinearPoints algo = new FastCollinearPoints(points);
    assertEquals(algo.numberOfSegments(), 1);
  }
  */

  @Test
  public void verifySingleValidLineSegmentCountFromManyPoints() {
    Point[] points = {new Point(1,1), new Point(1,2), 
                      new Point(1,3), new Point(1,4), new Point(2,5)};
    FastCollinearPoints algo = new FastCollinearPoints(points);
    assertTrue(algo.numberOfSegments() == 1);
  }

  @Test
  public void verifySingleValidLineSegmentFromManyPoints() {
    Point[] points = {new Point(1,1), new Point(1,2), 
                      new Point(1,3), new Point(1,4), new Point(2,5)};
    FastCollinearPoints algo = new FastCollinearPoints(points);
    assertEquals(algo.segments()[0].toString(), "(1, 1) -> (1, 4)");
  }
}
