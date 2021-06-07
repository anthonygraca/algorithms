package io.anthonygraca.princeton.chapter1;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.NoSuchElementException;

import org.junit.Test;

public class ArrayDequeTest {
  /*
   * These test the functionality of the constructors
   */
  @Test
  public void defaultConstructor(){
    ArrayDeque deque = new ArrayDeque();
    assertTrue(deque.size() == 0);
  }

  @Test(expected=IllegalStateException.class)
  public void lowerBoundConstructor(){
    ArrayDeque deque = new ArrayDeque(-1);
  }

  @Test(expected=IllegalStateException.class)
  public void upperBoundConstructor(){
    ArrayDeque deque = new ArrayDeque(100000);
  }

  @Test
  public void withinBoundConstructor(){
    try{
      ArrayDeque deque1 = new ArrayDeque(1);      // exact lower bound
      ArrayDeque deque2 = new ArrayDeque(10);
      ArrayDeque deque3 = new ArrayDeque(100);
      ArrayDeque deque4 = new ArrayDeque(1000);
      ArrayDeque deque5 = new ArrayDeque(10000);  // exact upper bound
    }
    catch(Exception e){
      assertTrue(false);
    }
    assertTrue(true);
  }

  /*
   * Tests the functionality of the full and empty methods
   */
  @Test
  public void emptyWhenEmptied(){
    ArrayDeque<String> deque = new ArrayDeque<>(2);
    deque.addFirst("A string");
    deque.addFirst("Another string");
    deque.removeFirst();
    deque.removeFirst();
    assertTrue(deque.isEmpty());
  }

  @Test
  public void fullWhenFilled(){
    ArrayDeque<String> deque = new ArrayDeque<>(2);
    deque.addFirst("A string");
    deque.addFirst("Another string");
    assertTrue(deque.isFull());
  }

  /*
   * These test the functionality of the getFirst and getLast methods
   */
  @Test(expected=NoSuchElementException.class)
  public void getFirstFailsForEmptyDeque(){
    ArrayDeque<String> emptyDeque = new ArrayDeque<>();
    emptyDeque.getFirst();
  }

  @Test(expected=NoSuchElementException.class)
  public void getLastFailsForEmptyDeque(){
    ArrayDeque<String> emptyDeque = new ArrayDeque<>();
    emptyDeque.getLast();
  }

  @Test
  public void getFirstSucceedsAfterAddFirst(){
    ArrayDeque<String> deque = new ArrayDeque<>();
    deque.addFirst("A string");
    assertTrue(deque.getFirst().equals("A string"));
  }

  @Test
  public void getFirstSucceedsAfterAddLast(){
    ArrayDeque<String> deque = new ArrayDeque<>();
    deque.addLast("A string");
    assertTrue(deque.getFirst().equals("A string"));   
  }

  @Test
  public void getLastSucceedsAfterAddFirst(){
    ArrayDeque<String> deque = new ArrayDeque<>();
    deque.addFirst("A string");
    assertTrue(deque.getLast().equals("A string"));
  }

  @Test
  public void getLastSucceedsAfterAddLast(){
    ArrayDeque<String> deque = new ArrayDeque<>();
    deque.addLast("A string");
    assertTrue(deque.getLast().equals("A string"));
  }

  @Test
  public void getFirstAndGetLastSucceedForOneItem(){
    ArrayDeque<String> deque = new ArrayDeque<>();
    deque.addFirst("A string");
    assertTrue(deque.getFirst().equals("A string") && deque.getLast().equals("A string"));
  }

  /*
   * These test the functionality of the remove methods
   */
  @Test
  public void removeFirstToEmpty(){
    ArrayDeque<String> filledDeque = new ArrayDeque<>(1);
    filledDeque.addFirst("A string");
    if (filledDeque.removeFirst().equals("A string") && filledDeque.isEmpty()){
        assertTrue(true);
    }
    else{
      assertTrue(false);
    }
  }

  @Test(expected=IllegalStateException.class)
  public void dequeueFailsForEmpty(){
    ArrayDeque<String> emptyDeque = new ArrayDeque<>();
    emptyDeque.removeFirst();
  }

  /*
   * These test the functionality of the addFirst method
   */
  @Test
  public void addFirstToEmptyDeque(){
    ArrayDeque<String> emptyDeque = new ArrayDeque<>();
    emptyDeque.addFirst("A string");
    assertTrue(emptyDeque.getFirst().equals("A string"));
  }

  @Test
  public void addFirstToFullDeque(){
    ArrayDeque<String> fullDeque = new ArrayDeque<>(1);
    fullDeque.addFirst("A string");
    fullDeque.addFirst("Another string");
    assertTrue(fullDeque.getFirst().equals("Another string"));
  }

  @Test(expected=IllegalStateException.class)
  public void addFirstToFullDequeBeyondMaxCapacity(){
    ArrayDeque<String> maxDeque = new ArrayDeque<>(10000);
    for (int i = 0; i < 10000; i++){
      maxDeque.addFirst("String number " + i);
    }
    maxDeque.addFirst("Another string");
  }

  @Test
  public void addFirstToHalfFullDeque(){
    ArrayDeque<String> halfFullDeque = new ArrayDeque<>();
    final int HALF_DEFAULT_CAPACITY = 13;
    for (int i = 0; i < HALF_DEFAULT_CAPACITY; i++){
      halfFullDeque.addFirst("String number " + i);
    }
    assertTrue(halfFullDeque.getFirst().equals("String number 12"));
  }

  /*
   * These test the functionality of the addLast method
   */
  @Test
  public void addLastToEmptyDeque(){
    ArrayDeque<String> emptyDeque = new ArrayDeque<>();
    emptyDeque.addLast("A string");
    assertTrue(emptyDeque.getFirst().equals("A string"));
  }

  @Test
  public void addLastToFullDeque(){
    ArrayDeque<String> fullDeque = new ArrayDeque<>(1);
    fullDeque.addLast("A string");
    fullDeque.addLast("Another string");
    assertTrue(fullDeque.getLast().equals("Another string"));
  }

  @Test(expected=IllegalStateException.class)
  public void addLastToFullDequeBeyondMaxCapacity(){
    ArrayDeque<String> maxDeque = new ArrayDeque<>(10000);
    for (int i = 0; i < 10000; i++){
      maxDeque.addLast("String number " + i);
    }
    maxDeque.addLast("Another string");
  }

  @Test
  public void addLastToHalfFullDeque(){
    ArrayDeque<String> halfFullDeque = new ArrayDeque<>();
    final int HALF_DEFAULT_CAPACITY = 13;
    for (int i = 0; i < HALF_DEFAULT_CAPACITY; i++){
      halfFullDeque.addLast("String number " + i);
    }
    assertTrue(halfFullDeque.getLast().equals("String number 12"));
  }
}

