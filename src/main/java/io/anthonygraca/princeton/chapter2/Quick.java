package io.anthonygraca.princeton.chapter2;

import java.util.Random;

public class Quick extends Sort{
  /**
   * This method implements the quick sort algorithm (nlog(n))
   * @param a The array being sorted
   */
  public static void sort(Comparable[] a){
    shuffle(a);
    sort(a, 0, a.length - 1);
  }

  /**
   * Shuffles the contents of an array using the Fisher-Yates shuffle
   * @param arr the array being shuffled
   */
  protected static void shuffle(Comparable[] arr){
    int swapIndex;
    Comparable temp;
    Random rng = new Random();
    // randomly pick an index >= the current index and swap contents
    for (int i = arr.length - 1; i > 0; i--){
      swapIndex = rng.nextInt(i + 1);
      if (swapIndex != i){
        temp = arr[swapIndex];
        arr[swapIndex] = arr[i];
        arr[i] = temp;
      }
    }
  }

  /**
   * Recursively sorts the subarrays of an array
   * @param a   the subarray being sorted
   * @param lo  the lower bound of the subarray
   * @param hi  the upper bound of the subarray
   */
  private static void sort(Comparable[] a, int lo, int hi){
    if (hi <= lo){
      return;
    }
    int j = partition(a, lo, hi);
    sort(a, lo, j - 1);
    sort(a, j + 1, hi);
  }

  /**
   * Takes the first item of a subarray and swaps items such that every item to the left of it is 
   * smaller and every item to the right of it is larger
   * @param a   the array being partitioned
   * @param lo  the lower bound of the subarray
   * @param hi  the upper bound of the subarray
   * @return the index of the item that splits both subarrays
   */
  protected static int partition(Comparable[] a, int lo, int hi){
    int i = lo;     // left scan index
    int j = hi + 1; // right scan index
    Comparable partitionItem = a[lo];

    while (true){
      // scan left -> right until an item > partitionItem is found
      while (less(a[++i], partitionItem)){
        if (i == hi){
          break;
        }
      }
      // scan right -> left until an item < partitionItem is found
      while (less(partitionItem, a[--j])){
        if (j == lo){
          break;
        }
      }
      // if already in place, exit
      if (i >= j){
        break;
      }
      // exchange so smaller item is left of partitionItem and larger item is to the right of it
      exchange(a, i, j);
    }
    exchange(a, lo, j); // places partitionItem in place
    return j;
  }
}

