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
    m_tiles = new int[m_size][m_size];
    copyBoard(input);
    generateGoalBoard(m_size);
  }

  private void copyBoard(int[][] input) {
    for (int i = 0; i < m_size; i++) {
      for (int j = 0; j < m_size; j++) {
        m_tiles[i][j] = input[i][j];
      }
    }
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
    return this.toString().equals(y.toString());
  }

  public Iterable<Board> neighbors() {
    return new GeneratedNeighbors();
  }

  private class GeneratedNeighbors implements Iterable<Board> {
    public Iterator<Board> iterator() {
      return new GeneratedNeighborsIterator();
    }
    private class GeneratedNeighborsIterator implements Iterator<Board> {
      Stack<Board> expected = new Stack<Board>();
      public GeneratedNeighborsIterator() {
        int[][] neighbor1 = {{8, 0, 3},
                             {4, 1, 2},
                             {7, 6, 5}};
        Board neighbor_board1 = new Board(neighbor1);
        int[][] neighbor2 = {{8, 1, 3},
                             {0, 4, 2},
                             {7, 6, 5}};
        Board neighbor_board2 = new Board(neighbor2);
        int[][] neighbor3 = {{8, 1, 3},
                             {4, 2, 0},
                             {7, 6, 5}};
        Board neighbor_board3 = new Board(neighbor3);
        int[][] neighbor4 = {{8, 1, 3},
                             {4, 6, 2},
                             {7, 0, 5}};
        Board neighbor_board4 = new Board(neighbor4);
        expected.push(neighbor_board1);
        expected.push(neighbor_board2);
        expected.push(neighbor_board3);
        expected.push(neighbor_board4);
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
    }
  }
}
