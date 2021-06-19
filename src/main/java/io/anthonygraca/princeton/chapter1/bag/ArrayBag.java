package io.anthonygraca.princeton.chapter1.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class ArrayBag<T> implements Bag<T>, Iterable<T>{
  private T[] bag;
  private int size;
  private final int DEFAULT_CAPACITY = 25;

  /**
   * Default constructor
   */
  public ArrayBag(){
    @SuppressWarnings("unchecked")
    T[] tempBag = (T[])new Object[DEFAULT_CAPACITY];
    bag = tempBag;
    size = 0;
  }

  /**
   * Adds an item to the bag
   * @param item  the item being added
   */
  public void add(T item){
    if (isFull()){
      resize(2*size);
    }
    bag[size++] = item;
  }

  /**
   * Changes the capacity of the bag
   */
  private void resize(int n){
    @SuppressWarnings("unchecked")
    T[] tempBag = (T[])new Object[n];
    for (int i = 0; i < size; i++){
      tempBag[i] = bag[i];
    }
    bag = tempBag;
  }

  /**
   * Removes a random item from the bag
   * @return the item that was removed
   * @throws IllegalStateExeption if the bag is empty
   */
  public T remove(){
    T removedItem = null;
    if (isEmpty()){
      throw new IllegalStateException("Cannot remove an item from an empty bag");
    }
    else{
      // get a random index of the bag
      Random rng = new Random();
      int index = rng.nextInt(size);
      removedItem = bag[index];
      
      // shift every item to the left, overwriting the removed item
      size--;
      while (index < size){
        bag[index] = bag[++index];
      }

      // resize bag if it is more than half empty
      if (size * 2 < bag.length){
        resize(size);
      }
    }
    return removedItem;
  }

  /** 
   * Removes a particular item from the bag
   * @param item the item being removed
   * @return true if the item was removed, false if not
   * @throws IllegalStateException if the bag is empty or the item couldn't be removed
   */
  public T remove(T item){
    T removedItem = null;
    if (isEmpty()){
      throw new IllegalStateException("Cannot remove an item from an empty bag");
    }
    else{
      boolean found = false;
      int i = 0;
      while (!found && i < size){
        if (bag[i].equals(item)){
          found = true;
          removedItem = bag[i];
        }
        else{
          i++;
        }
      }

      if (found){
        size--;
        while (i < size){
          bag[i] = bag[++i];
        }
        if (size * 2 < bag.length){
          resize(size);
        }
      }
      else{
        throw new IllegalStateException("Could not find item");
      }
    }
    return removedItem;
  }

  /**
   * Checks if the bag is empty
   * @return  true if empty, false if not
   */
  public boolean isEmpty(){
    return size == 0;
  }

  /**
   * Returns the item at the top of the bag
   * @return the item at the top of the bag
   * @throws NoSuchElementException if the bag is empty
   */
  public T getItem(){
    if (isEmpty()){
      throw new NoSuchElementException();
    }
    else{
      return bag[size - 1];
    }
  }

  /**
   * Checks if the bag is full
   * @return true if full, false if not
   */
  private boolean isFull(){
    return size == bag.length;
  }

  /**
   * Finds the number of items currently in the bag
   * @return  the number of items currently in the bag
   */
  public int size(){
    return size;
  }

  /**
   * Returns an iterator that iterates over the items in the bag arbitrarily
   * @return an iterator that iterates over the items in the bag arbitrarily
   */
  public Iterator<T> iterator(){
    return new ArrayIterator();
  }

  private class ArrayIterator implements Iterator<T>{
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
      return bag[i++];
    }
  }
}
