package io.anthonygraca.princeton.chapter2.KdTree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.princeton.cs.algs4.Point2D;

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
}
