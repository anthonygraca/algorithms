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
    checkHasItems();
    mSize--;
    return (Item) new Object();
  }

  public Item removeLast() {
    checkHasItems();
    mSize--;
    return (Item) new Object();
  }

  private void checkHasItems() {
    if (isEmpty()) {
      throw new NoSuchElementException("Deque is empty. Cannot remove");
    }
  }

}

