package io.anthonygraca.princeton.chapter1.deque;

import java.util.NoSuchElementException;

public class Deque<Item> {
  private Node first = null;
  private Node last = null; 
  private int m_size = 0;

  boolean isEmpty() {
    return first == null && last == null;
  }

  public int size() {
    return m_size;
  }

  void addFirst(Item item) {
    if (item == null) {
      throw new IllegalArgumentException("Cannot insert null");
    }
    Node new_node = new Node();
    new_node.item = item;
    new_node.next = first;
    new_node.prev = null;
    first = new_node;
    if (last == null) last = new_node; // covers edge case when deque is empty
    m_size++;
  }

  void addLast(Item item) {
    if (item == null) {
      throw new IllegalArgumentException("Cannot insert null");
    }
  }

  Item removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException("Cannot remove from empty deque");
    }
    Item item = first.item;
    first = first.next;
    if (first == null) last = null; 
    return item;
  }

  Item removeLast() {
    if (isEmpty()) {
      throw new NoSuchElementException("Cannot remove from empty deque");
    }
    Item item = last.item;
    last = last.prev;
    return item;
  }

  private class Node {
    Item item;
    Node prev;
    Node next;
  }

}
