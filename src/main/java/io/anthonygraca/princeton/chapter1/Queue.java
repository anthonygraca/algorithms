package io.anthonygraca.princeton.chapter1;

/*
 * An array-based implementation of a queue
 */
public class Queue<T> {
  private T[] queue;
  private int front;
  private int back;
  private static final int DEFAULT_CAPACITY = 25;
  private static final int MAX_CAPACITY = 10000;

  public Queue(){
    this(DEFAULT_CAPACITY);
  }

  public Queue(int capacity){
    checkCapacity(capacity);

    // java garbage to enable usage of generic arrays
    @SuppressWarnings("unchecked")
    T[] tempQueue = (T[])new Object[capacity + 1];
    queue = tempQueue;
    front = 0;
    back = capacity;
  }

  /*
   * Ensures the defined capacity of the queue is within the proper boundaries
   */
  private void checkCapacity(int capacity){
    if (capacity > MAX_CAPACITY){
      throw new IllegalStateException("Queue capacity exceeds the max capacity of " + MAX_CAPACITY);
    }
    else if (capacity <= 0){
      throw new IllegalStateException("Queue capacity must be greater than 0");
    }
  }
}
