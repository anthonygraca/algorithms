package io.anthonygraca.princeton.chapter2;

/*
 * Serves as a basic template for sorting classes to make it easier to compare different sorting 
 *  algorithms.
 */
public class Sort 
{
  /**
   * Sorts the items in an array; requires a specific implementation
   * @param a The array being sorted
   */
  public static void sort(Comparable[] a)
  {
    throw new RuntimeException("Requires a particular instance of Sort's child to run sort()");
  }

  /**
   * Determines whether the key of one item is less than the key of the other
   * @param v the item we're comparing
   * @param w the item that we're comparing to
   * @return true if v is less than w, false if not
   */
  public static boolean less(Comparable v, Comparable w)
  {
    @SuppressWarnings("unchecked")
    boolean isLess = v.compareTo(w) < 0;
    return isLess;
  }

  /**
   * Exchanges a set of items at two given indeces
   * @param a the array where the items live in
   * @param i the index of the item being swapped
   * @param j the index of the other item being swapped
   */
  public static void exchange(Comparable[] a, int i, int j)
  {
    Comparable temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  /**
   * Displays the contents of the array
   */
  public static void show(Comparable[] a)
  {
    for (int i = 0; i < a.length; i++)
    {
      System.out.print(a[i] + " ");
    }
    System.out.println();
  }

  /**
   * Determines whether or not the items in the array is sorted
   * @param a the array with the items that are being checked
   * @return true if the array is sorted, false if not
   */
  public static boolean isSorted(Comparable[] a)
  {
    boolean isSorted = true;
    int i = 1;
    while (i < a.length && isSorted)
    {
      if (less(a[i], a[i-1]))
        isSorted = false;
      i++;
    }
    return isSorted;
  }
}
