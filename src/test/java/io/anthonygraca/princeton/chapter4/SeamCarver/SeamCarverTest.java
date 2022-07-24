package io.anthonygraca.princeton.chapter4.SeamCarver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.princeton.cs.algs4.Picture;

public class SeamCarverTest {
  final String sample_file =
      "src/test/java/io/anthonygraca/princeton/chapter4/SeamCarver/3x4.png";

  @Test(expected=IllegalArgumentException.class)
  public void CatchNullInputInConstructor() {
    SeamCarver sc = new SeamCarver(null);
  }

  @Test
  public void WidthOfValidPicture() {
    Picture p = new Picture(1920, 1080);
    SeamCarver sc = new SeamCarver(p);
    assertEquals(1920, sc.width());
  }

  @Test
  public void HeightOfValidPicture() {
    Picture p = new Picture(1920, 1080);
    SeamCarver sc = new SeamCarver(p);
    assertEquals(1080, sc.height());
  }

  @Test
  public void ReturnPicture() {
    Picture p = new Picture(1920, 1080);
    SeamCarver sc = new SeamCarver(p);
    assertEquals(p, sc.picture());
  }

  @Test(expected=IllegalArgumentException.class)
  public void ThrowOnInvalidEnergyWidthLowerBound() {
    Picture p = new Picture(1920, 1080);
    SeamCarver sc = new SeamCarver(p);
    sc.energy(-1, 0);
  }

  @Test(expected=IllegalArgumentException.class)
  public void ThrowOnInvalidEnergyWidthUpperBound() {
    Picture p = new Picture(1920, 1080);
    SeamCarver sc = new SeamCarver(p);
    sc.energy(1920, 0);
  }

  @Test(expected=IllegalArgumentException.class)
  public void ThrowOnInvalidEnergyHeightLowerBound() {
    Picture p = new Picture(1920, 1080);
    SeamCarver sc = new SeamCarver(p);
    sc.energy(0, -1);
  }

  @Test(expected=IllegalArgumentException.class)
  public void ThrowOnInvalidEnergyHeightUpperBound() {
    Picture p = new Picture(1920, 1080);
    SeamCarver sc = new SeamCarver(p);
    sc.energy(0, 1080);
  }

  @Test(expected=IllegalArgumentException.class)
  public void RemoveHorizontalSeamThrowsOnNullInput() {
    Picture p = new Picture(1920, 1080);
    SeamCarver sc = new SeamCarver(p);
    sc.removeHorizontalSeam(null);
  }

  @Test(expected=IllegalArgumentException.class)
  public void RemoveVerticalSeamThrowsOnNullInput() {
    Picture p = new Picture(1920, 1080);
    SeamCarver sc = new SeamCarver(p);
    sc.removeVerticalSeam(null);
  }

  @Test(expected=IllegalArgumentException.class)
  public void RemoveVerticalSeamThrowsOnSmallPicture() {
    Picture p = new Picture(1, 1080);
    SeamCarver sc = new SeamCarver(p);
    int[] seam = new int[1080];
    sc.removeVerticalSeam(seam);
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void RemoveHorizontalSeamThrowsOnSmallPicture() {
    Picture p = new Picture(1920, 1);
    SeamCarver sc = new SeamCarver(p);
    int[] seam = new int[1920];
    sc.removeHorizontalSeam(seam);
  }

  @Test(expected=IllegalArgumentException.class)
  public void RemoveVerticalSeamThrowsOnWrongInputLength() {
    Picture p = new Picture(1920, 1080);
    SeamCarver sc = new SeamCarver(p);
    int[] seam = new int[1089];
    sc.removeVerticalSeam(seam);
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void RemoveHorizontalSeamThrowsOnWrongInputLength() {
    Picture p = new Picture(1920, 1080);
    SeamCarver sc = new SeamCarver(p);
    int[] seam = new int[1919];
    sc.removeHorizontalSeam(seam);
  }

  @Test(expected=IllegalArgumentException.class)
  public void RemoveHorizontalSeamThrowsOnInputOutsideRange() {
    Picture p = new Picture(1920, 1080);
    SeamCarver sc = new SeamCarver(p);
    int[] seam = new int[1920];
    seam[0] = 1080;
    sc.removeHorizontalSeam(seam);
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void RemoveHorizontalSeamThrowsOnInputEntriesDifferMoreThanOne() {
    Picture p = new Picture(1920, 1080);
    SeamCarver sc = new SeamCarver(p);
    int[] seam = new int[1920];
    seam[0] = 1000;
    seam[1] = 1002;
    sc.removeHorizontalSeam(seam);
  }

  @Test
  public void ValidateEnergyOfOrigin() {
    Picture p = new Picture(sample_file);
    SeamCarver sc = new SeamCarver(p);
    final double expected = 1000.0;
    final double output = sc.energy(0,0);
    assertEquals(expected, output, 0.01);
  }

  @Test
  public void ValidateEnergyOfOppositeOrigin() {
    Picture p = new Picture(sample_file);
    SeamCarver sc = new SeamCarver(p);
    final double expected = 1000.0;
    final double output = sc.energy(p.width()-1, p.height()-1);
    assertEquals(expected, output, 0.01);
  }

  @Test
  public void ValidateEnergyOfNontrivialPoint() {
    Picture p = new Picture(sample_file);
    SeamCarver sc = new SeamCarver(p);
    final double expected = Math.sqrt(52225);
    final double output = sc.energy(1, 1);
    assertEquals(expected, output, 0.01);
  }

  @Test
  public void ValidateEnergyOfSecondNontrivialPoint() {
    Picture p = new Picture(sample_file);
    SeamCarver sc = new SeamCarver(p);
    final double expected = Math.sqrt(52024);
    final double output = sc.energy(1, 2);
    assertEquals(expected, output, 0.01);
  }






  // height and width changes when seam is removed

}
