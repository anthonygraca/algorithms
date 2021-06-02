package io.anthonygraca.princeton.chapter1;

public interface Queue<T>
{
  /** 
   * Adds a new entry to the back of the queue
   * @param newEntry  the entry to be added
   */
  public void enqueue(T newEntry);

  /** 
   * Removes and returns the entry at the front of the queue
   * @return  the entry at the front of the queue */
  public T dequeue();

  /** 
   * Retrieves the queue's front entry
   * @return  the queue's front entry 
   */
  public T getFront();

  /** 
   * Checks whether the queue is empty
   * @return  true if the queue is empty, false if not */
  public boolean isEmpty();

  /** 
   * Removes all the entries of the queue
   */
  public void clear();
}
