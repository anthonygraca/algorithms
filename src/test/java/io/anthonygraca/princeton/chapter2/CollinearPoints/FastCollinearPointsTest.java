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
    assertEquals(algo.numberOfSegments(), 0);
  }

  //  The method segments() should include each maximal line segment containing 
  //  4 (or more) points exactly once. For example, if 5 points appear on a 
  //  line segment in the order p→q→r→s→t, then do not include the subsegments 
  //  p→s or q→t.
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

  @Test
  public void verifySingleValidLineSegmentCountFromManyPoints() {
    Point[] points = {new Point(1,1), new Point(1,2), 
                      new Point(1,3), new Point(1,4), new Point(2,5)};
    FastCollinearPoints algo = new FastCollinearPoints(points);
    assertEquals(algo.numberOfSegments(), 1);
  }

  @Test
  public void verifySingleValidLineSegmentFromManyPoints() {
    Point[] points = {new Point(1,1), new Point(1,2), 
                      new Point(1,3), new Point(1,4), new Point(2,5)};
    FastCollinearPoints algo = new FastCollinearPoints(points);
    assertEquals(algo.segments()[0].toString(), "(1, 1) -> (1, 4)");
  }

  @Test
  public void verifyInputSet8() {
    Point[] points = {new Point(10000,0), new Point(0,10000), 
                      new Point(3000,7000), new Point(7000,3000), 
                      new Point(20000,21000), new Point(3000, 4000),
                      new Point(14000,15000), new Point(6000, 7000)};
    FastCollinearPoints algo = new FastCollinearPoints(points);
    assertEquals(algo.numberOfSegments(), 2);
    assertEquals(algo.segments()[0].toString(), "(10000, 0) -> (0, 10000)");
    assertEquals(algo.segments()[1].toString(), "(3000, 4000) -> (20000, 21000)");
  }

  @Test
  public void verifyInputSetEquidistant() {
    Point[] points = {new Point(10000,0), new Point(8000,2000), 
                      new Point(2000,8000), new Point(0,10000), 
                      new Point(20000,0), new Point(18000, 2000),
                      new Point(2000,18000), new Point(10000, 20000),
                      new Point(30000,0), new Point(0, 30000),
                      new Point(20000,10000), new Point(13000, 0),
                      new Point(11000,3000), new Point(5000, 12000),
                      new Point(9000,6000)};
    FastCollinearPoints algo = new FastCollinearPoints(points);
    assertEquals(algo.numberOfSegments(), 4);
    assertEquals(algo.segments()[0].toString(), "(10000, 0) -> (0, 10000)");
    assertEquals(algo.segments()[1].toString(), "(10000, 0) -> (30000, 0)");
    assertEquals(algo.segments()[2].toString(), "(13000, 0) -> (5000, 12000)");
    assertEquals(algo.segments()[3].toString(), "(30000, 0) -> (0, 30000)");
  }

  @Test
  public void verifyVertical() {
    Point[] points = {new Point(10000,0), 
                      new Point(20000,0),
                      new Point(30000,0), 
                      new Point(13000, 0)};
    FastCollinearPoints algo = new FastCollinearPoints(points);
    assertEquals(algo.numberOfSegments(), 1);
    assertEquals(algo.segments()[0].toString(), "(10000, 0) -> (30000, 0)");
  }
}
