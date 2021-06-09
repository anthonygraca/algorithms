package io.anthonygraca.princeton.chapter1.stack;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class FixedCapacityStackOfStringsTest {
  @Test
  public void initializedStackIsEmpty() {
    FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings();
    assertTrue(stack.isEmpty());
  }

  @Test
  public void pushAString() {
    FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings();
    String example = "dummy string";
    stack.push(example);
    assertFalse(stack.isEmpty());
  }
}
