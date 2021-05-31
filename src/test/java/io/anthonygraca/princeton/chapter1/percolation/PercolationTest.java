package io.anthonygraca.princeton.chapter1.percolation;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Unit test for Percolation.
 */
public class PercolationTest {
  @Test(expected=IndexOutOfBoundsException.class)
  public void zeroIsInvalid() {
    Percolation perc = new Percolation(0);
  }

  @Test
  public void initialSitesAreClosed() {
    Percolation perc = new Percolation(1);
    assertFalse(perc.isOpen(1, 1));
  }

  @Test(expected=IndexOutOfBoundsException.class)
  public void openAnInvalidSite() {
    Percolation perc = new Percolation(1);
    perc.open(0,0);
  }

  @Test(expected=IndexOutOfBoundsException.class)
  public void isOpenOnAnInvalidSite() {
    Percolation perc = new Percolation(1);
    perc.isOpen(0,0);
  }

  @Test
  public void openASite() {
    Percolation perc = new Percolation(1);
    perc.open(1,1);
    assertTrue(perc.isOpen(1, 1));
  }

  @Test
  public void numberOfZeroSites() {
    Percolation perc = new Percolation(1);
    assertEquals(0, perc.numberOfOpenSites());
  }

  @Test
  public void numberOfOneOpenSite() {
    Percolation perc = new Percolation(1);
    perc.open(1,1);
    assertEquals(1, perc.numberOfOpenSites());
  }

  @Test
  public void numberOfOneOpenSiteDuplicates() {
    Percolation perc = new Percolation(1);
    perc.open(1,1);
    perc.open(1,1);
    assertEquals(1, perc.numberOfOpenSites());
  }

  @Test
  public void isFullTrivialCase() {
    Percolation perc = new Percolation(1);
    assertFalse(perc.isFull(1, 1));
  }

  @Test
  public void isFullWithAnOpenSite() {
    Percolation perc = new Percolation(1);
    perc.open(1,1);
    assertTrue(perc.isFull(1, 1));
  }

  @Test
  public void isFullWithBiggerSite() {
    Percolation perc = new Percolation(2);
    perc.open(1,1);
    assertTrue(perc.isFull(1, 1));
  }

  @Test
  public void verifyIsTopOpenTrivial() {
    Percolation perc = new Percolation(2);
    assertFalse(perc.isTopNeighborOpen(2,1));
  }

  @Test
  public void verifyIsTopOpen() {
    Percolation perc = new Percolation(2);
    perc.open(1,1);
    assertTrue(perc.isTopNeighborOpen(2,1));
  }

  @Test
  public void verifyIsTopOpenOutOfBounds() {
    Percolation perc = new Percolation(2);
    assertFalse(perc.isTopNeighborOpen(1,1));
  }

  @Test
  public void isFullWithBiggerSiteLower() {
    Percolation perc = new Percolation(2);
    perc.open(1,1);
    perc.open(2,1);
    assertTrue(perc.isFull(2, 1));
  }

  @Test
  public void percolatesTrivial() {
    Percolation perc = new Percolation(1);
    assertFalse(perc.percolates());
  }

  @Test
  public void percolatesSingle() {
    Percolation perc = new Percolation(1);
    perc.open(1,1);
    assertTrue(perc.percolates());
  }

  @Test
  public void percolatesTwoByTwoFalse() {
    Percolation perc = new Percolation(2);
    perc.open(1,1);
    assertFalse(perc.percolates());
  }

  @Test
  public void percolatesTwoByTwoTrue() {
    Percolation perc = new Percolation(2);
    perc.open(1,1);
    perc.open(2,1);
    assertTrue(perc.percolates());
  }

  @Test
  public void verifyIsBottomOpen() {
    Percolation perc = new Percolation(2);
    perc.open(2,1);
    assertTrue(perc.isBottomNeighborOpen(1, 1));
  }

  @Test
  public void isFullSwitchedOrder() {
    Percolation perc = new Percolation(2);
    perc.open(2,1);
    perc.open(1,1);
    assertTrue(perc.isFull(2, 1));
  }

  @Test
  public void percolatesTwoByTwoTrueOtherOrder() {
    Percolation perc = new Percolation(2);
    perc.open(2,1);
    perc.open(1,1);
    assertTrue(perc.percolates());
  }

  @Test
  public void percolatesInputOneFalse() {
    Percolation perc = new Percolation(1);
    assertFalse(perc.percolates());
  }

  @Test
  public void percolatesInputOneTrue() {
    Percolation perc = new Percolation(1);
    perc.open(1,1);
    assertTrue(perc.percolates());
  }

  @Test
  public void percolatesInputTwo() {
    Percolation perc = new Percolation(2);
    perc.open(1,1);
    perc.open(2,2);
    perc.open(1,2);
    assertTrue(perc.percolates());
  }

  @Test
  public void percolatesInputTwoFalse() {
    Percolation perc = new Percolation(2);
    perc.open(1,1);
    perc.open(2,2);
    assertFalse(perc.percolates());
  }

  @Test
  public void percolatesInputThree() {
    Percolation perc = new Percolation(3);
    perc.open(1,3);
    perc.open(2,3);
    perc.open(3,3);
    perc.open(3,1);
    perc.open(2,1);
    perc.open(1,1);
    assertTrue(perc.percolates());
  }

