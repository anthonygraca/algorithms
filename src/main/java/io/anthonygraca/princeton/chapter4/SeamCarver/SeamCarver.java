package io.anthonygraca.princeton.chapter4.SeamCarver;

import edu.princeton.cs.algs4.Picture;

public class SeamCarver {
  private final Picture picture_;
  private int width_;
  private int height_;
  public SeamCarver(Picture picture) {
    if (picture == null) {
      throw new IllegalArgumentException("Input is null");
    }
    picture_ = new Picture(picture);
    width_ = picture_.width();
    height_ = picture_.height();
  }

  public Picture picture() {
    return picture_;
  }

  public int width() {
    return picture_.width();
  }
  
  public int height() {
    return picture_.height();
  }

  public double energy(int x, int y) {
    if (x < 0 || x >= picture_.width() || y < 0 || y >= picture_.height()) {
      throw new IllegalArgumentException("resolution out of bounds");
    }
    if (x == 0 || y == 0 || x == width_-1 || y == height_-1) {
      return 1000.0;
    }
    return Math.sqrt(getXGradient(x,y) + getYGradient(x,y));
  }

  private int getXGradient(int row, int col) {
    int rgb1 = picture_.getRGB(row-1, col);
    int r1 = (rgb1 >> 16) & 0xFF;
    int g1 = (rgb1 >>  8) & 0xFF;
    int b1 = (rgb1 >>  0) & 0xFF;
    int rgb2 = picture_.getRGB(row+1, col);
    int r2 = (rgb2 >> 16) & 0xFF;
    int g2 = (rgb2 >>  8) & 0xFF;
    int b2 = (rgb2 >>  0) & 0xFF;
    int r = r1-r2;
    int g = g1-g2;
    int b = b1-b2;
    return r*r + g*g + b*b;
  }
  
  private int getYGradient(int row, int col) {
    int rgb1 = picture_.getRGB(row, col-1);
    int r1 = (rgb1 >> 16) & 0xFF;
    int g1 = (rgb1 >>  8) & 0xFF;
    int b1 = (rgb1 >>  0) & 0xFF;
    int rgb2 = picture_.getRGB(row, col+1);
    int r2 = (rgb2 >> 16) & 0xFF;
    int g2 = (rgb2 >>  8) & 0xFF;
    int b2 = (rgb2 >>  0) & 0xFF;
    int r = r1-r2;
    int g = g1-g2;
    int b = b1-b2;
    return r*r + g*g + b*b;
  }

  public void removeHorizontalSeam(int[] seam) {
    final boolean is_valid = isValidSeam(seam, width_, height_) && height_ > 1;
    if (!is_valid) {
      throw new IllegalArgumentException("resolution out of bounds");
    }
  }
  
  public void removeVerticalSeam(int[] seam) {
    final boolean is_valid = isValidSeam(seam, height_, width_) && width_ > 1;
    if (!is_valid) {
      throw new IllegalArgumentException("resolution out of bounds");
    }
  }

  private boolean isValidSeam(int[] seam, int length, int range) {
    if (seam == null || seam.length != length) {
      return false;
    }
    int previous_entry = seam[0];
    for (int entry : seam) {
      if (entry < 0 || entry >= range || Math.abs(previous_entry - entry) > 1) {
        return false;
      }
    }
    return true;
  }


}
