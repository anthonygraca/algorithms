package io.anthonygraca.princeton.chapter1.percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
  private static final double CONFIDENCE_95 = 1.96;

  private final double[] attempts;

  private final int numberOfTrials;

  // perform independent trials on an n-by-n grid
  public PercolationStats(int n, int trials) {
    attempts = new double[trials];
    numberOfTrials = trials;
    for (int i = 0; i < trials; i++) {
      Percolation p = new Percolation(n);
      while (!p.percolates()) {
        p.open(StdRandom.uniform(n) + 1, StdRandom.uniform(n) + 1);
      }
      attempts[i] = ((double) p.numberOfOpenSites()) / (n*n);
    }
  }

  // sample mean of percolation threshold
  public double mean() {
    return StdStats.mean(attempts);
  }

  // sample standard deviation of percolation threshold
  public double stddev() {
    return StdStats.stddev(attempts);
  }

  // low endpoint of 95% confidence interval
  public double confidenceLo() {
    return mean() - (CONFIDENCE_95 * stddev()) / Math.sqrt(numberOfTrials);
  }

  // high endpoint of 95% confidence interval
  public double confidenceHi() {
    return mean() + (CONFIDENCE_95 * stddev()) / Math.sqrt(numberOfTrials);
  }

 // test client (see below)
 public static void main(String[] args) {
   PercolationStats ps = new PercolationStats(Integer.parseInt(args[0]), 
                                              Integer.parseInt(args[1]));
   System.out.println("mean                    = " + ps.mean());
   System.out.println("stddev                  = " + ps.stddev());
   System.out.println("95% confidence interval = [" + ps.confidenceLo() + ", " + ps.confidenceHi() + "]");
 }
}
