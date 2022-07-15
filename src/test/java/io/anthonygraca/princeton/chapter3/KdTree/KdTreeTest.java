package io.anthonygraca.princeton.chapter2.KdTree;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

public class KdTreeTest {
  @Test
  public void constructedObjectIsEmpty() {
    KdTree tree = new KdTree();
    assertTrue(tree.isEmpty());
  }
  
  @Test
  public void constructedObjectSizeIsZero() {
    KdTree tree = new KdTree();
    assertEquals(0, tree.size());
  }

  @Test(expected=IllegalArgumentException.class)
  public void insertHandlesNull() {
    KdTree tree = new KdTree();
    tree.insert(null);
  }

  @Test
  public void emptySetDoesNotContainAnything() {
    KdTree tree = new KdTree();
    Point2D some_point = new Point2D(1,2);
    assertFalse(tree.contains(some_point));
  }

  @Test(expected=IllegalArgumentException.class)
  public void containHandlesNull() {
    KdTree tree = new KdTree();
    assertFalse(tree.contains(null));
  }

  @Test
  public void nearestReturnsNullWhenSetIsEmpty() {
    KdTree tree = new KdTree();
    Point2D some_point = new Point2D(1,2);
    assertEquals(null, tree.nearest(some_point));
  }

  @Test(expected=IllegalArgumentException.class)
  public void nearestHandlesNull() {
    KdTree tree = new KdTree();
    tree.nearest(null);
  }

  @Test(expected=IllegalArgumentException.class)
  public void rangeHandlesNull() {
    KdTree tree = new KdTree();
    tree.range(null);
  }
  
  @Test
  public void insertSomePointIntoSet() {
    KdTree tree = new KdTree();
    Point2D some_point = new Point2D(1,2);
    tree.insert(some_point);
    assertTrue(tree.contains(some_point));
  }

  @Test
  public void insertTwoPointsIntoTree() {
    KdTree tree = new KdTree();
    Point2D a = new Point2D(7,2);
    Point2D b = new Point2D(5,4);
    tree.insert(a);
    tree.insert(b);
    assertTrue(tree.contains(a));
    assertTrue(tree.contains(b));
  }
  
  @Test
  public void insertThreePointsIntoTree() {
    KdTree tree = new KdTree();
    Point2D a = new Point2D(0.7,0.2);
    Point2D b = new Point2D(0.5,0.4);
    Point2D c = new Point2D(0.2,0.3);
    tree.insert(a);
    tree.insert(b);
    tree.insert(c);
    assertTrue(tree.contains(a));
    assertTrue(tree.contains(b));
    assertTrue(tree.contains(c));
  }

  @Test
  public void insertFourPointsIntoTree() {
    KdTree tree = new KdTree();
    Point2D a = new Point2D(0.7,0.2);
    Point2D b = new Point2D(0.5,0.4);
    Point2D c = new Point2D(0.2,0.3);
    Point2D d = new Point2D(0.4,0.7);
    tree.insert(a);
    tree.insert(b);
    tree.insert(c);
    tree.insert(d);
    assertTrue(tree.contains(a));
    assertTrue(tree.contains(b));
    assertTrue(tree.contains(c));
    assertTrue(tree.contains(d));
  }
  
  @Test
  public void PointDoesNotExistInTree() {
    KdTree tree = new KdTree();
    Point2D a = new Point2D(0.7,0.2);
    Point2D b = new Point2D(0.5,0.4);
    Point2D c = new Point2D(0.2,0.3);
    Point2D d = new Point2D(0.4,0.7);
    Point2D e = new Point2D(0.9,0.6);
    tree.insert(a);
    tree.insert(b);
    tree.insert(c);
    tree.insert(d);
    assertTrue(tree.contains(a));
    assertTrue(tree.contains(b));
    assertTrue(tree.contains(c));
    assertTrue(tree.contains(d));
    assertFalse(tree.contains(e));
    assertFalse(tree.isEmpty());
    assertTrue(tree.size() == 4);
  }

  @Test
  public void insertShouldIncrementSize() {
    KdTree tree = new KdTree();
    Point2D some_point = new Point2D(1,2);
    tree.insert(some_point);
    assertTrue(tree.size() != 0);
  }
  
  @Test
  public void nearestNeighbor() {
    KdTree tree = new KdTree();
    Point2D some_point = new Point2D(1,2);
    tree.insert(some_point);
    Point2D neighbor = new Point2D(1,1);
    assertEquals(some_point, tree.nearest(neighbor));
  }

  @Test
  public void nearestNeighborOfSquare() {
    KdTree tree = new KdTree();
    Point2D a = new Point2D(0.0,0.0);
    Point2D b = new Point2D(0.0,0.5);
    Point2D c = new Point2D(0.5,0.0);
    Point2D d = new Point2D(0.5,0.5);
    tree.insert(a);
    tree.insert(b);
    tree.insert(c);
    tree.insert(d);
    Point2D neighbor = new Point2D(0.1,0.1);
    assertEquals(a, tree.nearest(neighbor));
  }

