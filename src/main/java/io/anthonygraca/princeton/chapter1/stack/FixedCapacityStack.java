package io.anthonygraca.princeton.chapter1.stack;

public class FixedCapacityStack<Item> {
  private Item[] collection;
  private int m_size = 0;

  public FixedCapacityStack(int capacity) {
    collection = (Item[]) new Object[capacity];
  }

  public void push(Item item) {
    collection[m_size++] = item;
  }

  public boolean isEmpty() {
    return m_size == 0;
  }

  public int size() {
    return m_size;
  }

  public Item pop() {
    return collection[--m_size];
  }
}
