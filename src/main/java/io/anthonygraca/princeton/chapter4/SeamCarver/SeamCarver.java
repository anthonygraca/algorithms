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

  public int[] findVerticalSeam() {
    double[][] accumulated_energy = accumulateEnergyToBottom();
    // find minimum energy
    int height = picture_.height();
    double min = 1000.0 * height;
    int index = 0;
    for (int i = 0; i < width_; i++) {
      double current = accumulated_energy[height-1][i];
      if (min > current) {
        min = current;
        index = i;
      }
    }
    // find smallest path starting from index w/ minimum energy
    return findPathFromBottom(accumulated_energy, index);
  }

  
  public int[] findHorizontalSeam() {
    double[][] accumulated_energy = accumulateEnergyToRight();
    // find minimum energy
    double min = 1000.0 * width_;
    int index = 0;
    for (int i = 0; i < height_; i++) {
      double current = accumulated_energy[i][width_-1];
      if (min > current) {
        min = current;
        index = i;
      }
    }
    // find smallest path starting from index w/ minimum energy
    return findPathFromRight(accumulated_energy, index);
  }
  
  public double[][] accumulateEnergyToRight() {
    double[][] accumulated_energy = new double[height_][width_];
    // populate edges of image
    for (int i = 0; i < width_; i++) {
      accumulated_energy[0][i] = 1000.0;
      accumulated_energy[height_-1][i] = 1000.0;
    }
    for (int i = 0; i < height_; i++) {
      accumulated_energy[i][0] = 1000.0;
    }
    for (int j = 1; j < width_; j++) {
      for (int i = 0; i < height_; i++) {
        double left = Double.MAX_VALUE;
        double middle = Double.MAX_VALUE;
        double right = Double.MAX_VALUE;
        if (i > 0) left = accumulated_energy[i-1][j-1];
        middle = accumulated_energy[i][j-1];
        if (i < height_-1) right = accumulated_energy[i+1][j-1];
        double min = Math.min(Math.min(left, middle), right);
        accumulated_energy[i][j] = min + energy(j, i);
      }
    }
    return accumulated_energy;
  }

  private int[] findPathFromRight(double[][] grid, int w) {
    int[] path = new int[width_];
    for (int i = width_-1; i > 0; i--) {
      path[i] = w;
      double middle = Double.MAX_VALUE;
      double left = Double.MAX_VALUE;
      double right = Double.MAX_VALUE;
      middle = grid[w][i-1];
      if (w > 0) left = grid[w-1][i-1];
      if (w < height_-1) right = grid[w+1][i-1];
      double min = Math.min(Math.min(left, middle), right);
      if (min == left) {
        w = w-1;
      }
      else if (min == right) {
        w = w+1;
      }
      else {
        w = w;
      }
    }
    path[0] = w;
    return path;
  }

  public double[][] accumulateEnergyToBottom() {
    int height = picture_.height();
    int width = picture_.width();
    double[][] accumulated_energy = new double[height][width];
    // populate edges of image
    for (int i = 0; i < width; i++) {
      accumulated_energy[0][i] = 1000.0;
    }
    for (int i = 0; i < height; i++) {
      accumulated_energy[i][0] = 1000.0;
      accumulated_energy[i][width-1] = 1000.0;
    }
    for (int i = 1; i < height; i++) {
      for (int j = 0; j < width; j++) {
        double left = Double.MAX_VALUE;
        double middle = Double.MAX_VALUE;
        double right = Double.MAX_VALUE;
        if (j > 0) left = accumulated_energy[i-1][j-1];
        middle = accumulated_energy[i-1][j];
        if (j < width_-1) right = accumulated_energy[i-1][j+1];
        double min = Math.min(Math.min(left, middle), right);
        accumulated_energy[i][j] = min + energy(j, i);
      }
    }
    return accumulated_energy;
  }

  private int[] findPathFromBottom(double[][] grid, int w) {
    int width = grid[0].length;
    int height = grid.length;
    int[] path = new int[height];
    for (int i = height-1; i > 0; i--) {
      path[i] = w;
      double middle = Double.MAX_VALUE;
      double left = Double.MAX_VALUE;
      double right = Double.MAX_VALUE;
      middle = grid[i-1][w];
      if (w > 0) left = grid[i-1][w-1];
      if (w < width-1) right = grid[i-1][w+1];
      double min = Math.min(Math.min(left, middle), right);
      if (min == left) {
        w = w-1;
      }
      else if (min == right) {
        w = w+1;
      }
      else {
        w = w;
      }
    }
    path[0] = w;
    return path;
  }
}
