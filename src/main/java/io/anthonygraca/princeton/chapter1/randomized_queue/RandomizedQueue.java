package io.anthonygraca.princeton.chapter1.randomized_queue;

import java.util.NoSuchElementException;

public class RandomizedQueue<Item> {
  private int m_size = 0;
  public boolean isEmpty() {
    return m_size == 0;
  }

  public int size() {
    return m_size;
  }

  public void enqueue(Item item) {
    if (item == null) {
      throw new IllegalArgumentException("can't be null");
    }
    m_size++;
  }

  public Item dequeue() {
    if(isEmpty()) {
      throw new NoSuchElementException("can't dequeue empty queue");
    }
    return null;
  }
}
