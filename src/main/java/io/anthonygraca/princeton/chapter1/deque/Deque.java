package io.anthonygraca.princeton.chapter1;

import java.util.NoSuchElementException;

public class Deque<Item> {

  private int mSize = 0;

  public int size() {
    return mSize;
  }

  public boolean isEmpty() {
    return mSize == 0;
  }

  public void addFirst(Item item) {
    mSize++;
  }

  public void addLast(Item item) {
    mSize++;
  }

  public Item removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException("Deque is empty. Cannot remove");
    }
    mSize--;
    return (Item) new Object();
  }

}

