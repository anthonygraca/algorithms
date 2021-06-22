package io.anthonygraca.princeton.chapter2;

public class Selection extends Sort{
  /** 
   * This method implements the selection sort algorithm (n^2)
   * @param a The array being sorted
   */
  public static void sort(Comparable[] a)
  {
    for (int i = 0; i < a.length; i++)
    {
      int minIndex = i;
      // check every index to the right of the current index
      for (int j = i+1; j < a.length; j++)
      {
        // if an item is found to be smaller than the minimum...
        if (less(a[j], a[minIndex]))
        { // ...set that index as the new minimum index
          minIndex = j;
        }
      }
      // when the final, true minIndex is found, exchange contents with i
      exchange(a, i, minIndex);
      // now, i contains the smallest object everything right of the list
    }
  }
}

