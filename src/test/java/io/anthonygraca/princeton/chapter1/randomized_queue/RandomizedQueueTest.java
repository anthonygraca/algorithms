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
}
