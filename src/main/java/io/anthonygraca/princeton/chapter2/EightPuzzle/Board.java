package io.anthonygraca.princeton.chapter2.EightPuzzle;

import java.util.Stack;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Board {
  private int[][] m_tiles = null;
  private int m_size = -1;
  private int[][] m_goal_board = null;

  public Board(int[][] input) {
    m_size = input[0].length;
    m_tiles = copyBoard(input);
    generateGoalBoard(m_size);
  }

  private int[][] copyBoard(int[][] input) {
    int[][] tiles = new int[input.length][input.length];
    for (int i = 0; i < input.length; i++) {
      for (int j = 0; j < input.length; j++) {
        tiles[i][j] = input[i][j];
      }
    }
    return tiles;
  }

  private void generateGoalBoard(int size) {
    m_goal_board = new int[size][size];
    int count = 1;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        m_goal_board[i][j] = count++;
      }
    }
    m_goal_board[size-1][size-1] = 0;
  }

  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append(m_size + "\n");
    for (int i = 0; i < m_size; i++) {
      for (int j = 0; j < m_size; j++) {
        s.append(String.format("%2d ", m_tiles[i][j]));
      }
      s.append("\n");
    }
    return s.toString();
  }

  public int dimension() {
    return m_size;
  }

  public int hamming() {
    int differences = 0;
    for (int i = 0; i < m_size; i++) {
      for (int j = 0; j < m_size; j++) {
        if (m_goal_board[i][j] != m_tiles[i][j]) {
          if (m_goal_board[i][j] != 0) {
            differences++;
          }
        }
      }
    }
    return differences;
  }

  public boolean isGoal() {
    for (int i = 0; i < m_size; i++) {
      for (int j = 0; j < m_size; j++) {
        if (m_goal_board[i][j] != m_tiles[i][j]) {
          return false;
        }
      }
    }
    return true;
  }

  public int manhattan() {
    int sum = 0;
    for (int i = 0; i < m_size; i++) {
      for (int j = 0; j < m_size; j++) {
        int desired = m_tiles[i][j];
        if (desired != 0) {
          int goal_row = getRowFromGoal(desired);
          int goal_col = getColFromGoal(desired);
          sum += Math.abs(i-goal_row);
          sum += Math.abs(j-goal_col);
        }
      }
    }
    return sum;
  }

  private int getRowFromGoal(int value) {
    return (value - 1) / m_size;
  }

  private int getColFromGoal(int value) {
    return (value - 1) % m_size;
  }

  public boolean equals(Object y) {
    if (y == null) {
      return false;
    }
    return this.toString().equals(y.toString());
  }

  public Iterable<Board> neighbors() {
    return new GeneratedNeighbors();
  }

  public Board twin() {
    int[][] tiles = copyBoard(m_tiles);
    if (tiles[0][0] != 0 && tiles[0][1] != 0) {
      int swap = tiles[0][0];
      tiles[0][0] = tiles[0][1];
      tiles[0][1] = swap;
    }
    else {
      int swap = tiles[1][0];
      tiles[1][0] = tiles[1][1];
      tiles[1][1] = swap;
    }
    return new Board(tiles);
  }

  private class GeneratedNeighbors implements Iterable<Board> {
    public Iterator<Board> iterator() {
      return new GeneratedNeighborsIterator();
    }
    private class GeneratedNeighborsIterator implements Iterator<Board> {
      Stack<Board> expected = null;
      public GeneratedNeighborsIterator() {
        expected = generateNeighbors(m_tiles);
      }
      public boolean hasNext() {
        return !expected.empty();
      }
      public void remove() {
        throw new UnsupportedOperationException("Remove is unsupported");
      }
      public Board next() {
        if (!hasNext()) {
          throw new NoSuchElementException("Empty");
        }
        return expected.pop();
      }
      private Stack<Board> generateNeighbors(int[][] tiles) {
        Stack<Board> neighbors = new Stack<Board>();
        Board neighbor_board = getUpNeighbor(tiles);
        if (neighbor_board != null) neighbors.push(neighbor_board);
        neighbor_board = getLeftNeighbor(tiles);
        if (neighbor_board != null) neighbors.push(neighbor_board);
        neighbor_board = getRightNeighbor(tiles);
        if (neighbor_board != null) neighbors.push(neighbor_board);
        neighbor_board = getDownNeighbor(tiles);
        if (neighbor_board != null) neighbors.push(neighbor_board);
        return neighbors;
      }
      private Board getUpNeighbor(int[][] tiles) {
        int[][] neighbor = new int[tiles.length][tiles.length];
        for (int i = 0; i < tiles.length; i++) {
          for (int j = 0; j < tiles.length; j++) {
            neighbor[i][j] = tiles[i][j];
            if (neighbor[i][j] == 0) {
              if (i > 0) {
                int zero_tile = neighbor[i][j];
                neighbor[i][j] = neighbor[i-1][j];
                neighbor[i-1][j] = zero_tile;
              }
              else {
                return null;
              }
            }
          }
        }
        Board board = new Board(neighbor);
        return board;
      }
      private Board getLeftNeighbor(int[][] tiles) {
        int[][] neighbor = new int[tiles.length][tiles.length];
        for (int i = 0; i < tiles.length; i++) {
          for (int j = 0; j < tiles.length; j++) {
            neighbor[i][j] = tiles[i][j];
            if (neighbor[i][j] == 0) {
              if (j > 0) {
                int zero_tile = neighbor[i][j];
                neighbor[i][j] = neighbor[i][j-1];
                neighbor[i][j-1] = zero_tile;
              }
              else {
                return null;
              }
            }
          }
        }
        Board board = new Board(neighbor);
        return board;
      }
      private Board getRightNeighbor(int[][] tiles) {
        int[][] neighbor = new int[tiles.length][tiles.length];
        int zero_i = -1;
        int zero_j = -1;
        for (int i = 0; i < tiles.length; i++) {
          for (int j = 0; j < tiles.length; j++) {
            neighbor[i][j] = tiles[i][j];
            if (neighbor[i][j] == 0) {
              zero_i = i;
              zero_j = j;
            }
          }
        }
        if (zero_j < tiles.length-1) {
          int zero_tile = neighbor[zero_i][zero_j];
          neighbor[zero_i][zero_j] = neighbor[zero_i][zero_j+1];
          neighbor[zero_i][zero_j+1] = zero_tile;
        }
        else {
          return null;
        }
        Board board = new Board(neighbor);
        return board;
      }
      private Board getDownNeighbor(int[][] tiles) {
        int[][] neighbor = new int[tiles.length][tiles.length];
        int zero_i = -1;
        int zero_j = -1;
        for (int i = 0; i < tiles.length; i++) {
          for (int j = 0; j < tiles.length; j++) {
            neighbor[i][j] = tiles[i][j];
            if (neighbor[i][j] == 0) {
              zero_i = i;
              zero_j = j;
            }
          }
        }
        if (zero_i < tiles.length-1) {
          int zero_tile = neighbor[zero_i][zero_j];
          neighbor[zero_i][zero_j] = neighbor[zero_i+1][zero_j];
          neighbor[zero_i+1][zero_j] = zero_tile;
        }
        else {
          return null;
        }
        Board board = new Board(neighbor);
        return board;
      }
    }
  }
}
