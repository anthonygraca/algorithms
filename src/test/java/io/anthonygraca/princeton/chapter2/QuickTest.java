package io.anthonygraca.princeton.chapter2;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.Random;

public class QuickTest{
  @Test
  public void emptyList(){
    Integer[] arr = new Integer[0];
    Quick.sort(arr);
    assertTrue(true);
  }

  @Test
  public void oneObjectInList(){
    Integer[] arr = new Integer[1];
    arr[0] = 5;
    Quick.sort(arr);
    assertTrue(arr[0] == 5);
  }

  @Test
  public void alreadySorted(){
    // populate array from 0 to 99
    Integer[] arr = new Integer[100];
    for (int i = 0; i < arr.length; i++){
      arr[i] = i;
    }
    Quick.sort(arr);
    assertTrue(Sort.isSorted(arr));
  }

  @Test
  public void reverseSorted(){
    // populate array from 100 to 1
    Integer[] arr = new Integer[100];
    for (int i = 0; i < arr.length; i++){
      arr[i] = arr.length - i;
    }
    Quick.sort(arr);
    assertTrue(Sort.isSorted(arr));
  }

  @Test
  public void sortedThenUnsorted(){
    // populate array from 100 to 1
    Integer[] arr = new Integer[100];
    for (int i = 0; i < arr.length; i++){
      arr[i] = arr.length - i;
    }
    Quick.sort(arr);
    arr[0] = 13;
    assertTrue(!Sort.isSorted(arr));
  }

  @Test(expected=NullPointerException.class)
  public void halfFullList(){
    Integer[] arr = new Integer[100];
    for (int i = 0; i < arr.length / 2; i++){
      arr[i] = i;
    }
    Quick.sort(arr);
    assertTrue(Sort.isSorted(arr));
  }

  @Test
  public void randomWithDuplicates(){
    Integer[] arr = new Integer[100];
    Random rng = new Random(135);
    for (int i = 0; i < arr.length; i++){
      arr[i] = rng.nextInt();
    }
    arr[0] = arr[1] = arr[2] = 12;
    arr[10] = arr[15] = arr[34] = 95;
    Quick.sort(arr);
    assertTrue(Sort.isSorted(arr));

  }

  @Test
  public void randomTest1(){
    Integer[] arr = new Integer[100];
    Random rng = new Random(135);
    for (int i = 0; i < arr.length; i++){
      arr[i] = rng.nextInt();
    }
    Quick.sort(arr);
    assertTrue(Sort.isSorted(arr));
  }

  @Test
  public void randomTest2(){
    Integer[] arr = new Integer[100];
    Random rng = new Random(57983);
    for (int i = 0; i < arr.length; i++){
      arr[i] = rng.nextInt();
    }
    Quick.sort(arr);
    assertTrue(Sort.isSorted(arr));
 }

  @Test
  public void randomTest3(){
    Integer[] arr = new Integer[100];
    Random rng = new Random(39805);
    for (int i = 0; i < arr.length; i++){
      arr[i] = rng.nextInt();
    }
    Quick.sort(arr);
    assertTrue(Sort.isSorted(arr));
 }

  @Test
  public void randomTest4(){
    Integer[] arr = new Integer[100];
    Random rng = new Random(1913095);
    for (int i = 0; i < arr.length; i++){
      arr[i] = rng.nextInt();
    }
    Quick.sort(arr);
    assertTrue(Sort.isSorted(arr));
 }

 /*
  * Testing helper methods
  */
 @Test
 public void shuffled(){
   Integer[] arr = new Integer[100];
   for (int i = 0; i < arr.length; i++){
     arr[i] = i;
   }
   Quick.shuffle(arr);
   assertTrue(!Sort.isSorted(arr));
 }

 @Test
 public void partitionItemPlacedInProperLocation(){
   Integer[] arr = new Integer[100];
   for (int i = 0; i < arr.length; i++){
     arr[i] = i;
   }
   arr[10] = 0;
   arr[0] = 10;
   assertTrue(Quick.partition(arr, 0, arr.length - 1) == 10);
 }
}
