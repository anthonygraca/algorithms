package io.anthonygraca.princeton.chapter2.EightPuzzle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.Stack;
import java.util.Iterator;

import org.junit.Test;

public class BoardTest {
/*
 * Constructor.  You may assume that the constructor receives an n-by-n array 
 * containing the n^2 integers between 0 and n^2 − 1, where 0 represents the 
 * blank square. You may also assume that 2 ≤ n < 128.
 *
 * String representation.  The toString() method returns a string composed of 
 * n + 1 lines. The first line contains the board size n; the remaining n 
 * lines contains the n-by-n grid of tiles in row-major order, using 0 to 
 * designate the blank square.
 */
  @Test
  public void verifyStringRepresentation() {
    int[][] input = {{1, 0, 3},
                     {4, 2, 5},
                     {7, 8, 6}};
    Board board = new Board(input);
    String expected = "3\n" +
                      " 1  0  3 \n" +
                      " 4  2  5 \n" +
                      " 7  8  6 \n";
    assertEquals(expected, board.toString());
  }

  @Test
  public void verifyAnotherStringRepresentation() {
    int[][] input = {{0, 1, 3},
                     {4, 2, 5},
                     {7, 8, 6}};
    Board board = new Board(input);
    String expected = "3\n" +
                      " 0  1  3 \n" +
                      " 4  2  5 \n" +
                      " 7  8  6 \n";
    assertEquals(expected, board.toString());
  }

  @Test
  public void verifyDimension() {
    int[][] input = {{0, 1, 3},
                     {4, 2, 5},
                     {7, 8, 6}};
    Board board = new Board(input);
    int expected = 3;
    assertEquals(expected, board.dimension());
  }

// Hamming and Manhattan distances.  To measure how close a board is to the 
// goal board, we define two notions of distance. The Hamming distance 
// betweeen a board and the goal board is the number of tiles in the wrong 
// position. The Manhattan distance between a board and the goal board is the 
// sum of the Manhattan distances (sum of the vertical and horizontal 
// distance) from the tiles to their goal positions.
  @Test
  public void verifyHammingDistance() {
    int[][] input = {{8, 1, 3},
                     {4, 0, 2},
                     {7, 6, 5}};
    Board board = new Board(input);
    final int expected = 5;
    assertEquals(expected, board.hamming());
  }

  @Test
  public void verifyManhattanDistance() {
    int[][] input = {{8, 1, 3},
                     {4, 0, 2},
                     {7, 6, 5}};
    Board board = new Board(input);
    final int expected = 1 + 2 + 2 + 2 + 3;
    assertEquals(expected, board.manhattan());
  }
  @Test
  public void verifyEqualBoards() {
    int[][] input = {{8, 1, 3},
                     {4, 0, 2},
                     {7, 6, 5}};
    Board board = new Board(input);
    Board board1 = new Board(input);
    assertTrue(board.equals(board1));
  }

  @Test
  public void verifyNonEqualBoards() {
    int[][] input = {{8, 1, 3},
                     {4, 0, 2},
                     {7, 6, 5}};
    int[][] input1 = {{8, 1, 3},
                      {4, 0, 2},
                      {7, 5, 6}};
    Board board = new Board(input);
    Board board1 = new Board(input1);
    assertFalse(board.equals(board1));
  }

  @Test
  public void verifyEqualBoardsWithNull() {
    int[][] input = {{8, 1, 3},
                     {4, 0, 2},
                     {7, 6, 5}};
    Board board = new Board(input);
    assertFalse(board.equals(null));
  }

  @Test
  public void verifyBoardIsNotGoal() {
    int[][] input = {{8, 1, 3},
                     {4, 0, 2},
                     {7, 6, 5}};
    Board board = new Board(input);
    assertFalse(board.isGoal());
  }

  @Test
  public void verifyNeighbors() {
    int[][] input = {{8, 1, 3},
                     {4, 0, 2},
                     {7, 6, 5}};
    Board board = new Board(input);
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
    Stack<Board> expected = new Stack<Board>();
    expected.push(neighbor_board1);
    expected.push(neighbor_board2);
    expected.push(neighbor_board3);
    expected.push(neighbor_board4);
    Iterator<Board> generated_neighbors = board.neighbors().iterator();
    while(!expected.empty()) {
      assertTrue(generated_neighbors.next().equals(expected.pop()));
    }
  }

  @Test
  public void verifyBoardIsGoal() {
    int[][] input = {{1, 2, 3},
                     {4, 5, 6},
                     {7, 8, 0}};
    Board board = new Board(input);
    assertTrue(board.isGoal());
  }

  @Test
  public void verifyManhattanExample1() {
    int[][] input = {{4, 1, 3},
                     {0, 2, 5},
                     {7, 8, 6}};
    Board board = new Board(input);
    final int expected = 5;
    assertEquals(expected, board.manhattan());
  }

  @Test
  public void verifyManhattanExample2() {
    int[][] input = {{1, 0, 3},
                     {4, 2, 5},
                     {7, 8, 6}};
    Board board = new Board(input);
    final int expected = 3;
    assertEquals(expected, board.manhattan());
  }

  @Test
  public void verifyTwin() {
    int[][] input = {{1, 0, 3},
                     {4, 2, 5},
                     {7, 8, 6}};
    Board board = new Board(input);
    int[][] twin = {{1, 0, 3},
                    {2, 4, 5},
                    {7, 8, 6}};
    Board expected = new Board(twin);
    assertEquals(expected, board.twin());
  }

  @Test
  public void verifyTwinOtherCase() {
    int[][] input = {{4, 1, 3},
                     {0, 2, 5},
                     {7, 8, 6}};
    Board board = new Board(input);
    int[][] twin = {{1, 4, 3},
                    {0, 2, 5},
                    {7, 8, 6}};
    Board expected = new Board(twin);
    assertEquals(expected, board.twin());
  }
}
