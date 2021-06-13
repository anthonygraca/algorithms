package io.anthonygraca.princeton.chapter1.deque;

import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Test;

public class DequeTest {
  @Test
  public void initializedDequeIsEmpty() {
    Deque<String> deque = new Deque<String>();
    assertTrue(deque.isEmpty());
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

}
