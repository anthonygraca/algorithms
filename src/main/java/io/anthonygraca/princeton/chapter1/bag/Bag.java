package io.anthonygraca.princeton.chapter1;

public interface Bag<T> {
  /**
   * Adds an item to the bag
   * @param item  the item being added
   */
  public void add(T item);

  /**
   * Removes a random item from the bag
   * @return the item that was removed
   * @throws  IllegalStateException if an item could not be removed 
   */
  public T remove();

  /**
   * Removes an instance of the item from the bag
   * @param item the item being removed
   * @return  the item that was removed
   * @throws  IllegalStateException if the item is not in the bag
   */
  public T remove(T item);

  /**
   * Checks if the bag is empty
   * @return  true if empty, false if not
   */
  public boolean isEmpty();

  /**
   * Finds the number of items currently in the bag
   * @return  the number of items currently in the bag
   */
  public int size();
}
