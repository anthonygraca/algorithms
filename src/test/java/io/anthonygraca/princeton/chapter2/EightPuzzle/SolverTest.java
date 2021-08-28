package io.anthonygraca.princeton.chapter2.EightPuzzle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Iterator;

import org.junit.Test;

public class SolverTest {
  @Test(expected=IllegalArgumentException.class)
  public void handleNullArgumentInConstructor() {
    Solver solver = new Solver(null);
  }

//  @Test
  public void handleExample() {
    int[][] input = {{0, 1, 3},
                     {4, 2, 5},
                     {7, 8, 6}};
    Board board = new Board(input);
    Solver solver = new Solver(board);
    Queue<Board> expected = new ArrayDeque<Board>();
    expected.add(board);
    int[][] move1 = {{1, 0, 3},
                     {4, 2, 5},
                     {7, 8, 6}};
    expected.add(new Board(move1));
    int[][] move2 = {{1, 2, 3},
                     {4, 0, 5},
                     {7, 8, 6}};
    expected.add(new Board(move2));
    int[][] move3 = {{1, 2, 3},
                     {4, 5, 0},
                     {7, 8, 6}};
    expected.add(new Board(move3));
    int[][] move4 = {{1, 2, 3},
                     {4, 5, 6},
                     {7, 8, 0}};
    expected.add(new Board(move4));
    Iterator<Board> solution = solver.solution().iterator();
    while(expected.peek() != null) { 
      assertTrue(solution.next().equals(expected.poll()));
    }
    assertTrue(solver.isSolvable());
    assertEquals(4, solver.moves());
  }

  @Test
  public void handleUnsolvable() {
    int[][] input = {{1, 2, 3},
                     {4, 5, 6},
                     {8, 7, 0}};
    Board board = new Board(input);
    Solver solver = new Solver(board);
    assertFalse(solver.isSolvable());
    assertEquals(-1, solver.moves());
    assertEquals(null, solver.solution());
  }
}

