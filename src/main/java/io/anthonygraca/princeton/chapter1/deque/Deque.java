package io.anthonygraca.princeton.chapter1.deque;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item>{
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
    if (first != null) first.prev = new_node;
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
    Node new_node = new Node();
    if (last != null) last.next = new_node;
    new_node.item = item;
    new_node.prev = last;
    new_node.next = null;
    last = new_node;
    if (first == null) first = new_node;
    m_size++;
  }

  Item removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException("Cannot remove from empty deque");
    }
    Item item = first.item;
    first = first.next;
    if (first == null) last = null; 
    else {
      first.prev = null;
    }
    m_size--;
    return item;
  }

  Item removeLast() {
    if (isEmpty()) {
      throw new NoSuchElementException("Cannot remove from empty deque");
    }
    Item item = last.item;
    last = last.prev;
    if (last == null) first = null;
    else {
      last.next = null;
    }
    m_size--;
    return item;
  }

  public Iterator<Item> iterator() {
    return new DequeIterator();
  }

  private class DequeIterator implements Iterator<Item> {
    private Node current = first;

    public boolean hasNext() {
      return current != null;
    }
    public void remove() {}
    public Item next() {
      Item item = current.item;
      current = current.next;
      return item;
    }
  }


  private class Node {
    Item item;
    Node prev;
    Node next;
  }

}
