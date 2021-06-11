package io.anthonygraca.princeton.chapter1.stack;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArrayResizingStackTest {
  @Test
  public void initializedStackIsEmpty() {
    ArrayResizingStack<String> stack = new ArrayResizingStack<String>();
    assertTrue(stack.isEmpty());
  }

  @Test
  public void pushAString() {
    ArrayResizingStack<String> stack = new ArrayResizingStack<String>();
    String example = "dummy string";
    stack.push(example);
    assertFalse(stack.isEmpty());
  }

  @Test
  public void verifySize() {
    ArrayResizingStack<String> stack = new ArrayResizingStack<String>();
    String example = "dummy string";
    stack.push(example);
    assertEquals(1, stack.size());
  }

  @Test
  public void verifyPop() {
    ArrayResizingStack<String> stack = new ArrayResizingStack<String>();
    String example = "dummy string";
    stack.push(example);
    assertEquals(example, stack.pop());
  }

  @Test
  public void verifyMultiplePop() {
    ArrayResizingStack<String> stack = new ArrayResizingStack<String>();
    String example1 = "dummy string 1";
    String example2 = "dummy string 2";
    stack.push(example1);
    stack.push(example2);
    assertEquals(example2, stack.pop());
    assertEquals(example1, stack.pop());
  }

  @Test
  public void verifyStackDoesNotOverflow() {
    ArrayResizingStack<String> stack = new ArrayResizingStack<String>();
    String example1 = "dummy string 1";
    String example2 = "dummy string 2";
    String example3 = "dummy string 3";
    String example4 = "dummy string 4";
    stack.push(example1);
    stack.push(example2);
    stack.push(example3);
    stack.push(example4);
    assertEquals(4, stack.size());
  }

  @Test
  public void verifyStackShrinks() {
    ArrayResizingStack<String> stack = new ArrayResizingStack<String>();
    String example = "dummy string";
    for (int i = 0; i < 10; i++) {
      stack.push(example);
    }
    for (int i = 0; i < 9; i++) {
      stack.pop();
    }
    assertTrue(stack.size() > stack.getCapacity()/4);
  }
}
