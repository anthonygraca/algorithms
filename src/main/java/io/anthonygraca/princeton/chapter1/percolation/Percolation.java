package io.anthonygraca.princeton.chapter1.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
  /*
   * Union-Find Data Type that keeps track of how many disjoint sets we have.
   */
  private WeightedQuickUnionUF union_find;

  /*
   * Array of boolean types that keep track of which sites are open. All sites
   * are initialized as closed.
   */
  private boolean[] sites;

  /*
   * virtual_top_site is a set that allows us to verify all open top sites
   */
  private int virtual_top_site = -1;

  /*
   * virtual_bottom_site is a set that allows us to verify all open bottom sites
   */
  private int virtual_bottom_site = -1;

  /*
   * grid_size represents n on an n-by-n grid
   */
  private int grid_size = -1;

  // creates n-by-n grid, with all sites initially blocked
  public Percolation(int n) {
    if (n <= 0) {
      throw new IndexOutOfBoundsException("grid must be non-zero");
    }
    grid_size = n;
    sites = new boolean[n*n];
    // plus two to allow for our two virtual sites as added sets
    union_find = new WeightedQuickUnionUF(n*n+2);
    // n*n and n*n+1 are both values outside of the grid so we pick those for
    // the virtual sets
    virtual_top_site = n*n;
    virtual_bottom_site = n*n+1;
  }

  // opens the site (row, col) if it is not open already
  public void open(int row, int col) {
    if (row <= 0 || col <= 0 || row > grid_size || col > grid_size) {
      throw new IndexOutOfBoundsException("input must be greater than 0 and within given size");
    }
    checkSpecialCases(row, col);
    sites[getSiteIndex(row, col)] = true; // Mark site as open
    unionOpenNeighbors(row, col);
  }

  // Handles our virtual top/bottom sites
  private void checkSpecialCases(int row, int col) {
    checkAndUnionOpenTopRowSite(row, col);
    checkAndUnionOpenBottomRowSite(row, col);
  }
  // If we have an open top site, union with out virtual site
  private void checkAndUnionOpenTopRowSite(int row, int col) {
    if (row == 1) {
      union_find.union(virtual_top_site, getSiteIndex(row, col));
    }
  }
  // If we have an open bottom site, union with out virtual site
  private void checkAndUnionOpenBottomRowSite(int row, int col) {
    if (row == grid_size) {
      union_find.union(virtual_bottom_site, getSiteIndex(row, col));
    }
  }

  // Checks whether all 4 neighoring sites are open. If they are, union with
  // them
  private void unionOpenNeighbors(int row, int col) {
    if (isTopNeighborOpen(row, col)) {
      union_find.union(getSiteIndex(row - 1, col), getSiteIndex(row, col));
    }
    if (isBottomNeighborOpen(row, col)) {
      union_find.union(getSiteIndex(row + 1, col), getSiteIndex(row, col));
    }
    if (isLeftNeighborOpen(row, col)) {
      union_find.union(getSiteIndex(row, col - 1), getSiteIndex(row, col));
    }
    if (isRightNeighborOpen(row, col)) {
      union_find.union(getSiteIndex(row, col + 1), getSiteIndex(row, col));
    }
  }

  // is the site (row, col) open?
  public boolean isOpen(int row, int col) {
    return sites[getSiteIndex(row, col)];
  }

  // is the site (row, col) full?
  public boolean isFull(int row, int col) {
    return union_find.find(getSiteIndex(row, col)) == union_find.find(virtual_top_site);
  }

  // returns the number of open sites
  public int numberOfOpenSites() {
    int count = 0;
    for (int i = 0; i < sites.length; i++) {
      if (sites[i] == true) {
        count++;
      }
    }
    return count;
  }

  // does the system percolate?
  public boolean percolates() {
    return union_find.find(virtual_top_site) == union_find.find(virtual_bottom_site);
  }

  // Checks if top neighbor is open
  protected boolean isTopNeighborOpen(int row, int col) {
    if (row - 1 == 0) {
      return false;
    }
    return sites[getSiteIndex(row - 1, col)];
  }

  // Checks if bottom neighbor is open
  protected boolean isBottomNeighborOpen(int row, int col) {
    if (row + 1 > grid_size) {
      return false;
    }
    return sites[getSiteIndex(row + 1, col)];
  }

  // Checks if left neighbor is open
  protected boolean isLeftNeighborOpen(int row, int col) {
    if (col - 1 == 0) {
      return false;
    }
    return sites[getSiteIndex(row, col - 1)];
  }

  // Checks if right neighbor is open
  protected boolean isRightNeighborOpen(int row, int col) {
    if (col + 1 > grid_size) {
      return false;
    }
    return sites[getSiteIndex(row, col + 1)];
  }

  // Converts row and col to single array index representation
  private int getSiteIndex(int row, int col) {
    return grid_size * (row - 1) + col - 1;
  }
}
