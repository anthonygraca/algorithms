package io.anthonygraca.princeton.chapter2.EightPuzzle;

import edu.princeton.cs.algs4.MinPQ;

import java.util.Stack;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Solver {
  private MinPQ<SearchNode> m_pq = null;
  private MinPQ<SearchNode> m_pq_unsolvable = null;
  private SearchNode m_current_node = null;
  private SearchNode m_twin_node = null;
  private Stack<Board> solution = null;
  private int m_moves = -1;
  private boolean m_solvable = false;
  public Solver(Board board) {
    m_pq = new MinPQ<SearchNode>();
    m_pq_unsolvable = new MinPQ<SearchNode>();
    if (board == null) {
      throw new IllegalArgumentException("Can't solve a null");
    }
    m_pq.insert(new SearchNode(board));
    m_pq_unsolvable.insert(new SearchNode(board.twin()));
    solveGame();
  }

  private void solveGame() {
    do {
      m_current_node = m_pq.delMin();
      m_twin_node = m_pq_unsolvable.delMin();
      fillHeapWithNeighbors(m_pq, m_current_node);
      fillHeapWithNeighbors(m_pq_unsolvable, m_twin_node);
    } while (!m_current_node.isSolved() && !m_twin_node.isSolved());
    if (m_current_node.isSolved()) {
      m_solvable = true;
      m_moves = m_current_node.getMovesMade();
      solution = new Stack<Board>();
      while(m_current_node != null) {
        solution.push(m_current_node.getBoard());
        m_current_node = m_current_node.getPreviousSearchNode();
      }
    }
    else {
      m_solvable = false;
      m_moves = -1;
    }
  }

  private void fillHeapWithNeighbors(MinPQ<SearchNode> pq, SearchNode current) {
    for (Board neighbor : current.getBoard().neighbors()) {
      if (current.getPreviousSearchNode() == null ||
          !current.getPreviousSearchNode().getBoard().equals(neighbor)) {
            pq.insert(
                new SearchNode(neighbor, current.getMovesMade()+1, current));
      }
    }
  }

  public boolean isSolvable() {
    return m_solvable;
  }
  public int moves() {
    return m_moves;
  }

  private class SearchNode implements Comparable<SearchNode> {
    private Board m_board = null;
    private int m_moves_made = -1;
    private SearchNode m_previous_search_node = null;
    private int m_manhattan_priority_function = -1;
    public SearchNode(Board b) {
      this.m_board = b;
      this.m_moves_made = 0;
      this.m_previous_search_node = null;
      this.m_manhattan_priority_function = this.m_board.manhattan() + 
                                           this.m_moves_made;
    }
    public SearchNode(Board b, int m, SearchNode s) {
      this.m_board = b;
      this.m_moves_made = m;
      this.m_previous_search_node = s;
      this.m_manhattan_priority_function = this.m_board.manhattan() + 
                                           this.m_moves_made;
    }
    private int getPriorityFunction() {
      return this.m_manhattan_priority_function;
    }
    public boolean isSolved() {
      return this.m_board.isGoal();
    }
    public int getMovesMade() {
      return m_moves_made;
    }
    public Board getBoard() {
      return m_board;
    }
    public SearchNode getPreviousSearchNode() {
      return m_previous_search_node;
    }
    public int compareTo(SearchNode that) {
      return this.m_manhattan_priority_function - that.getPriorityFunction();
    }
  }

  public Iterable<Board> solution() {
    if (!isSolvable()) {
      return null;
    }
    return new GeneratedSolution();
  }

  private class GeneratedSolution implements Iterable<Board> {
    public Iterator<Board> iterator() {
      return new GeneratedNeighborsIterator();
    }

    private class GeneratedNeighborsIterator implements Iterator<Board> {
      Queue<Board> solutions = null;
      public GeneratedNeighborsIterator() {
        solutions = new ArrayDeque<Board>();
        while (!solution.empty()) {
          solutions.add(solution.pop());
        }
      }
      public boolean hasNext() {
        return solutions.peek() != null;
      }
      public void remove() {
        throw new UnsupportedOperationException("Remove is unsupported");
      }
      public Board next() {
        if (!hasNext()) {
          throw new NoSuchElementException("Empty");
        }
        return solutions.poll();
      }

    }
  }
}
