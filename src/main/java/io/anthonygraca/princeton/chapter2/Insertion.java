package io.anthonygraca.princeton.chapter2;

/*
 * Instead of finding a global minimum, Insertion works by comparing two items side by side;
 *  if the item at the right is smaller, then it swaps places with the item at the left.
 *  After swapping, it compares itself with the item to the left of it. Again, if it is smaller, it
 *  swaps places. This continues until the item to the left of it is smaller.
 *  Then it returns to the index where it initially began, increments, and compares again until that
 *  item is placed properly.
 * In summation, the name of the game is local swapping until the item belongs, relative to the 
 *  items left of the current index.
 */
public class Insertion extends Sort{
  /**
   * This method implements the insertion sort algorithm (n^2)
   * @param a The array being sorted
   */
  public static void sort(Comparable[] a){
    for (int i = 1; i < a.length; i++){
      int j = i;
      Comparable temp = a[j];
      while (j > 0 && less(temp, a[j-1])){
        exchange(a, j, j-1);
        j--;
      }
      a[j] = temp;
    }
  }
}
