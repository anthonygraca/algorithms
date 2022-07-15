package io.anthonygraca.princeton.chapter2.KdTree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

public class PointSetTest {
  @Test
  public void constructedObjectIsEmpty() {
    PointSET set = new PointSET();
    assertTrue(set.isEmpty());
  }

  @Test
  public void constructedObjectSizeIsZero() {
    PointSET set = new PointSET();
    assertEquals(0, set.size());
  }

  @Test(expected=IllegalArgumentException.class)
  public void insertHandlesNull() {
    PointSET set = new PointSET();
    set.insert(null);
  }

  @Test
  public void emptySetDoesNotContainAnything() {
    PointSET set = new PointSET();
    Point2D some_point = new Point2D(1,2);
    assertFalse(set.contains(some_point));
  }

  @Test(expected=IllegalArgumentException.class)
  public void containHandlesNull() {
    PointSET set = new PointSET();
    assertFalse(set.contains(null));
  }

  @Test
  public void nearestReturnsNullWhenSetIsEmpty() {
    PointSET set = new PointSET();
    Point2D some_point = new Point2D(1,2);
    assertEquals(null, set.nearest(some_point));
  }

  @Test(expected=IllegalArgumentException.class)
  public void nearestHandlesNull() {
    PointSET set = new PointSET();
    set.nearest(null);
  }

  @Test(expected=IllegalArgumentException.class)
  public void rangeHandlesNull() {
    PointSET set = new PointSET();
    set.range(null);
  }

  @Test
  public void insertSomePointIntoSet() {
    PointSET set = new PointSET();
    Point2D some_point = new Point2D(1,2);
    set.insert(some_point);
    assertTrue(set.contains(some_point));
  }

  @Test
  public void insertShouldIncrementSize() {
    PointSET set = new PointSET();
    Point2D some_point = new Point2D(1,2);
    set.insert(some_point);
    assertTrue(set.size() != 0);
  }

  @Test
  public void nearestNeighbor() {
    PointSET set = new PointSET();
    Point2D some_point = new Point2D(1,2);
    set.insert(some_point);
    Point2D neighbor = new Point2D(1,1);
    assertEquals(some_point, set.nearest(neighbor));
  }

  
  @Test
  public void nearestNeighborOfSquare() {
    PointSET set = new PointSET();
    Point2D a = new Point2D(0,0);
    Point2D b = new Point2D(0,5);
    Point2D c = new Point2D(5,0);
    Point2D d = new Point2D(5,5);
    set.insert(a);
    set.insert(b);
    set.insert(c);
    set.insert(d);
    Point2D neighbor = new Point2D(1,1);
    assertEquals(a, set.nearest(neighbor));
  }

  @Test
  public void nearestNeighborOutsideSquare() {
    PointSET set = new PointSET();
    Point2D a = new Point2D(0,0);
    Point2D b = new Point2D(0,5);
    Point2D c = new Point2D(5,0);
    Point2D d = new Point2D(5,5);
    set.insert(a);
    set.insert(b);
    set.insert(c);
    set.insert(d);
    Point2D neighbor = new Point2D(6,6);
    assertEquals(d, set.nearest(neighbor));
  }
  
  @Test
  public void RangeInRectangle() {
    PointSET set = new PointSET();
    Point2D a = new Point2D(0,0);
    Point2D b = new Point2D(0,5);
    Point2D c = new Point2D(5,0);
    Point2D d = new Point2D(5,5);
    Point2D e = new Point2D(6,6);
    set.insert(a);
    set.insert(b);
    set.insert(c);
    set.insert(d);
    set.insert(e);
    RectHV rect = new RectHV(0.0, 0.0, 7.0, 7.0);
    Iterable<Point2D> iter = set.range(rect);
    assertTrue(iter != null);
  }
}