  @Test
  public void nearestNeighborOutsideSquare() {
    KdTree tree = new KdTree();
    Point2D a = new Point2D(0.0,0.0);
    Point2D b = new Point2D(0.0,0.5);
    Point2D c = new Point2D(0.5,0.0);
    Point2D d = new Point2D(0.5,0.5);
    tree.insert(a);
    tree.insert(b);
    tree.insert(c);
    tree.insert(d);
    Point2D neighbor = new Point2D(0.6,0.6);
    assertEquals(d, tree.nearest(neighbor));
  }

  @Test
  public void containsDuplicate() {
    KdTree tree = new KdTree();
    Point2D a = new Point2D(0.0,0.0);
    Point2D b = new Point2D(0.0,0.5);
    Point2D c = new Point2D(0.5,0.0);
    Point2D d = new Point2D(0.5,0.5);
    Point2D e = new Point2D(0.5,0.5);
    tree.insert(a);
    tree.insert(b);
    tree.insert(c);
    tree.insert(d);
    assertTrue(tree.contains(d));
  }

  @Test
  public void containsDiffDuplicate() {
    KdTree tree = new KdTree();
    Point2D a = new Point2D(0.0,0.0);
    Point2D b = new Point2D(0.0,0.5);
    Point2D c = new Point2D(0.5,0.0);
    Point2D d = new Point2D(0.5,0.5);
    Point2D e = new Point2D(0.5,0.5);
    tree.insert(a);
    tree.insert(b);
    tree.insert(c);
    tree.insert(d);
    assertTrue(tree.contains(e));
  }
  
  @Test
  public void onlyInsertUnique() {
    KdTree tree = new KdTree();
    Point2D a = new Point2D(0.0,0.0);
    Point2D b = new Point2D(0.0,0.5);
    Point2D c = new Point2D(0.5,0.0);
    Point2D d = new Point2D(0.5,0.5);
    Point2D e = new Point2D(0.5,0.5);
    tree.insert(a);
    tree.insert(b);
    tree.insert(c);
    tree.insert(d);
    tree.insert(e);
    assertEquals(4, tree.size());
  }

  @Test
  public void RangeInWholeRectangle() {
    KdTree tree = new KdTree();
    Point2D a = new Point2D(0.7,0.2);
    Point2D b = new Point2D(0.5,0.4);
    Point2D c = new Point2D(0.2,0.3);
    Point2D d = new Point2D(0.4,0.7);
    Point2D e = new Point2D(0.9,0.6);
    tree.insert(a);
    tree.insert(b);
    tree.insert(c);
    tree.insert(d);
    tree.insert(e);
    RectHV rect = new RectHV(0.0, 0.0, 1.0, 1.0);
    Iterable<Point2D> iter = tree.range(rect);
    HashSet<Point2D> set = new HashSet<Point2D>();
    for (Point2D p : iter) {
      set.add(p);
    }
    assertTrue(set.contains(a));
    assertTrue(set.contains(b));
    assertTrue(set.contains(c));
    assertTrue(set.contains(d));
    assertTrue(set.contains(e));
  }
  
  @Test
  public void RangeInNoRectangle() {
    KdTree tree = new KdTree();
    Point2D a = new Point2D(0.7,0.2);
    Point2D b = new Point2D(0.5,0.4);
    Point2D c = new Point2D(0.2,0.3);
    Point2D d = new Point2D(0.4,0.7);
    Point2D e = new Point2D(0.9,0.6);
    tree.insert(a);
    tree.insert(b);
    tree.insert(c);
    tree.insert(d);
    tree.insert(e);
    RectHV rect = new RectHV(0.0, 0.0, 0.0, 0.0);
    Iterable<Point2D> iter = tree.range(rect);
    assertTrue(iter != null);
    HashSet<Point2D> set = new HashSet<Point2D>();
    for (Point2D p : iter) {
      set.add(p);
    }
    assertFalse(set.contains(a));
    assertFalse(set.contains(b));
    assertFalse(set.contains(c));
    assertFalse(set.contains(d));
    assertFalse(set.contains(e));
  }
  
  @Test
  public void RangeInHalfRectangle() {
    KdTree tree = new KdTree();
    Point2D a = new Point2D(0.7,0.2);
    Point2D b = new Point2D(0.5,0.4);
    Point2D c = new Point2D(0.2,0.3);
    Point2D d = new Point2D(0.4,0.7);
    Point2D e = new Point2D(0.9,0.6);
    tree.insert(a);
    tree.insert(b);
    tree.insert(c);
    tree.insert(d);
    tree.insert(e);
    RectHV rect = new RectHV(0.0, 0.0, 1.0, 0.5);
    Iterable<Point2D> iter = tree.range(rect);
    assertTrue(iter != null);
    HashSet<Point2D> set = new HashSet<Point2D>();
    for (Point2D p : iter) {
      set.add(p);
    }
    assertTrue(set.contains(a));
    assertTrue(set.contains(b));
    assertTrue(set.contains(c));
    assertFalse(set.contains(d));
    assertFalse(set.contains(e));
  }
}
