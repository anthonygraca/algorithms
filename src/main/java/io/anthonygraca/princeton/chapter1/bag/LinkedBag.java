package io.anthonygraca.princeton.chapter1;

import java.util.NoSuchElementException;
import java.util.Iterator;

public class LinkedBag<T> implements Bag<T>, Iterable<T>{
  private Node head;
  private Node tail;
  private int size;

  /**
   * Default constructor
   */
  public LinkedBag(){
    head = null;
    tail = null;
    size = 0;
  }

  /**
   * Adds an item to the bag
   * @param item  the item being added
   */
  public void add(T item){
    // case 1: empty
    if (isEmpty()){
      head = tail = new Node(item, null);
    }
    // case 2: 1 item
    else if (size == 1){
      tail.next = new Node(item, null);
      tail = tail.next;
      head.next = tail;
    }
    // case 3: more than 1 item
    else{
      tail.next = new Node(item, null);
      tail = tail.next;
    }
    size++;
  }

  /**
   * Checks if the bag is empty
   * @return  true if empty, false if not
   */
  public boolean isEmpty(){
    return size == 0;
  }

  /**
   * Finds the number of items currently in the bag
   * @return  the number of items currently in the bag
   */
  public int size(){
    return size;
  }

  /**
   * Returns the item at the top of the bag
   * @return  the item at the top of the bag
   * @throws  NoSuchElementException if the bag is empty
   */
  public T getItem(){
    if (isEmpty()){
      throw new NoSuchElementException();
    }
    else{
      return tail.data;
    }
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

  /**
   * Returns an iterator that iterates over the items in the bag arbitrarily
   * @return an iterator that iterates over the items in the bag arbitrarily
   */
  public Iterator<T> iterator(){
    return new LinkedIterator();
  }

  private class LinkedIterator implements Iterator<T>{
    private int i = 0;

    /**
     * Detects if this iterator has gone beyond the last entry in the collection
     * @return true if the iterator has another entry to return, false if not
     */
    public boolean hasNext(){
      return i < size;
    }

    /**
     * Removes from the list the last entry that either next() or previous() has returned
     * @throws  UnsupportedOperationException if the iterator does not permit a remove operation
     */
    public void remove(){
      throw new UnsupportedOperationException();
    }

    /**
     * Retrieves the next entry in the list and advances the iterator by one position
     * @return a reference to the next entry in the iteration
     * @throws NoSuchElementException if the iterator is at the end (hasNext() is false)
     */
    public T next(){
      if (!hasNext()){
        throw new NoSuchElementException();
      }
      // move a temp node to the item location
      int j = 0;
      Node tempNode = head;
      while (j < i){
        tempNode = tempNode.next;
        j++;
      }
      // increment the count, return the data at that location
      i++;
      return tempNode.data;
    }
  }

}
