package io.anthonygraca.princeton.chapter1;
import java.util.NoSuchElementException;

/*
 * A linked list-based implementation of a queue
 */
public class LinkedQueue<T> implements Queue<T> {
  private Node head;
  private int size;

  /**
   * Default constructor
   */
  public LinkedQueue(){
    head = new Node();
    size = 0;
  }

  /** 
   * Adds a new entry to the back of the queue
   * @param newEntry  the entry to be added
   */
  public void enqueue(T newEntry){

  }

  /** 
   * Removes and returns the entry at the front of the queue
   * @return  the entry at the front of the queue ]
   */
  public T dequeue(){
    return null;
  }

  /** 
   * Retrieves the queue's front entry
   * @return  the queue's front entry 
   */
  public T getFront(){
    return null;
  }

  /** 
   * Checks whether the queue is empty
   * @return  true if the queue is empty, false if not 
   */
  public boolean isEmpty(){
    return true;
  }

  /** 
   * Removes all the entries of the queue
   */
  public void clear(){

  }
  
  /*
   * the node, as a nested class
   */
  private class Node{
    private T data;
    private Node next;

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
 
