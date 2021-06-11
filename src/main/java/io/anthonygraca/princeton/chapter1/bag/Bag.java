package io.anthonygraca.princeton.chapter1;

/*
 * This implementation of a bag, as per assignment specifications:
 *  1. Allows duplicates
 *  2. Does not support removing items
 *  3. Is unordered
 * Furthermore, it resembles a stack since that's easiest to implement,
 *  and order is irrelevant.
 */
public interface Bag<T> {
  /**
   * Adds an item to the bag
   * @param item  the item being added
   */
  public void add(T item);

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
