package io.anthonygraca.princeton.chapter1.deque;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.NoSuchElementException;

import org.junit.Test;

public class DequeTest {
  @Test
  public void constructEmptyDeque() {
    Deque<Item> deque = new Deque<Item>();
    assertTrue(deque.size() == 0);
  }

  @Test
  public void verifyNewDequeIsEmpty() {
    Deque<Item> deque = new Deque<Item>();
    assertTrue(deque.isEmpty());
  }

  @Test
  public void addFirstItem() {
    Deque<Item> deque = new Deque<Item>();
    Item item = new Item();
    deque.addFirst(item);
    assertFalse(deque.isEmpty());
  }

  @Test
  public void addLastItem() {
    Deque<Item> deque = new Deque<Item>();
    Item item = new Item();
    deque.addLast(item);
    assertFalse(deque.isEmpty());
  }

  @Test
  public void removeFirstItem() {
    Deque<Item> deque = new Deque<Item>();
    Item item = new Item();
    deque.addFirst(item);
    deque.removeFirst();
    assertTrue(deque.isEmpty());
  }

  @Test(expected=NoSuchElementException.class)
  public void removeFirstItemWithoutAdd() {
    Deque<Item> deque = new Deque<Item>();
    Item item = new Item();
    deque.removeFirst();
  }

  @Test
  public void removeLastItem() {
    Deque<Item> deque = new Deque<Item>();
    Item item = new Item();
    deque.addLast(item);
    deque.removeLast();
    assertTrue(deque.isEmpty());
  }

  @Test(expected=NoSuchElementException.class)
  public void removeLastItemWithoutAdd() {
    Deque<Item> deque = new Deque<Item>();
    Item item = new Item();
    deque.removeLast();
  }

  @Test(expected=IllegalArgumentException.class)
  public void addFirstWithNullIsInvalid() {
    Deque<Item> deque = new Deque<Item>();
    deque.addFirst(null);
    assertTrue(deque.isEmpty());
  }

  @Test(expected=IllegalArgumentException.class)
  public void addLastWithNullIsInvalid() {
    Deque<Item> deque = new Deque<Item>();
    deque.addLast(null);
    assertTrue(deque.isEmpty());
  }


  /*
   * Test list:
   * see if item removed is the same
   */

  public class Item {}
}

