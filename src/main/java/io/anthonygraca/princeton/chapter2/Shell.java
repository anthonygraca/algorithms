package io.anthonygraca.princeton.chapter2;

/*
 * This is a variation of insertion sort. An issue with insertion sort is if the minimum value is
 *  far away, it will take a huge amount of swaps since insertion only swaps with adjacent items.
 * To remedy this, shell sort enables swapping with items farther away than adjacent. In effect, 
 *  it partially sorts the array based off of how far you set the divisions.
 *    e.g. 0th, 3rd, 6th, 9th elements are sorted relative to each other, then 1st, 4th, 7th 
 *    elements are sorted, etc... until you get an array that is partially sorted, which is more
 *    convenient for insertion sort to handle because there are less adjacent swaps
 * In summation, shell sort makes insertion sort easier by allowing larger gaps in each swap before
 *  finally using insertion sort proper
 */
public class Shell extends Sort{
  /**
   * This method implements the shell sort algorithm (n^2), but lower average case than insertion
   * @param a The array being sorted
   */
  public static void sort(Comparable[] a){
    int h = 1;
    // determine size of gap
    while (h < a.length / 3){
      h = 3 * h + 1;  // 1, 4, 13, 40, 121, 364, ...
    }
    // sort based off of given gap size
    while (h >= 1){
      for (int i = 0; i < a.length; i++){
        for (int j = i; j >= h && less(a[j], a[j-h]); j -= h){
          exchange(a, j, j-h);
        }
      }
      h /= 3;
    }
  }
}

