package io.anthonygraca.princeton.chapter1.deque;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.NoSuchElementException;

import org.junit.Test;

public class DequeTest {
  @Test
  public void initializedDequeIsEmpty() {
    Deque<String> deque = new Deque<String>();
    assertTrue(deque.isEmpty());
  }

  @Test
  public void initializedDequeHasSizeZero() {
    Deque<String> deque = new Deque<String>();
    assertEquals(0, deque.size());
  }

  @Test(expected=IllegalArgumentException.class)
  public void verifyAddFirstInputNotNull() {
    Deque<String> deque = new Deque<String>();
    deque.addFirst(null);
  }

  @Test(expected=IllegalArgumentException.class)
  public void verifyAddLastInputNotNull() {
    Deque<String> deque = new Deque<String>();
    deque.addLast(null);
  }

  @Test(expected=NoSuchElementException.class)
  public void verifyCannotRemoveFirstWhenEmpty() {
    Deque<String> deque = new Deque<String>();
    assertTrue(deque.isEmpty());
    deque.removeFirst();
  }

  @Test(expected=NoSuchElementException.class)
  public void verifyCannotRemoveLastWhenEmpty() {
    Deque<String> deque = new Deque<String>();
    assertTrue(deque.isEmpty());
    deque.removeLast();
  }

  @Test
  public void addFirstElementChangesSize() {
    Deque<String> deque = new Deque<String>();
    String element = "example";
    deque.addFirst(element);
    assertTrue(deque.size() > 0);
  }

  @Test
  public void addFirstMakesStackNotEmpty() {
    Deque<String> deque = new Deque<String>();
    String element = "example";
    deque.addFirst(element);
    assertFalse(deque.isEmpty());
  }

  @Test
  public void addFirstAndCanRemoveFirst() {
    Deque<String> deque = new Deque<String>();
    String element = "example";
    deque.addFirst(element);
    assertEquals(element, deque.removeFirst());
  }

  @Test
  public void removeFirstRemovesNode() {
    Deque<String> deque = new Deque<String>();
    String element = "example";
    deque.addFirst(element);
    deque.removeFirst();
    assertTrue(deque.isEmpty());
  }

}
