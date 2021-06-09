package io.anthonygraca.princeton.chapter1.stack;

public class FixedCapacityStackOfStrings {
  private int m_size = 0;

  void push(String string) {
    m_size++;
  }

  boolean isEmpty() {
    return m_size == 0;
  }

  int size() {
    return m_size;
  }
}
