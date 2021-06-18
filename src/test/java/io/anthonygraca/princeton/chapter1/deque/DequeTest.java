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

  @Test
  public void addFirstAndCanRemoveLast() {
    Deque<String> deque = new Deque<String>();
    String element = "example";
    deque.addFirst(element);
    assertEquals(element, deque.removeLast());
  }

  @Test
  public void removeLastRemovesNode() {
    Deque<String> deque = new Deque<String>();
    String element = "example";
    deque.addFirst(element);
    deque.removeLast();
    assertTrue(deque.isEmpty());
  }

  @Test
  public void removeLastReducesSize() {
    Deque<String> deque = new Deque<String>();
    int initial_size = deque.size();
    String element = "example";
    deque.addFirst(element);
    deque.removeLast();
    assertEquals(initial_size, deque.size());
  }

  @Test
  public void removeFirstReducesSize() {
    Deque<String> deque = new Deque<String>();
    int initial_size = deque.size();
    String element = "example";
    deque.addFirst(element);
    deque.removeFirst();
    assertEquals(initial_size, deque.size());
  }

  @Test
  public void addLastElementChangesSize() {
    Deque<String> deque = new Deque<String>();
    String element = "example";
    deque.addLast(element);
    assertTrue(deque.size() > 0);
  }

  @Test
  public void addLastMakesStackNotEmpty() {
    Deque<String> deque = new Deque<String>();
    String element = "example";
    deque.addLast(element);
    assertFalse(deque.isEmpty());
  }

  @Test
  public void addLastAndCanRemoveFirst() {
    Deque<String> deque = new Deque<String>();
    String element = "example";
    deque.addLast(element);
    assertEquals(element, deque.removeFirst());
  }

  @Test
  public void addLastAndCanRemoveLast() {
    Deque<String> deque = new Deque<String>();
    String element = "example";
    deque.addLast(element);
    assertEquals(element, deque.removeLast());
  }

  @Test
  public void iteratorTest() {
    Deque<String> deque = new Deque<String>();
    String element = "example";
    deque.addFirst(element);
    deque.addFirst(element);
    deque.addFirst(element);
    for(String entry : deque) {
      assertEquals(element, entry);
    }
  }
}
