package io.anthonygraca.princeton.chapter2.CollinearPoints;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BruteCollinearPointsTest {
  @Test(expected=IllegalArgumentException.class)
  public void handleNullArgumentInConstructor() {
    BruteCollinearPoints algo = new BruteCollinearPoints(null);
  }

  @Test(expected=IllegalArgumentException.class)
  public void handleNullPointInConstructor() {
    Point[] points = {null};
    BruteCollinearPoints algo = new BruteCollinearPoints(points);
  }

  @Test(expected=IllegalArgumentException.class)
  public void handleNullPointAnywhereInConstructor() {
    Point[] points = {new Point(1,1), null, new Point(1,2)};
    BruteCollinearPoints algo = new BruteCollinearPoints(points);
  }

  @Test(expected=IllegalArgumentException.class)
  public void handleRepeatedPointInConstructor() {
    Point[] points = {new Point(1,1), new Point(1,1)};
    BruteCollinearPoints algo = new BruteCollinearPoints(points);
  }

  @Test
  public void verifyCollinearPointsIncreaseNumberOfLineSegments() {
    Point[] points = {new Point(1,1), new Point(1,2), 
                      new Point(1,3), new Point(1,4)};
    BruteCollinearPoints algo = new BruteCollinearPoints(points);
    assertTrue(algo.numberOfSegments() == 1);
  }

  @Test
  public void verifyValidLineSegment() {
    Point[] points = {new Point(1,1), new Point(1,2), 
                      new Point(1,3), new Point(1,4)};
    BruteCollinearPoints algo = new BruteCollinearPoints(points);
    assertEquals(algo.segments()[0].toString(), "(1, 1) -> (1, 4)");
  }

  @Test
  public void verifyNonCollinearPointsDoesNotIncreaseNumberOfLineSegments() {
    Point[] points = {new Point(1,1), new Point(1,2), 
                      new Point(1,3), new Point(2,4)};
    BruteCollinearPoints algo = new BruteCollinearPoints(points);
    assertTrue(algo.numberOfSegments() == 0);
  }

  @Test
  public void verifyMultipleCollinearPoints() {
    Point[] points = {new Point(1,1), new Point(1,2), 
                      new Point(1,3), new Point(1,4), new Point(1,5)};
    BruteCollinearPoints algo = new BruteCollinearPoints(points);
    assertTrue(algo.numberOfSegments() == 5);
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
   */
  @Test
  public void verifyMultipleValidLineSegments() {
    Point[] points = {new Point(1,1), new Point(1,2), 
                      new Point(1,3), new Point(1,4), new Point(1,5)};
    BruteCollinearPoints algo = new BruteCollinearPoints(points);
    assertEquals(algo.segments()[0].toString(), "(1, 1) -> (1, 4)");
    assertEquals(algo.segments()[1].toString(), "(1, 1) -> (1, 5)");
    assertEquals(algo.segments()[2].toString(), "(1, 1) -> (1, 5)");
    assertEquals(algo.segments()[3].toString(), "(1, 1) -> (1, 5)");
    assertEquals(algo.segments()[4].toString(), "(1, 2) -> (1, 5)");
  }

  @Test
  public void verifySingleValidLineSegmentCountFromManyPoints() {
    Point[] points = {new Point(1,1), new Point(1,2), 
                      new Point(1,3), new Point(1,4), new Point(2,5)};
    BruteCollinearPoints algo = new BruteCollinearPoints(points);
    assertTrue(algo.numberOfSegments() == 1);
  }

  @Test
  public void verifySingleValidLineSegmentFromManyPoints() {
    Point[] points = {new Point(1,1), new Point(1,2), 
                      new Point(1,3), new Point(1,4), new Point(2,5)};
    BruteCollinearPoints algo = new BruteCollinearPoints(points);
    assertEquals(algo.segments()[0].toString(), "(1, 1) -> (1, 4)");
  }
}
