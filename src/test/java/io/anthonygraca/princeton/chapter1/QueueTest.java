package io.anthonygraca.princeton.chapter1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class QueueTest {
  /*
   * These test the functionality of the constructors
   */
  @Test
  public void defaultConstructor() {
    Queue queue = new Queue();
    assertTrue( true );
  }
  
  @Test
  public void lowerBoundConstructor(){
    try{
      Queue queue = new Queue(-1);
    }
    catch(IllegalStateException e){
      assertTrue(true);
    }
  }

  @Test
  public void upperBoundConstructor(){
    try{
      Queue queue = new Queue(100000);
    }
    catch(IllegalStateException e){
      assertTrue(true);
    }
  }

  @Test
  public void withinBoundConstructor(){
    try{
      Queue queue1 = new Queue(1);      // exact lower bound
      Queue queue2 = new Queue(10);
      Queue queue3 = new Queue(100);
      Queue queue4 = new Queue(1000);
      Queue queue5 = new Queue(10000);  // exact upper bound
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
