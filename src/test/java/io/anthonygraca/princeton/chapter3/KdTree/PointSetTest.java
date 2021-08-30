package io.anthonygraca.princeton.chapter2.KdTree;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PointSetTest {
  @Test
  public void constructedObjectIsEmpty() {
    PointSET set = new PointSET();
    assertTrue(set.isEmpty());
  }
}
