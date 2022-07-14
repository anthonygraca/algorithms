package io.anthonygraca.princeton.chapter2.KdTree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class KdTreeTest {
  @Test
  public void constructedObjectIsEmpty() {
    KdTree tree = new KdTree();
    assertTrue(tree.isEmpty());
  }

}
