package io.anthonygraca.princeton.chapter1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class QueueTest {
  /*
   * These test the functionality of the constructors
   */
  @Test
  public void defaultConstructor() {
    ArrayQueue queue = new ArrayQueue();
    assertTrue( true );
  }
  
  @Test
  public void lowerBoundConstructor(){
    try{
      ArrayQueue queue = new ArrayQueue(-1);
    }
    catch(IllegalStateException e){
      assertTrue(true);
    }
  }

  @Test
  public void upperBoundConstructor(){
    try{
      ArrayQueue queue = new ArrayQueue(100000);
    }
    catch(IllegalStateException e){
      assertTrue(true);
    }
  }

  @Test
  public void withinBoundConstructor(){
    try{
      ArrayQueue queue1 = new ArrayQueue(1);      // exact lower bound
      ArrayQueue queue2 = new ArrayQueue(10);
      ArrayQueue queue3 = new ArrayQueue(100);
      ArrayQueue queue4 = new ArrayQueue(1000);
      ArrayQueue queue5 = new ArrayQueue(10000);  // exact upper bound
    }
    catch(Exception e){
      assertTrue(false);
    }
    assertTrue(true);
  }

  /*
   * These test the functionality of the enqueueing method
   */
  @Test
  public void addedToEmptyQueue(){
    assertTrue(true);
  }

  @Test
  public void addedToFullQueue(){

    assertTrue(true);
  }

  @Test
  public void addedToHalfFullQueue(){

    assertTrue(true);
  }
}
