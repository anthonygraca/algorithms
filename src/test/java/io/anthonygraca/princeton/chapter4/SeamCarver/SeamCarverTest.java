package io.anthonygraca.princeton.chapter4.SeamCarver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.princeton.cs.algs4.Picture;

public class SeamCarverTest {
  final String prefix =
      "src/test/java/io/anthonygraca/princeton/chapter4/SeamCarver/";

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
    Picture p = new Picture(prefix + "3x4.png");
    SeamCarver sc = new SeamCarver(p);
    final double expected = 1000.0;
    final double output = sc.energy(0,0);
    assertEquals(expected, output, 0.01);
  }

  @Test
  public void ValidateEnergyOfOppositeOrigin() {
    Picture p = new Picture(prefix + "3x4.png");
    SeamCarver sc = new SeamCarver(p);
    final double expected = 1000.0;
    final double output = sc.energy(p.width()-1, p.height()-1);
    assertEquals(expected, output, 0.01);
  }

  @Test
  public void ValidateEnergyOfNontrivialPoint() {
    Picture p = new Picture(prefix + "3x4.png");
    SeamCarver sc = new SeamCarver(p);
    final double expected = Math.sqrt(52225);
    final double output = sc.energy(1, 1);
    assertEquals(expected, output, 0.01);
  }

  @Test
  public void ValidateEnergyOfSecondNontrivialPoint() {
    Picture p = new Picture(prefix + "3x4.png");
    SeamCarver sc = new SeamCarver(p);
    final double expected = Math.sqrt(52024);
    final double output = sc.energy(1, 2);
    assertEquals(expected, output, 0.01);
  }

  @Test
  public void FindVerticalSeamOf6x5Image() {
    Picture p = new Picture(prefix + "6x5.png");
    SeamCarver sc = new SeamCarver(p);
    int[] expected = {3,4,3,2,1};
    int[] output = sc.findVerticalSeam();
    assertEquals(expected.length, output.length);
    assertEquals(expected[0], output[0]);
    assertEquals(expected[1], output[1]);
    assertEquals(expected[2], output[2]);
    assertEquals(expected[3], output[3]);
    assertEquals(expected[4], output[4]);
    
  }

  @Test
  public void ValidateEnergyAccumulatonOf6x5Image() {
    Picture p = new Picture(prefix + "6x5.png");
    SeamCarver sc = new SeamCarver(p);
    double[][] expected = {{1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0},
                           {2000.00, 1237.35, 1151.02, 1234.09, 1107.89, 2000.0},
                           {2237.35, 1289.71, 1379.12, 1240.96, 1319.4, 2107.89},
                           {2289.71, 1443.59, 1414.97, 1524.97, 1435.46, 2319.4},
                           {2443.59, 2414.97, 2414.97, 2414.97, 2435.46, 2435.46}
      };
    double[][] output = sc.accumulateEnergyToBottom();
    assertEquals(expected[0][0], output[0][0], 0.01);
    assertEquals(expected[0][1], output[0][1], 0.01);
    assertEquals(expected[0][2], output[0][2], 0.01);
    assertEquals(expected[0][3], output[0][3], 0.01);
    assertEquals(expected[0][4], output[0][4], 0.01);
    assertEquals(expected[0][5], output[0][5], 0.01);
    assertEquals(expected[1][0], output[1][0], 0.01);
    assertEquals(expected[1][1], output[1][1], 0.01);
    assertEquals(expected[1][2], output[1][2], 0.01);
    assertEquals(expected[1][3], output[1][3], 0.01);
    assertEquals(expected[1][4], output[1][4], 0.01);
    assertEquals(expected[1][5], output[1][5], 0.01);
    assertEquals(expected[2][0], output[2][0], 0.01);
    assertEquals(expected[2][1], output[2][1], 0.01);
    assertEquals(expected[2][2], output[2][2], 0.01);
    assertEquals(expected[2][3], output[2][3], 0.01);
    assertEquals(expected[2][4], output[2][4], 0.01);
    assertEquals(expected[2][5], output[2][5], 0.01);
    assertEquals(expected[3][0], output[3][0], 0.01);
    assertEquals(expected[3][1], output[3][1], 0.01);
    assertEquals(expected[3][2], output[3][2], 0.01);
    assertEquals(expected[3][3], output[3][3], 0.01);
    assertEquals(expected[3][4], output[3][4], 0.01);
    assertEquals(expected[3][5], output[3][5], 0.01);
    assertEquals(expected[4][0], output[4][0], 0.01);
    assertEquals(expected[4][1], output[4][1], 0.01);
    assertEquals(expected[4][2], output[4][2], 0.01);
    assertEquals(expected[4][3], output[4][3], 0.01);
    assertEquals(expected[4][4], output[4][4], 0.01);
    assertEquals(expected[4][5], output[4][5], 0.01);
  }

  @Test
  public void FindHorizontalSeamOf6x5Image() {
    Picture p = new Picture(prefix + "6x5.png");
    SeamCarver sc = new SeamCarver(p);
    int[] expected = {1,2,1,2,1,0};
    int[] output = sc.findHorizontalSeam();
    assertEquals(expected.length, output.length);
    assertEquals(expected[0], output[0]);
    assertEquals(expected[1], output[1]);
    assertEquals(expected[2], output[2]);
    assertEquals(expected[3], output[3]);
    assertEquals(expected[4], output[4]);
    assertEquals(expected[5], output[5]);
  }


  @Test
  public void ValidateEnergyAccumulatonOf6x5ImageToRight() {
    Picture p = new Picture(prefix + "6x5.png");
    SeamCarver sc = new SeamCarver(p);
    double[][] expected = {{1000.00, 2000.00, 2237.35, 2289.71, 2523.80, 2530.68},
                           {1000.00, 1237.35, 1289.71, 1523.80, 1530.68, 2530.68},
                           {1000.00, 1138.69, 1366.79, 1422.78, 1634.29, 2530.68},
                           {1000.00, 1153.88, 1312.70, 1596.71, 1617.29, 2617.29},
                           {1000.00, 2000.00, 2153.88, 2312.70, 2596.71, 2617.29}
    };
    double[][] output = sc.accumulateEnergyToRight();
    assertEquals(expected[0][0], output[0][0], 0.01);
    assertEquals(expected[0][1], output[0][1], 0.01);
    assertEquals(expected[0][2], output[0][2], 0.01);
    assertEquals(expected[0][3], output[0][3], 0.01);
    assertEquals(expected[0][4], output[0][4], 0.01);
    assertEquals(expected[0][5], output[0][5], 0.01);
    assertEquals(expected[1][0], output[1][0], 0.01);
    assertEquals(expected[1][1], output[1][1], 0.01);
    assertEquals(expected[1][2], output[1][2], 0.01);
    assertEquals(expected[1][3], output[1][3], 0.01);
    assertEquals(expected[1][4], output[1][4], 0.01);
    assertEquals(expected[1][5], output[1][5], 0.01);
    assertEquals(expected[2][0], output[2][0], 0.01);
    assertEquals(expected[2][1], output[2][1], 0.01);
    assertEquals(expected[2][2], output[2][2], 0.01);
    assertEquals(expected[2][3], output[2][3], 0.01);
    assertEquals(expected[2][4], output[2][4], 0.01);
    assertEquals(expected[2][5], output[2][5], 0.01);
    assertEquals(expected[3][0], output[3][0], 0.01);
    assertEquals(expected[3][1], output[3][1], 0.01);
    assertEquals(expected[3][2], output[3][2], 0.01);
    assertEquals(expected[3][3], output[3][3], 0.01);
    assertEquals(expected[3][4], output[3][4], 0.01);
    assertEquals(expected[3][5], output[3][5], 0.01);
    assertEquals(expected[4][0], output[4][0], 0.01);
    assertEquals(expected[4][1], output[4][1], 0.01);
    assertEquals(expected[4][2], output[4][2], 0.01);
    assertEquals(expected[4][3], output[4][3], 0.01);
    assertEquals(expected[4][4], output[4][4], 0.01);
    assertEquals(expected[4][5], output[4][5], 0.01);
  }



  // height and width changes when seam is removed
  // remove seams should do something

}
