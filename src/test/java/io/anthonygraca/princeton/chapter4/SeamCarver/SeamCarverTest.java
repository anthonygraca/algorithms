package io.anthonygraca.princeton.chapter4.SeamCarver;

import org.junit.Test;

public class SeamCarverTest {
  @Test(expected=IllegalArgumentException.class)
  public void CatchNullInputInConstructor() {
    SeamCarver sc = new SeamCarver(null);
  }
}
