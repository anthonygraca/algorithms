package io.anthonygraca.princeton.chapter1;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.NoSuchElementException;

public class QueueTest {
  /*
   * These test the functionality of the constructors
   */
  @Test
  public void defaultConstructor() {
    ArrayQueue queue = new ArrayQueue();
    assertTrue( true );
  }
  
  @Test(expected=IllegalStateException.class)
  public void lowerBoundConstructor(){
    ArrayQueue queue = new ArrayQueue(-1);
  }

  @Test(expected=IllegalStateException.class)
  public void upperBoundConstructor(){
    ArrayQueue queue = new ArrayQueue(100000);
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
  public void addToEmptyQueue(){
    ArrayQueue<String> emptyQueue = new ArrayQueue<>();
    emptyQueue.enqueue("A string");
    assertTrue(emptyQueue.getFront().equals("A string"));
  }

  @Test
  public void addToFullQueue(){
    ArrayQueue<String> fullQueue = new ArrayQueue<>(1);
    fullQueue.enqueue("A string");
    fullQueue.enqueue("Another string");
    fullQueue.dequeue();
    assertTrue(fullQueue.getFront().equals("Another string"));
  }

  @Test(expected=IllegalStateException.class)
  public void addToFullQueueBeyondMaxCapacity(){
    ArrayQueue<String> maxQueue = new ArrayQueue<>(10000);
    for (int i = 0; i < 10000; i++){
      maxQueue.enqueue("String number " + i);
    }
    maxQueue.enqueue("Another string");
  }

  @Test
  public void addToHalfFullQueue(){
    ArrayQueue<String> halfFullQueue = new ArrayQueue<>();
    final int HALF_DEFAULT_CAPACITY = 13;
    for (int i = 0; i < HALF_DEFAULT_CAPACITY; i++){
      halfFullQueue.enqueue("String number " + i);
    }
    assertTrue(halfFullQueue.getFront().equals("String number 0"));
  }

  /*
   * These test the functionality of the getFront method
   */
  @Test(expected=NoSuchElementException.class)
  public void getFrontOfEmptyQueue()
  {
    ArrayQueue<String> emptyQueue = new ArrayQueue<>();
    emptyQueue.getFront();
  }

  @Test
  public void getFrontOfQueueWithOneElement()
  {
    ArrayQueue<String> queueWithOneElement = new ArrayQueue<>(1);
    queueWithOneElement.enqueue("A string");
    assertTrue(queueWithOneElement.getFront().equals("A string"));
  }

  @Test
  public void getFrontOfOverflowedQueue(){
    ArrayQueue<String> queue = new ArrayQueue<>(2);
    queue.enqueue("A string");
    queue.enqueue("Another string");
    queue.enqueue("Another another string");
    queue.dequeue();
    assertTrue(queue.getFront().equals("Another string"));
  }

  /*
   * These test the functionality of the dequeue method
   */
  @Test
  public void dequeueToEmpty(){
    ArrayQueue<String> filledQueue = new ArrayQueue<>(1);
    filledQueue.enqueue("A string");
    assertTrue(filledQueue.dequeue().equals("A string") && filledQueue.isEmpty());
  }

  @Test(expected=IllegalStateException.class)
  public void dequeueFailsForEmpty(){
    ArrayQueue<String> emptyQueue = new ArrayQueue<>();
    emptyQueue.dequeue();
  }

  /*
   * These test the functionality of the isEmpty and isFull methods
   */
  @Test
  public void emptyWhenDeclared(){
    ArrayQueue<String> emptyQueue = new ArrayQueue<>();
    assertTrue(emptyQueue.isEmpty());
  }

  @Test
  public void emptyWhenDequeued(){
    ArrayQueue<String> queue = new ArrayQueue<>();
    queue.enqueue("A string");
    queue.dequeue();
    assertTrue(queue.isEmpty());
  }

  @Test
  public void fullWhenFilled(){
    ArrayQueue fullQueue = new ArrayQueue<>(1);
    fullQueue.enqueue("A string");
    assertTrue(fullQueue.isFull());
  }
}
