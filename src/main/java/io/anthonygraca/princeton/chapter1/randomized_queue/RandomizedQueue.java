package io.anthonygraca.princeton.chapter1.randomized_queue;

public class RandomizedQueue<Item> {
  private int m_size = 0;
  public boolean isEmpty() {
    return m_size == 0;
  }

  public int size() {
    return m_size;
  }

  public void addFirst(Item item) {
    m_size++;
  }

  public void addLast(Item item) {
    m_size++;
  }
}
