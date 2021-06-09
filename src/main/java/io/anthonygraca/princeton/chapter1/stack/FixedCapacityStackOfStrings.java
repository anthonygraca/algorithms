package io.anthonygraca.princeton.chapter1.stack;

public class FixedCapacityStackOfStrings {
  private String[] collection;
  private int m_size = 0;

  public FixedCapacityStackOfStrings(int capacity) {
    collection = new String[capacity];
  }

  public void push(String string) {
    collection[m_size++] = string;
  }

  public boolean isEmpty() {
    return m_size == 0;
  }

  public int size() {
    return m_size;
  }

  public String pop() {
    return collection[--m_size];
  }
}
