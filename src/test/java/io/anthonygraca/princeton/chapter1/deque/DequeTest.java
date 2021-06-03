package io.anthonygraca.princeton.chapter1;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.NoSuchElementException;

import org.junit.Test;

public class DequeTest {
  @Test
  public void constructEmptyDeque() {
    Deque deque = new Deque();
    assertTrue(deque.size() == 0);
  }

  @Test
  public void verifyNewDequeIsEmpty() {
    Deque deque = new Deque();
    assertTrue(deque.isEmpty());
  }

  @Test
  public void addFirstItem() {
    Deque deque = new Deque();
    Item item = new Item();
    deque.addFirst(item);
    assertFalse(deque.isEmpty());
  }

  @Test
  public void addLastItem() {
    Deque deque = new Deque();
    Item item = new Item();
    deque.addLast(item);
    assertFalse(deque.isEmpty());
  }

  @Test
  public void removeFirstItem() {
    Deque deque = new Deque();
    Item item = new Item();
    deque.addFirst(item);
    deque.removeFirst();
    assertTrue(deque.isEmpty());
  }

  @Test(expected=NoSuchElementException.class)
  public void removeFirstItemWithoutAdd() {
    Deque deque = new Deque();
    Item item = new Item();
    deque.removeFirst();
  }

  public class Item {}
}

