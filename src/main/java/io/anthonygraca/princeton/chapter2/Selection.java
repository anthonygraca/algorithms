package io.anthonygraca.princeton.chapter2;

/*
 * Selection works by starting at an index, and scanning the contents to the right of the index
 *  for the global minimum value. Once the index that contains this value is found, the algorithm
 *  swaps the contents of the current index and the index with the minimum value.
 * The result is that everything to the left of the index is sorted. The algorithm then moves on to
 *  the next index, and scans the right of the container again, continuing in this fashion until
 *  the end of the container is reached and sorted.
 */
public class Selection extends Sort{
  /** 
   * This method implements the selection sort algorithm (n^2)
   * @param a The array being sorted
   */
  public static void sort(Comparable[] a){
    for (int i = 0; i < a.length; i++){
      int minIndex = i;
      for (int j = i+1; j < a.length; j++){
        if (less(a[j], a[minIndex])){ 
          minIndex = j;
        }
      }
      exchange(a, i, minIndex);
    }
  }
}

