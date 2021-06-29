package io.anthonygraca.princeton.chapter1.randomized_queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.NoSuchElementException;

import org.junit.Test;

public class RandomizedQueueTest {
  @Test
  public void initializedRandomizedQueueIsEmpty() {
    RandomizedQueue<String> queue = new RandomizedQueue<String>();
    assertTrue(queue.isEmpty());
  }

  @Test
  public void emptyQueueHasSizeZero() {
    RandomizedQueue<String> queue = new RandomizedQueue<String>();
    assertEquals(0, queue.size());
  }

  @Test
  public void addFirstIncreasesSize() {
    RandomizedQueue<String> queue = new RandomizedQueue<String>();
    String example = "example";
    queue.addFirst(example);
    assertEquals(1, queue.size());
  }

  @Test
  public void addFirstMeansNotEmpty() {
    RandomizedQueue<String> queue = new RandomizedQueue<String>();
    String example = "example";
    queue.addFirst(example);
    assertFalse(queue.isEmpty());
  }

  @Test
  public void addLastIncreasesSize() {
    RandomizedQueue<String> queue = new RandomizedQueue<String>();
    String example = "example";
    queue.addLast(example);
    assertEquals(1, queue.size());
  }

  @Test
  public void addLastMeansNotEmpty() {
    RandomizedQueue<String> queue = new RandomizedQueue<String>();
    String example = "example";
    queue.addLast(example);
    assertFalse(queue.isEmpty());
  }

  @Test
  public void enqueueIncreasesSize() {
    RandomizedQueue<String> queue = new RandomizedQueue<String>();
    String example = "example";
    queue.enqueue(example);
    assertEquals(1, queue.size());
  }

  @Test
  public void enqueueMeansNotEmpty() {
    RandomizedQueue<String> queue = new RandomizedQueue<String>();
    String example = "example";
    queue.enqueue(example);
    assertFalse(queue.isEmpty());
  }
}
