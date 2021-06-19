package io.anthonygraca.princeton.chapter1.deque;

import java.util.NoSuchElementException;

public class ArrayDeque<T> {
  private T[] deque;
  private int front;
  private int back;
  private int size;
  private final int OFFSET = 1; // used to help track front and back indices
  private static final int DEFAULT_CAPACITY = 25;
  private static final int MAX_CAPACITY = 10000;

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
    size = 0;
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
   * Checks if the deque is full
   * @return  true if the deque is full, false if not
   */
  public boolean isFull(){
    return front == back;
  }

  /**
   * Decrements a particular index of the deque
   * @param index the index being decremented
   * @return  the decremented index
   */
  private int decrement(int index){
    // due to java's implementation of the modulus operator, a negative operand returns a...
    // ...negative value. therefore this code is needed so the index properly wraps around the array
    return ((index - 1) % deque.length + deque.length) % deque.length;
  }

  /**
   * Increments a particular index of the deque
   * @param index the index being incremented
   * @return the incremented index
   */
  private int increment(int index){
    // this allows the index to wrap around the array
    return (index + 1) % deque.length;
  }

  /**
   * Checks the item at the front of the deque
   * @return  the item at the front of the deque
   */
  public T getFirst(){
    if (isEmpty()){
      throw new NoSuchElementException("Cannot read the contents of an empty queue");
    }
    else{
      return deque[increment(front)];
    }
  }

  /**
   * Checks the item at the back of the deque
   * @return  the item at the back of the deque
   */
  public T getLast(){
    if (isEmpty()){
      throw new NoSuchElementException("Cannot read the contents of an empty queue");
    }
    else{
      return deque[decrement(back)];
    }
  }

  /**
   * Adds an item to the front of the deque
   * @param item  the item being added
   */
  public void addFirst(T item){
    // enlarge the deque if it's full
    if (isFull()){
      doubleCapacity();
    }

    // add item, then move front index
    deque[front] = item;
    front = decrement(front); 
    size++;
  }

  /**
   * Doubles the capacity of the deque 
   */
  private void doubleCapacity(){
    // determine if the new capacity is valid
    int capacity = deque.length - OFFSET;
    checkCapacity(capacity * 2);
    capacity *= 2;

    // create a copy with the updated capacity
    int newBackIndex = 0;
    @SuppressWarnings("unchecked")
    T[] tempDeque = (T[])new Object[capacity + OFFSET];
    for (int i = 1; !isEmpty(); i++){
      tempDeque[i] = removeFirst();
      newBackIndex = i + 1;
    }
    deque = tempDeque;
    front = 0;
    back = newBackIndex;
  }

  /**
   * Adds an item to the back of the deque
   * @param item  the item being added
   */
  public void addLast(T item){
    if (isFull()){
      doubleCapacity();
    }

    // add item, increment back index
    deque[back] = item;
    back = increment(back); 
    size++;
  }

  /**
   * Removes an item from the front of the deque
   * @return  the item that was removed
   */
  public T removeFirst(){
    T removedItem = null;
    if (!isEmpty()){
      // increment front, them remove item
      front = increment(front); 
      removedItem = deque[front];
      deque[front] = null;
      size--;
    }
    else{
      throw new IllegalStateException("Cannot remove from an empty deque");
    }
    return removedItem;
  }

  /**
   * Removes an item from the back of the deque
   * @return  the item that was removed
   */
  public T removeLast(){
    T removedItem = null;
    if (!isEmpty()){
      // decrement back, them remove item
      back = decrement(back); 
      removedItem = deque[back];
      deque[back] = null;
      size--;
    }
    else{
      throw new IllegalStateException("Cannot remove from an empty deque");
    }
    return removedItem;
  }
}
