package io.anthonygraca.princeton.chapter1;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.NoSuchElementException;

import org.junit.Test;

public class ArrayDequeTest {
  // Testing constructors
  @Test
  public void constructDefaultDeque(){
    ArrayDeque deque = new ArrayDeque();
    assertTrue(deque.size() == 25);
  }

  @Test(expected=IllegalStateException.class)
  public void lowerBoundConstructor(){
    ArrayDeque queue = new ArrayDeque(-1);
  }

  @Test(expected=IllegalStateException.class)
  public void upperBoundConstructor(){
    ArrayDeque queue = new ArrayDeque(100000);
  }

  @Test
  public void withinBoundConstructor(){
    try{
      ArrayDeque queue1 = new ArrayDeque(1);      // exact lower bound
      ArrayDeque queue2 = new ArrayDeque(10);
      ArrayDeque queue3 = new ArrayDeque(100);
      ArrayDeque queue4 = new ArrayDeque(1000);
      ArrayDeque queue5 = new ArrayDeque(10000);  // exact upper bound
    }
    catch(Exception e){
      assertTrue(false);
    }
    assertTrue(true);
  }
}

