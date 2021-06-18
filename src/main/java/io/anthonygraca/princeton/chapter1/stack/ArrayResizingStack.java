package io.anthonygraca.princeton.chapter1.stack;

import java.util.Iterator;

public class ArrayResizingStack<Item> implements Iterable<Item> {
  @SuppressWarnings("unchecked")
  private Item[] collection = (Item[]) new Object[1];
  private int m_size = 0;

  public void push(Item item) {
    if (m_size == collection.length) resize(2*collection.length);
    collection[m_size++] = item;
  }

  private void resize(int max) {
    @SuppressWarnings("unchecked")
    Item[] temp = (Item[]) new Object[max];
    for (int i = 0; i < m_size; i++) {
      temp[i] = collection[i];
    }
    collection = temp;
  }

  public boolean isEmpty() {
    return m_size == 0;
  }

  public int size() {
    return m_size;
  }

  public Item pop() {
    Item item = collection[--m_size];
    collection[m_size] = null;
    if (m_size > 0 && m_size == collection.length/4) resize(collection.length/2);
    return item;
  }

  public int getCapacity() {
    return collection.length;
  }

  public Iterator<Item> iterator() {
    return new ReverseArrayIterator();
  }

  private class ReverseArrayIterator implements Iterator<Item> {
    private int i = m_size-1;
    public boolean hasNext() { return i >= 0; }
    public Item next() { return collection[i--]; }
    public void remove() { }
  }
}
