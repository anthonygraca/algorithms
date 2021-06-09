package io.anthonygraca.princeton.chapter1.stack;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FixedCapacityStackOfStringsTest {
  @Test
  public void initializedStackIsEmpty() {
    FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(10);
    assertTrue(stack.isEmpty());
  }

  @Test
  public void pushAString() {
    FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(10);
    String example = "dummy string";
    stack.push(example);
    assertFalse(stack.isEmpty());
  }

  @Test
  public void verifySize() {
    FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(10);
    String example = "dummy string";
    stack.push(example);
    assertEquals(1, stack.size());
  }

  @Test
  public void verifyPop() {
    FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(10);
    String example = "dummy string";
    stack.push(example);
    assertEquals(example, stack.pop());
  }

  @Test
  public void verifyMultiplePop() {
    FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(10);
    String example1 = "dummy string 1";
    String example2 = "dummy string 2";
    stack.push(example1);
    stack.push(example2);
    assertEquals(example2, stack.pop());
  }
}
