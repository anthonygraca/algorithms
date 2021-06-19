package io.anthonygraca.princeton.chapter1.queue;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.NoSuchElementException;

public class QueueTest {
  /*
   * These test the functionality of the constructors
   */
  @Test
  public void arrayDefaultConstructor() {
    ArrayQueue queue = new ArrayQueue();
    assertTrue( true );
  }

  @Test
  public void linkedDefaultConstructor(){
    LinkedQueue queue = new LinkedQueue();
    assertTrue(true);
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
  public void arrayAddToEmptyQueue(){
    ArrayQueue<String> emptyQueue = new ArrayQueue<>();
    emptyQueue.enqueue("A string");
    assertTrue(emptyQueue.getFront().equals("A string"));
  }

  @Test
  public void linkedAddToEmptyQueue(){
    LinkedQueue<String> emptyQueue = new LinkedQueue<>();
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
  public void arrayGetFrontOfEmptyQueue()
  {
    ArrayQueue<String> emptyQueue = new ArrayQueue<>();
    emptyQueue.getFront();
  }

  @Test(expected=NoSuchElementException.class)
  public void linkedGetFrontOfEmptyQueue()
  {
    LinkedQueue<String> emptyQueue = new LinkedQueue<>();
    emptyQueue.getFront();
  }

  @Test
  public void arrayGetFrontOfQueueWithOneElement()
  {
    ArrayQueue<String> queueWithOneElement = new ArrayQueue<>(1);
    queueWithOneElement.enqueue("A string");
    assertTrue(queueWithOneElement.getFront().equals("A string"));
  }

  @Test
  public void linkedGetFrontOfQueueWithOneElement()
  {
    LinkedQueue<String> queueWithOneElement = new LinkedQueue<>();
    queueWithOneElement.enqueue("A string");
    assertTrue(queueWithOneElement.getFront().equals("A string"));
  }

  @Test
  public void arrayGetFrontOfOverflowedQueue(){
    ArrayQueue<String> queue = new ArrayQueue<>(2);
    queue.enqueue("A string");
    queue.enqueue("Another string");
    queue.enqueue("Another another string");
    queue.dequeue();
    assertTrue(queue.getFront().equals("Another string"));
  }

  @Test
  public void linkedGetFrontOfFilledQueue(){
    LinkedQueue<String> queue = new LinkedQueue<>();
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
  public void arrayDequeueToEmpty(){
    ArrayQueue<String> filledQueue = new ArrayQueue<>(1);
    filledQueue.enqueue("A string");
    assertTrue(filledQueue.dequeue().equals("A string") && filledQueue.isEmpty());
  }

  @Test
  public void linkedDequeueToEmpty(){
    LinkedQueue<String> filledQueue = new LinkedQueue<>();
    filledQueue.enqueue("A string");
    assertTrue(filledQueue.dequeue().equals("A string") && filledQueue.isEmpty());
  }
 
  @Test(expected=IllegalStateException.class)
  public void arrayDequeueFailsForEmpty(){
    ArrayQueue<String> emptyQueue = new ArrayQueue<>();
    emptyQueue.dequeue();
  }

  @Test(expected=IllegalStateException.class)
  public void linkedDequeueFailsForEmpty(){
    LinkedQueue<String> emptyQueue = new LinkedQueue<>();
    emptyQueue.dequeue();
  }
  
  /*
   * These test the functionality of the isEmpty and isFull methods
   */
  @Test
  public void arrayEmptyWhenDeclared(){
    ArrayQueue<String> emptyQueue = new ArrayQueue<>();
    assertTrue(emptyQueue.isEmpty());
  }

  @Test
  public void arrayEmptyWhenDequeued(){
    ArrayQueue<String> queue = new ArrayQueue<>();
    queue.enqueue("A string");
    queue.dequeue();
    assertTrue(queue.isEmpty());
  }

  @Test
  public void linkedEmptyWhenDeclared(){
    LinkedQueue<String> emptyQueue = new LinkedQueue<>();
    assertTrue(emptyQueue.isEmpty());
  }

  @Test
  public void linkedEmptyWhenDequeued(){
    LinkedQueue<String> queue = new LinkedQueue<>();
    queue.enqueue("A string");
    queue.dequeue();
    assertTrue(queue.isEmpty());
  }

  @Test
  public void fullWhenFilled(){
    ArrayQueue<String> fullQueue = new ArrayQueue<String>(1);
    fullQueue.enqueue("A string");
    assertTrue(fullQueue.isFull());
  }

  /*
   * These test the functionality of the clear method
   */
  @Test
  public void arrayEmptyWhenCleared(){
    ArrayQueue<String> queue = new ArrayQueue<>();
    for (int i = 0; i < 10; i++){
      queue.enqueue("Some string");
    }
    queue.clear();
    assertTrue(queue.isEmpty());
  }

  @Test
  public void linkedEmptyWhenCleared(){
    LinkedQueue<String> queue = new LinkedQueue<>();
    for (int i = 0; i < 10; i++){
      queue.enqueue("Some string");
    }
    queue.clear();
    assertTrue(queue.isEmpty());
  }
}
