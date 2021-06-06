package io.anthonygraca.princeton.chapter1;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.NoSuchElementException;

import org.junit.Test;

public class ArrayDequeTest {
  @Test
  public void constructEmptyDeque(){
    ArrayDeque deque = new ArrayDeque();
    assertTrue(deque.size() == 0);
  }
}

