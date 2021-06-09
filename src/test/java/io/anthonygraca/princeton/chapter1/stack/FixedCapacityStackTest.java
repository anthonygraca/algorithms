package io.anthonygraca.princeton.chapter1.stack;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FixedCapacityStackTest {
  @Test
  public void initializedStackIsEmpty() {
    FixedCapacityStack<String> stack = new FixedCapacityStack<String>(10);
    assertTrue(stack.isEmpty());
  }

  @Test
  public void pushAString() {
    FixedCapacityStack<String> stack = new FixedCapacityStack<String>(10);
    String example = "dummy string";
    stack.push(example);
    assertFalse(stack.isEmpty());
  }

  @Test
  public void verifySize() {
    FixedCapacityStack<String> stack = new FixedCapacityStack<String>(10);
    String example = "dummy string";
    stack.push(example);
    assertEquals(1, stack.size());
  }

  @Test
  public void verifyPop() {
    FixedCapacityStack<String> stack = new FixedCapacityStack<String>(10);
    String example = "dummy string";
    stack.push(example);
    assertEquals(example, stack.pop());
  }

  @Test
  public void verifyMultiplePop() {
    FixedCapacityStack<String> stack = new FixedCapacityStack<String>(10);
    String example1 = "dummy string 1";
    String example2 = "dummy string 2";
    stack.push(example1);
    stack.push(example2);
    assertEquals(example2, stack.pop());
  }
}
