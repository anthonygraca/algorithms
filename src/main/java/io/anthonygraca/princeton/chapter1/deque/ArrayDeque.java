package io.anthonygraca.princeton.chapter1;

import java.util.NoSuchElementException;

public class ArrayDeque<T> {
  private int size = 0;

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
