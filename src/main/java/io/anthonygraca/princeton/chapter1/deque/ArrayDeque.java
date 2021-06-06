package io.anthonygraca.princeton.chapter1;

import java.util.NoSuchElementException;

public class ArrayDeque<T> {
  private T[] deque;
  private int front;
  private int back;
  private static final int DEFAULT_CAPACITY = 25;
  private static final int MAX_CAPACITY = 10000;
  private int size;
  private final int OFFSET = 1;

  /**
   * Default constructor for deque
   */
  public ArrayDeque(){
    this(DEFAULT_CAPACITY);
  }

  /**
   * Constructor that creates a deque based on a given capacity
   * @param capacity  the capacity of the deque being created
   */
  public ArrayDeque(int capacity){
    checkCapacity(capacity);

    // java garbage to enable usage of generic arrays
    @SuppressWarnings("unchecked")
    T[] tempDeque = (T[])new Object[capacity + OFFSET];
    deque = tempDeque;
    front = 0;
    back = front + 1;
    size = capacity;
  }

  /**
   * Checks if the capacity value is valid
   * @param capacity  the capacity being checked
   */
  private void checkCapacity(int capacity){
    if (capacity > MAX_CAPACITY){
      throw new IllegalStateException("Deque capacity exceeds the max capacity of " + MAX_CAPACITY);
    }
    else if (capacity <= 0){
      throw new IllegalStateException("Deque capacity must be greater than 0");
    }
  }

  /**
   * Returns the size of the deque
   * @return  the size of the deque
   */
  public int size(){
    return size;
  }

  /**
   * Checks if the the deque is empty
   * @return  true if the deque is empty, false if not
   */
  public boolean isEmpty(){
    return size == 0;
  }

  /**
   * Adds an item to the front of the deque
   * @param item  the item being added
   */
  public void addFirst(T item){
    
  }

  /**
   * Adds an item to the back of the deque
   * @param item  the item being added
   */
  public void addLast(T item){

  }

  /**
   * Removes an item from the front of the deque
   * @return  the item that was removed
   */
  public T removeFirst(){
    return null;
  }

  /**
   * Removes an item from the back of the deque
   * @return  the item that was removed
   */
  public T removeLast(){
    return null;
  }
}
