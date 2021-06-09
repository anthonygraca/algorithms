package io.anthonygraca.princeton.chapter1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BagTest {
  @Test
  public void shouldAnswerWithTrue() {
    Bag aBag = new ArrayBag();
    Bag lBag = new LinkedBag();
    assertTrue( true );
  }
}
