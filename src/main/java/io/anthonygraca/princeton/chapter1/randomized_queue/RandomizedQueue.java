package io.anthonygraca.princeton.chapter1.randomized_queue;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
  @SuppressWarnings("unchecked")
  private Item[] collection = (Item[]) new Object[1];
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
    if (m_size == collection.length) resize(2*collection.length);
    collection[m_size++] = item;
    StdRandom.shuffle(collection);
  }

  private void resize(int max) {
    @SuppressWarnings("unchecked")
    Item[] temp = (Item[]) new Object[max];
    for (int i = 0; i < m_size; i++) {
      temp[i] = collection[i];
    }
    collection = temp;
  }

  public Item dequeue() {
    if(isEmpty()) {
      throw new NoSuchElementException("can't dequeue empty queue");
    }
    Item item = collection[--m_size];
    collection[m_size] = null;
    return item;
  }

  public Item sample() {
    if(isEmpty()) {
      throw new NoSuchElementException("can't dequeue empty queue");
    }
    return collection[0];
  }

  public Iterator<Item> iterator() {
    return new RandomizedQueueIterator();
  }

  private class RandomizedQueueIterator implements Iterator<Item> {
    public boolean hasNext() {return false;}
    public void remove() {}
    public Item next() {
      if (!hasNext()) {
        throw new NoSuchElementException("Queue is Empty");
      }
      return sample();
    }
  }
}
