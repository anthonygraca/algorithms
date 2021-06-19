package io.anthonygraca.princeton.chapter1.deque;

import java.util.NoSuchElementException;

public class LinkedDeque<T> {
  private Node head;
  private Node tail;
  private int size;

  public LinkedDeque(){
    head = null;
    tail = null;
    size = 0;
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
   * Checks the item at the front of the deque
   * @return  the item at the front of the deque
   */
  public T getFirst(){
    if (isEmpty()){
      throw new NoSuchElementException("Cannot get the first item of an empty deque");
    }
    else{
      return head.data;
    }
  }

  /**
   * Checks the item at the back of the deque
   * @return  the item at the back of the deque
   */
  public T getLast(){
    if (isEmpty()){
      throw new NoSuchElementException("Cannot get the last item of an empty deque");
    }
    else{
      return tail.data;
    }
  }

  /**
   * Adds an item to the front of the deque
   * @param item  the item being added
   */
  public void addFirst(T item){
    if (isEmpty()){
      head = tail = new Node(item, null);
    }
    else{
      Node tempNode = new Node(item, head);
      head = tempNode;
    }
    size++;
  }

  /**
   * Adds an item to the back of the deque
   * @param item  the item being added
   */
  public void addLast(T item){
    if (isEmpty()){
      head = tail = new Node(item, null);
    }
    else{
      tail.next = new Node(item, null);
      tail = tail.next;
    }
    size++;
  }

  /**
   * Removes an item from the front of the deque
   * @return  the item that was removed
   */
  public T removeFirst(){
    T removedItem = null;
    if (isEmpty()){
      throw new IllegalStateException("Cannot remove from an empty deque");
    }
    else{
      removedItem = head.data;
      head = head.next;
      size--;
      return removedItem;
    }
  }

  /**
   * Removes an item from the back of the deque
   * @return  the item that was removed
   */
  public T removeLast(){
    T removedItem = null;
    if (isEmpty()){
      throw new IllegalStateException("Cannot remove from an empty deque");
    }
    else if (size == 1){
      removedItem = tail.data;
      head = tail = null;
    }
    else{
      removedItem = tail.data;
      Node tempNode = head;
      while (tempNode.next != tail){
        tempNode = tempNode.next;
      }
      tail = tempNode;
      tail.next = null;
    }   
    size--;
    return removedItem;
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
