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
  public void addToEmptyQueue(){
    ArrayQueue<String> emptyQueue = new ArrayQueue<>();
    emptyQueue.enqueue("A string");
    if (emptyQueue.getFront().equals("A string")){
      assertTrue(true);
    }
    else{
      assertTrue(false);
    }
  }

  @Test
  public void addToFullQueue(){
    ArrayQueue<String> fullQueue = new ArrayQueue<>(1);
    fullQueue.enqueue("A string");
    try{
      fullQueue.enqueue("Another string");
      if (fullQueue.getFront().equals("A string")){
        assertTrue(true);
      }
      else{
        assertTrue(false);
      }
    }
    catch(NoSuchElementException e){
      assertTrue(false);
    }
  }

  @Test
  public void addToFullQueueBeyondMaxCapacity(){
    ArrayQueue<String> maxQueue = new ArrayQueue<>(10000);
    for (int i = 0; i < 10000; i++){
      maxQueue.enqueue("String number " + i);
    }
    try{
      maxQueue.enqueue("Another string");
      assertTrue(false);
    }
    catch(IllegalStateException e){
      assertTrue(true);
    }
  }

  @Test
  public void addToHalfFullQueue(){
    ArrayQueue<String> halfFullQueue = new ArrayQueue<>();
    final int HALF_DEFAULT_CAPACITY = 13;
    for (int i = 0; i < HALF_DEFAULT_CAPACITY; i++){
      halfFullQueue.enqueue("String number " + i);
    }
    if (halfFullQueue.getFront().equals("String number 0")){
      assertTrue(true);
    }
    else{
      assertTrue(false);
    }
  }

  /*
   * These test the functionality of the getFront method
   */
  @Test
  public void getFrontOfEmptyQueue()
  {
    ArrayQueue<String> emptyQueue = new ArrayQueue<>();
    try{
      emptyQueue.getFront();
      assertTrue(false);
    }
    catch(NoSuchElementException e){
      assertTrue(true);
    }
  }

  @Test
  public void getFrontOfQueueWithOneElement()
  {
    ArrayQueue<String> queueWithOneElement = new ArrayQueue<>(1);
    queueWithOneElement.enqueue("A string");
    if (queueWithOneElement.getFront().equals("A string")){
      assertTrue(true);
    }
    else{
      assertTrue(false);
    }
  }

  @Test
  public void getFrontOfOverflowedQueue(){
    // requires implemented enqueue and dequeue!
    assertTrue(true);
  }

  /*
   * These test the functionality of the dequeue method
   */
  @Test
  public void dequeueToEmpty(){
    ArrayQueue<String> filledQueue = new ArrayQueue<>(1);
    filledQueue.enqueue("A string");
    if (filledQueue.dequeue().equals("A string") && filledQueue.isEmpty()){
        assertTrue(true);
    }
    else{
      assertTrue(false);
    }
  }

  @Test
  public void dequeueFailsForEmpty(){
    ArrayQueue<String> emptyQueue = new ArrayQueue<>();
    try{
      emptyQueue.dequeue();
      assertTrue(false);
    }
    catch(IllegalStateException e){
      assertTrue(true);
    }
  }
  /*
   * These test the functionality of the isEmpty and isFull methods
   */
  @Test
  public void emptyWhenDeclared(){
    ArrayQueue<String> emptyQueue = new ArrayQueue<>();
    if (emptyQueue.isEmpty()){
      assertTrue(true);
    }
    else{
      assertTrue(false);
    }
  }

  @Test
  public void emptyWhenDequeued(){
    ArrayQueue<String> queue = new ArrayQueue<>();
    queue.enqueue("A string");
    queue.dequeue();
    if (queue.isEmpty()){
      assertTrue(true);
    }
    else{
      assertTrue(false);
    }
  }

  @Test
  public void fullWhenFilled(){
    ArrayQueue fullQueue = new ArrayQueue<>(1);
    fullQueue.enqueue("A string");
    if (fullQueue.isFull()){
      assertTrue(true);
    }
    else{
      assertTrue(false);
    }
  }
}
