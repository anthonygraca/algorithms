package io.anthonygraca.princeton.chapter1;

public class ArrayBag<T> implements Bag<T>{
  private T[] bag;
  private int size;
  private final int DEFAULT_CAPACITY = 25;

  /**
   * Default constructor
   */
  public ArrayBag(){

  }

  /**
   * Adds an item to the bag
   * @param item  the item being added
   */
  public void add(T item){

  }

  /**
   * Checks if the bag is empty
   * @return  true if empty, false if not
   */
  public boolean isEmpty(){
    return true;
  }

  /**
   * Finds the number of items currently in the bag
   * @return  the number of items currently in the bag
   */
  public int size(){
    return 0;
  }
}
