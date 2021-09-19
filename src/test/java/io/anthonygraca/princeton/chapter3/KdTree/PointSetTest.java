package io.anthonygraca.princeton.chapter2.KdTree;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

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
}
