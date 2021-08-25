package io.anthonygraca.princeton.chapter2.CollinearPoints;

import org.junit.Test;

public class FastCollinearPointsTest {
  @Test(expected=IllegalArgumentException.class)
  public void handleNullArgumentInConstructor() {
    FastCollinearPoints algo = new FastCollinearPoints(null);
  }
}
