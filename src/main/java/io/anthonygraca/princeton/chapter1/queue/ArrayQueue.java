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
  private static final int OFFSET = 1;  // allows front/back index tracking with modulus

  /**
   * Default constructor for Queue
   */
  public Queue(){
    this(DEFAULT_CAPACITY);
  }

  /**
   * Constructor that creates a queue based on the given capacity
   * @param capacity  the capacity of the queue being created
   */
  public Queue(int capacity){
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

  }

  /**
   * Removes an item from the beginning of the queue
   * @return The item that was removed from the queue
   */
  public T dequeue(){
    return null;
  }

  /**
   * Checks the front of the queue
   * @return the object at the front of the queue
   */
  public T peek(){
    return null;
  }

  /**
   * Checks if the queue is empty
   * @return True if the queue is empty, false if not
   */
  public boolean isEmpty(){
    return false;
  }

  /**
   * Checks if the queue is full
   * @return True if the queue is full, false if not
   */
  public boolean isFull(){
    return false;
  }

  /**
   * Empties the contents of the queue
   */
  public void clear(){

  }
}
