package io.anthonygraca.princeton.chapter1.percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
  double[] attempts;

  int number_of_trials;

  // perform independent trials on an n-by-n grid
  public PercolationStats(int n, int trials) {
    attempts = new double[trials];
    number_of_trials = trials;
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
    return mean() - (1.96 * stddev()) / Math.sqrt(number_of_trials);
  }

  // high endpoint of 95% confidence interval
  public double confidenceHi() {
    return mean() + (1.96 * stddev()) / Math.sqrt(number_of_trials);
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
