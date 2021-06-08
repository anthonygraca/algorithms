package io.anthonygraca.princeton.chapter1;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.NoSuchElementException;

import org.junit.Test;

public class MGracaDequeTest {
  /*
   * These test the functionality of the constructors
   */
  @Test
  public void arrayDefaultConstructor(){
    ArrayDeque deque = new ArrayDeque();
    assertTrue(deque.size() == 0);
  }

  @Test
  public void linkedDefaultConstructor(){
    LinkedDeque deque = new LinkedDeque();
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
  public void arrayEmptyWhenEmptied(){
    ArrayDeque<String> deque = new ArrayDeque<>(2);
    deque.addFirst("A string");
    deque.addFirst("Another string");
    deque.removeFirst();
    deque.removeFirst();
    assertTrue(deque.isEmpty());
  }

  @Test
  public void linkedEmptyWhenEmptied(){
    LinkedDeque<String> deque = new LinkedDeque<>();
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
  public void arrayGetFirstFailsForEmptyDeque(){
    ArrayDeque<String> emptyDeque = new ArrayDeque<>();
    emptyDeque.getFirst();
  }

  @Test(expected=NoSuchElementException.class)
  public void arrayGetLastFailsForEmptyDeque(){
    ArrayDeque<String> emptyDeque = new ArrayDeque<>();
    emptyDeque.getLast();
  }

  @Test
  public void arrayGetFirstSucceedsAfterAddFirst(){
    ArrayDeque<String> deque = new ArrayDeque<>();
    deque.addFirst("A string");
    assertTrue(deque.getFirst().equals("A string"));
  }

  @Test
  public void arrayGetFirstSucceedsAfterAddLast(){
    ArrayDeque<String> deque = new ArrayDeque<>();
    deque.addLast("A string");
    assertTrue(deque.getFirst().equals("A string"));   
  }

  @Test
  public void arrayGetLastSucceedsAfterAddFirst(){
    ArrayDeque<String> deque = new ArrayDeque<>();
    deque.addFirst("A string");
    assertTrue(deque.getLast().equals("A string"));
  }

  @Test
  public void arrayGetLastSucceedsAfterAddLast(){
    ArrayDeque<String> deque = new ArrayDeque<>();
    deque.addLast("A string");
    assertTrue(deque.getLast().equals("A string"));
  }

  @Test
  public void arrayGetFirstAndGetLastSucceedForOneItem(){
    ArrayDeque<String> deque = new ArrayDeque<>();
    deque.addFirst("A string");
    assertTrue(deque.getFirst().equals("A string") && deque.getLast().equals("A string"));
  }

  @Test
  public void arrayGetFirstSucceedsAfterOverflow(){
    ArrayDeque<String> deque = new ArrayDeque<>(2);
    deque.addFirst("A string");
    deque.addFirst("Another string");
    deque.addLast("Another another string");
    assertTrue(deque.getFirst().equals("Another string"));
  }

  @Test
  public void arrayGetLastSucceedsAfterOverflow(){
    ArrayDeque<String> deque = new ArrayDeque<>(2);
    deque.addFirst("A string");
    deque.addLast("Another string");
    deque.addFirst("Another another string");
    assertTrue(deque.getLast().equals("Another string"));
  }

  @Test(expected=NoSuchElementException.class)
  public void linkedGetFirstFailsForEmptyDeque(){
    LinkedDeque<String> emptyDeque = new LinkedDeque<>();
    emptyDeque.getFirst();
  }

  @Test(expected=NoSuchElementException.class)
  public void linkedGetLastFailsForEmptyDeque(){
    LinkedDeque<String> emptyDeque = new LinkedDeque<>();
    emptyDeque.getLast();
  }

  @Test
  public void linkedGetFirstSucceedsAfterAddFirst(){
    LinkedDeque<String> deque = new LinkedDeque<>();
    deque.addFirst("A string");
    assertTrue(deque.getFirst().equals("A string"));
  }

  @Test
  public void linkedGetFirstSucceedsAfterAddLast(){
    LinkedDeque<String> deque = new LinkedDeque<>();
    deque.addLast("A string");
    assertTrue(deque.getFirst().equals("A string"));   
  }

  @Test
  public void linkedGetLastSucceedsAfterAddFirst(){
    LinkedDeque<String> deque = new LinkedDeque<>();
    deque.addFirst("A string");
    assertTrue(deque.getLast().equals("A string"));
  }

  @Test
  public void linkedGetLastSucceedsAfterAddLast(){
    LinkedDeque<String> deque = new LinkedDeque<>();
    deque.addLast("A string");
    assertTrue(deque.getLast().equals("A string"));
  }

  @Test
  public void linkedGetFirstAndGetLastSucceedForOneItem(){
    LinkedDeque<String> deque = new LinkedDeque<>();
    deque.addFirst("A string");
    assertTrue(deque.getFirst().equals("A string") && deque.getLast().equals("A string"));
  }

  @Test
  public void linkedGetFirstSucceedsAfterFilled(){
    LinkedDeque<String> deque = new LinkedDeque<>();
    deque.addFirst("A string");
    deque.addFirst("Another string");
    deque.addLast("Another another string");
    assertTrue(deque.getFirst().equals("Another string"));
  }

  @Test
  public void linkedGetLastSucceedsAfterFilled(){
    LinkedDeque<String> deque = new LinkedDeque<>();
    deque.addFirst("A string");
    deque.addLast("Another string");
    deque.addFirst("Another another string");
    assertTrue(deque.getLast().equals("Another string"));
  }

  /*
   * These test the functionality of the remove methods
   */
  @Test
  public void arrayRemoveFirstToEmpty(){
    ArrayDeque<String> filledDeque = new ArrayDeque<>(1);
    filledDeque.addFirst("A string");
    assertTrue(filledDeque.removeFirst().equals("A string") && filledDeque.isEmpty());
  }

  @Test(expected=IllegalStateException.class)
  public void arrayRemoveFirstFailsForEmpty(){
    ArrayDeque<String> emptyDeque = new ArrayDeque<>();
    emptyDeque.removeFirst();
  }

  @Test
  public void arrayRemoveLastToEmpty(){
    ArrayDeque<String> filledDeque = new ArrayDeque<>(1);
    filledDeque.addFirst("A string");
    assertTrue(filledDeque.removeLast().equals("A string") && filledDeque.isEmpty());
  }

  @Test(expected=IllegalStateException.class)
  public void arrayRemoveLastFailsForEmpty(){
    ArrayDeque<String> emptyDeque = new ArrayDeque<>();
    emptyDeque.removeLast();
  }

  @Test
  public void linkedRemoveFirstToEmpty(){
    LinkedDeque<String> filledDeque = new LinkedDeque<>();
    filledDeque.addFirst("A string");
    assertTrue(filledDeque.removeFirst().equals("A string") && filledDeque.isEmpty());
  }

  @Test(expected=IllegalStateException.class)
  public void linkedRemoveFirstFailsForEmpty(){
    LinkedDeque<String> emptyDeque = new LinkedDeque<>();
    emptyDeque.removeFirst();
  }

  @Test
  public void linkedRemoveLastToEmpty(){
    LinkedDeque<String> filledDeque = new LinkedDeque<>();
    filledDeque.addFirst("A string");
    assertTrue(filledDeque.removeLast().equals("A string") && filledDeque.isEmpty());
  }

  @Test(expected=IllegalStateException.class)
  public void linkedRemoveLastFailsForEmpty(){
    LinkedDeque<String> emptyDeque = new LinkedDeque<>();
    emptyDeque.removeLast();
  }

  /*
   * These test the functionality of the addFirst method
   */
  @Test
  public void arrayAddFirstToEmptyDeque(){
    ArrayDeque<String> emptyDeque = new ArrayDeque<>();
    emptyDeque.addFirst("A string");
    assertTrue(emptyDeque.getFirst().equals("A string"));
  }

  @Test
  public void linkedAddFirstToEmptyDeque(){
    LinkedDeque<String> emptyDeque = new LinkedDeque<>();
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
  public void arrayAddLastToEmptyDeque(){
    ArrayDeque<String> emptyDeque = new ArrayDeque<>();
    emptyDeque.addLast("A string");
    assertTrue(emptyDeque.getFirst().equals("A string"));
  }

  @Test
  public void linkedAddLastToEmptyDeque(){
    LinkedDeque<String> emptyDeque = new LinkedDeque<>();
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
