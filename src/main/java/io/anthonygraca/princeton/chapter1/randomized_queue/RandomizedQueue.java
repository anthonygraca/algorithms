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
    int random_index = StdRandom.uniform(0, m_size);
    Item item = collection[random_index];
    collection[random_index] = collection[--m_size];
    collection[m_size] = null;
    return item;
  }

  public Item sample() {
    if(isEmpty()) {
      throw new NoSuchElementException("can't dequeue empty queue");
    }
    int random_index = StdRandom.uniform(0, m_size);
    return collection[random_index];
  }

  public Iterator<Item> iterator() {
    return new RandomizedQueueIterator();
  }

  private class RandomizedQueueIterator implements Iterator<Item> {
    private Item[] iterator_collection = (Item[]) new Object[collection.length];
    private int m_current = m_size;
    public RandomizedQueueIterator() {
      for (int i = 0; i < collection.length; i++) {
        iterator_collection[i] = collection[i];
      }
    }
    public boolean hasNext() {return m_current > 0;}
    public void remove() {
      throw new UnsupportedOperationException("Remove is unsupported");
    }
    public Item next() {
      if (!hasNext()) {
        throw new NoSuchElementException("Queue is Empty");
      }
      int random_index = StdRandom.uniform(0, m_current);
      Item item = iterator_collection[random_index];
      iterator_collection[random_index] = iterator_collection[--m_current];
      iterator_collection[m_current] = null;
      return item;
    }
  }

  /* move shuffle so it's only called once */
  /* implement hasNext() */
}
