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
  public void addToEmptyDeque(){
    ArrayDeque<String> emptyDeque = new ArrayDeque<>();
    emptyDeque.addFirst("A string");
    if (emptyDeque.removeFirst().equals("A string")){
      assertTrue(true);
    }
    else{
      assertTrue(false);
    }
  }

  @Test
  public void addToFullDeque(){
    ArrayDeque<String> fullDeque = new ArrayDeque<>(1);
    fullDeque.addFirst("A string");
    fullDeque.addFirst("Another string");
    if (fullDeque.removeFirst().equals("Another string")){
      assertTrue(true);
    }
    else{
      assertTrue(false);
    }
  }

  @Test
  public void addToFullDequeBeyondMaxCapacity(){
    ArrayDeque<String> maxDeque = new ArrayDeque<>(10000);
    for (int i = 0; i < 10000; i++){
      maxDeque.addFirst("String number " + i);
    }
    try{
      maxDeque.addFirst("Another string");
      assertTrue(false);
    }
    catch(IllegalStateException e){
      assertTrue(true);
    }
  }

  @Test
  public void addToHalfFullDeque(){
    ArrayDeque<String> halfFullDeque = new ArrayDeque<>();
    final int HALF_DEFAULT_CAPACITY = 13;
    for (int i = 0; i < HALF_DEFAULT_CAPACITY; i++){
      halfFullDeque.addFirst("String number " + i);
    }
    if (halfFullDeque.removeFirst().equals("String number 12")){
      assertTrue(true);
    }
    else{
      assertTrue(false);
    }
  }
}

