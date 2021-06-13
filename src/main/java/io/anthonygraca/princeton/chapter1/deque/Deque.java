package io.anthonygraca.princeton.chapter1.deque;

import java.util.NoSuchElementException;

public class Deque<Item> {
  private Node first = null;
  private Node last = null; 

  boolean isEmpty() {
    return true;
  }

  void addFirst(Item item) {
    if (item == null) {
      throw new IllegalArgumentException("Cannot insert null");
    }
  }

  void addLast(Item item) {
    if (item == null) {
      throw new IllegalArgumentException("Cannot insert null");
    }
  }

  Item removeFirst() {
    Item item = null;
    if (isEmpty()) {
      throw new NoSuchElementException("Cannot remove from empty deque");
    }
    return item;
  }

  Item removeLast() {
    Item item = null;
    if (isEmpty()) {
      throw new NoSuchElementException("Cannot remove from empty deque");
    }
    return item;
  }

  class Node {
    Item item;
    Node prev;
    Node next;
  }

}
