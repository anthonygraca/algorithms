package io.anthonygraca.princeton.chapter2;

/*
 * The core of this algorithm is the merge method; it's a classic divide-and-conquer problem where 
 *  merge is able to take two sorted subarrays merge them together into one whole sorted array. The 
 *  ability for this method to do this lies in the fact that one item alone is already sorted. So 
 *  scaled up, it can merge two items, then merge four items, etc. until n items have been merged.
 * An auxiliary array is used since in-place merges are very complex.
 */
public class Merge extends Sort{
  private static Comparable[] aux;
  /**
   * This method implements the merge sort algorithm (nlog(n))
   * @param a the array being sorted
   */
  public static void sort(Comparable[] a){
    aux = new Comparable[a.length];
    sort(a, 0, a.length - 1);
  }

  /**
   * Recursively sorts the subarrays of the array, then merges those subarrays
   * @param a   the array being sorted
   * @param lo  the beginning of the subarray
   * @param hi  the end of the subarray
   */
  private static void sort(Comparable[] a, int lo, int hi){
    if (hi <= lo){
      return;
    }
    else{
      int mid = lo + (hi - lo) / 2; // overflow-safe way of getting avg value of lo and hi
      sort(a, lo, mid);             // recursively sort lower half
      sort(a, mid+1, hi);           // recursively sort upper half
      merge(a, lo, mid, hi);        // merge sorted lower and upper halves
    }
  }

  /**
   * This method merges two sorted subarrays into one whole sorted array
   * @param a   the array being sorted
   * @param lo  the beginning of the lower subarray
   * @param mid the end of the lower subarray (+1 is the beginning of the upper subarray)
   * @param hi  the end of the upper subarray
   */
  private static void merge(Comparable[] a, int lo, int mid, int hi){
    int i = lo;
    int j = mid + 1;

    // copy contents of a into aux
    for (int k = lo; k <= hi; k++){
      aux[k] = a[k];
    }

    // merge the two sorted subarrays
    for (int k = lo; k <= hi; k++){
      // if the lower subarray is finished, just take from the upper subarray
      if (i > mid){
        a[k] = aux[j++];
      }
      // if the upper subarray is finished, just take from the lower subarray
      else if (j > hi){
        a[k] = aux[i++];
      }
      // if the upper subarray has a smaller item than the lower subarray, take from the upper
      else if (less(aux[j], aux[i])){
        a[k] = aux[j++];
      }
      // if the lower subarray has a smaller item than the upper subarray, take from the lower
      else{
        a[k] = aux[i++];
      }
    }
  }
}

