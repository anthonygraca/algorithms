package io.anthonygraca.princeton.chapter1.randomized_queue;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
  @SuppressWarnings("unchecked")
  private Item[] collection = (Item[]) new Object[1];
  private int m_size = 0;
  private int m_current = 0;

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
    StdRandom.shuffle(collection, 0, m_size);
    if (!(m_current < m_size)) {
      m_current = 0;
    }
    return collection[m_current++];
  }

  public Iterator<Item> iterator() {
    return new RandomizedQueueIterator();
  }

  private class RandomizedQueueIterator implements Iterator<Item> {
    public boolean hasNext() {return m_current != m_size;}
    public void remove() {
      throw new UnsupportedOperationException("Remove is unsupported");
    }
    public Item next() {
      if (!hasNext()) {
        throw new NoSuchElementException("Queue is Empty");
      }
      return sample();
    }
  }

  /* move shuffle so it's only called once */
  /* implement hasNext() */
}
