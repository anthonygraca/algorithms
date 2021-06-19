package io.anthonygraca.princeton.chapter1.queue;
import java.util.NoSuchElementException;

/*
 * A linked list-based implementation of a queue
 */
public class LinkedQueue<T> implements Queue<T> {
  private Node head;
  private Node tail;
  private int size;

  /**
   * Default constructor
   */
  public LinkedQueue(){
    head = null;
    tail = null;
    size = 0;
  }

  /** 
   * Adds a new entry to the back of the queue
   * @param newEntry  the entry to be added
   */
  public void enqueue(T newEntry){
    if (isEmpty()){
      head = tail = new Node(newEntry);
    }
    else{
      tail.next = new Node(newEntry);
      tail = tail.next;
    }
    size++;
  }

  /** 
   * Removes and returns the entry at the front of the queue
   * @return  the entry at the front of the queue
   */
  public T dequeue(){
    T removedItem = null;
    // case 1: queue is empty
    if (isEmpty()){
      throw new IllegalStateException("Cannot dequeue an empty queue");
    }
    // case 2: queue has 1 item
    else if (size == 1){
      removedItem = head.data;
      head = tail = null;
    }
    // case 3: queue has more than 1 item
    else{
      removedItem = head.data;
      head = head.next;
    }
    size--;
    return removedItem;
  }

  /** 
   * Retrieves the queue's front entry
   * @return  the queue's front entry 
   */
  public T getFront(){
    if (isEmpty()){
      throw new NoSuchElementException("Cannot get the front of an empty queue");
    }
    else{
      return head.data;
    }
  }

  /** 
   * Checks whether the queue is empty
   * @return  true if the queue is empty, false if not 
   */
  public boolean isEmpty(){
    return size == 0;
  }

  /** 
   * Removes all the entries of the queue
   */
  public void clear(){
    head = null;
    tail = null;
    size = 0;
  }
  
  /*
   * the node, as a nested class
   */
  private class Node{
    public T data;
    public Node next;

    public Node(){
      this(null, null);
    }

    public Node(T item){
      this(item, null);
    }

    public Node(T item, Node nextNode){
      data = item;
      next = nextNode;
    }
  }
}
 
