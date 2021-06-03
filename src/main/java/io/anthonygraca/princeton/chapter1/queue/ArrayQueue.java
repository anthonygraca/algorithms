package io.anthonygraca.princeton.chapter1;
import java.util.NoSuchElementException;

/*
 * An array-based implementation of a queue
 */
public class ArrayQueue<T> implements Queue<T> {
  private T[] queue;
  private int front;
  private int back;
  private static final int DEFAULT_CAPACITY = 25;
  private static final int MAX_CAPACITY = 10000;
  private static final int OFFSET = 1;  // allows front/back index tracking with modulus

  /**
   * Default constructor for Queue
   */
  public ArrayQueue(){
    this(DEFAULT_CAPACITY);
  }

  /**
   * Constructor that creates a queue based on the given capacity
   * @param capacity  the capacity of the queue being created
   */
  public ArrayQueue(int capacity){
    checkCapacity(capacity);

    // java garbage to enable usage of generic arrays
    @SuppressWarnings("unchecked")
    T[] tempQueue = (T[])new Object[capacity + OFFSET];
    queue = tempQueue;
    front = 0;
    back = capacity;
  }

  /**
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

  /**
   * Adds an item to the queue
   * @param item object to be placed into the queue
   */
  public void enqueue(T item){
    // double capacity if the array is full
    if (isFull()){
      doubleCapacity();
    }
    else{
      // update back index, then place object at the back of the queue
      back = (back + 1) % queue.length;
      queue[back] = item;
    }
  }

  /**
   * Doubles the capacity of the queue
   */
  private void doubleCapacity(){
    // determine if the new capacity is valid
    int capacity = queue.length - OFFSET;
    checkCapacity(capacity * 2);
    capacity *= 2;

    // create a copy with the updated capacity
    int newBackIndex = 0;
    @SuppressWarnings("unchecked")
    T[] tempQueue = (T[])new Object[capacity + OFFSET];
    for (int i = 0; !isEmpty(); i++){
      tempQueue[i] = dequeue();
      newBackIndex = i;
    }
    queue = tempQueue;
    front = 0;
    back = newBackIndex;
  }

  /**
   * Removes an item from the beginning of the queue
   * @return The item that was removed from the queue
   */
  public T dequeue(){
    T removedItem = null;
    if (!isEmpty()){
      // remove item, then increment front
      removedItem = queue[front];
      queue[front] = null;
      front = (front + 1) % queue.length;
    }
    else{
      throw new IllegalStateException("Cannot dequeue an empty queue");
    }
    return removedItem;
  }

  /**
   * Checks the front of the queue
   * @return the object at the front of the queue
   */
  public T getFront(){
    if (isEmpty()){
      throw new NoSuchElementException("Cannot read the contents of an empty queue");
    }
    else{
      return queue[front];
    }
  }

  /**
   * Checks if the queue is empty
   * @return True if the queue is empty, false if not
   */
  public boolean isEmpty(){
    return (back + 1) % queue.length == front;
  }

  /**
   * Checks if the queue is full
   * @return True if the queue is full, false if not
   */
  public boolean isFull(){
    return (back + 2) % queue.length == front;
  }

  /**
   * Empties the contents of the queue
   */
  public void clear(){

  }
}
