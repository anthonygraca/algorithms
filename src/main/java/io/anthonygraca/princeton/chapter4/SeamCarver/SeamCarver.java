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
    return 0.0;
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