  @Test
  public void percolatesInputFour() {
    Percolation perc = new Percolation(4);
    perc.open(4,1);
    perc.open(3,1);
    perc.open(2,1);
    perc.open(1,1);
    perc.open(1,4);
    perc.open(2,4);
    perc.open(4,4);
    perc.open(3,4);
    assertTrue(perc.percolates());
  }

  @Test
  public void percolatesInputFive() {
    Percolation perc = new Percolation(5);
    perc.open(1,1);
    perc.open(1,2);
    perc.open(1,4);
    perc.open(1,5);
    perc.open(1,3);
    perc.open(5,5);
    perc.open(5,1);
    perc.open(5,3);
    perc.open(5,2);
    perc.open(5,4);
    perc.open(4,1);
    perc.open(4,3);
    perc.open(4,4);
    perc.open(4,5);
    perc.open(4,2);
    perc.open(2,1);
    perc.open(2,2);
    perc.open(2,4);
    perc.open(2,5);
    perc.open(2,3);
    perc.open(3,1);
    perc.open(3,2);
    perc.open(3,3);
    perc.open(3,4);
    perc.open(3,5);
    assertTrue(perc.percolates());
  }

  // This test exercises left and right neighbors
  @Test
  public void percolatesInputSix() {
    Percolation perc = new Percolation(6);
    perc.open(1,6);
    perc.open(2,6);
    perc.open(3,6);
    perc.open(4,6);
    perc.open(5,6);
    perc.open(5,5);
    perc.open(4,4);
    perc.open(3,4);
    perc.open(2,4);
    perc.open(2,3);
    perc.open(2,2);
    perc.open(2,1);
    perc.open(3,1);
    perc.open(4,1);
    perc.open(5,1);
    perc.open(5,2);
    perc.open(6,2);
    perc.open(5,4);
    assertTrue(perc.percolates());
  }

  // This test reveals backwash
  @Test
  public void percolatesInputTen() {
    Percolation perc = new Percolation(10);
    perc.open(10, 2);
    perc.open(2, 10);
    perc.open(6, 8);
    perc.open(2, 6);
    perc.open(1, 4);
    perc.open(8, 4);
    perc.open(10, 1);
    perc.open(4, 2);
    perc.open(4, 8);
    perc.open(9, 3);
    perc.open(2, 2);
    perc.open(9, 1);
    perc.open(4, 3);
    perc.open(5, 5);
    perc.open(5, 7);
    perc.open(2, 8);
    perc.open(6, 4);
    perc.open(7, 5);
    perc.open(9, 6);
    perc.open(3, 7);
    perc.open(4, 7);
    perc.open(7, 1);
    perc.open(9, 4);
    perc.open(3, 10);
    perc.open(1, 10);
    perc.open(10, 10);
    perc.open(9, 7);
    perc.open(1, 5);
    perc.open(9, 8);
    perc.open(6, 1);
    perc.open(2, 5);
    perc.open(3, 4);
    perc.open(6, 9);
    perc.open(5, 8);
    perc.open(3, 2);
    perc.open(4, 6);
    perc.open(1, 7);
    perc.open(7, 9);
    perc.open(3, 9);
    perc.open(4, 4);
    perc.open(4, 10);
    perc.open(3, 5);
    perc.open(3, 8);
    perc.open(1, 8);
    perc.open(3, 1);
    perc.open(6, 7);
    perc.open(2, 3);
    perc.open(7, 4);
    perc.open(9, 10);
    perc.open(7, 6);
    perc.open(5, 2);
    perc.open(8, 3);
    perc.open(10, 8);
    perc.open(7, 10);
    perc.open(4, 5);
    perc.open(8, 10);
    assertTrue(perc.percolates());
    /*
    assertFalse(perc.isFull(9, 1));
    assertFalse(perc.isFull(10, 1));
    assertFalse(perc.isFull(10, 2));
    */
  }

  public void percolatesInputTenFalse() {
    Percolation perc = new Percolation(10);
    perc.open(10, 2);
    perc.open(2, 10);
    perc.open(6, 8);
    perc.open(2, 6);
    perc.open(1, 4);
    perc.open(8, 4);
    perc.open(10, 1);
    perc.open(4, 2);
    perc.open(4, 8);
    perc.open(9, 3);
    perc.open(2, 2);
    perc.open(9, 1);
    perc.open(4, 3);
    perc.open(5, 5);
    perc.open(5, 7);
    perc.open(2, 8);
    perc.open(6, 4);
    perc.open(7, 5);
    perc.open(9, 6);
    perc.open(3, 7);
    perc.open(4, 7);
    perc.open(7, 1);
    perc.open(9, 4);
    perc.open(3, 10);
    perc.open(1, 10);
    perc.open(9, 7);
    perc.open(1, 5);
    perc.open(9, 8);
    perc.open(6, 1);
    perc.open(2, 5);
    perc.open(3, 4);
    perc.open(6, 9);
    perc.open(5, 8);
    perc.open(3, 2);
    perc.open(4, 6);
    perc.open(1, 7);
    perc.open(7, 9);
    perc.open(3, 9);
    perc.open(4, 4);
    perc.open(4, 10);
    perc.open(3, 5);
    perc.open(3, 8);
    perc.open(1, 8);
    perc.open(3, 1);
    perc.open(6, 7);
    perc.open(2, 3);
    perc.open(7, 4);
    perc.open(9, 10);
    perc.open(7, 6);
    perc.open(5, 2);
    perc.open(8, 3);
    perc.open(10, 8);
    perc.open(7, 10);
    perc.open(4, 5);
    perc.open(8, 10);
    assertFalse(perc.percolates());
  }
}
