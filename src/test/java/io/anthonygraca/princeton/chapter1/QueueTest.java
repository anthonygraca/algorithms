package io.anthonygraca.princeton.chapter1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class QueueTest {
  @Test
  public void shouldAnswerWithTrue() {
    Queue queue = new Queue();
    assertTrue( true );
  }
  
  @Test
  public void lowerBoundConstructorTest(){
    try{
      Queue queue = new Queue(-1);
    }
    catch(IllegalStateException e){
      assertTrue(true);
    }
  }

  @Test
  public void upperBoundConstructorTest(){
    try{
      Queue queue = new Queue(100000);
    }
    catch(IllegalStateException e){
      assertTrue(true);
    }
  }

  @Test
  public void withinBoundConstructorTest(){
    Queue queue1 = new Queue(1);
    Queue queue2 = new Queue(10);
    Queue queue3 = new Queue(100);
    Queue queue4 = new Queue(1000);
    Queue queue5 = new Queue(10000);
  }
}
