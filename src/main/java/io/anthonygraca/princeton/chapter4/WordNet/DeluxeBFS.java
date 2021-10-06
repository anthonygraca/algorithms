package io.anthonygraca.princeton.chapter4.WordNet;

import edu.princeton.cs.algs4.Digraph;

import java.util.ArrayDeque;
import java.util.Queue;

public class DeluxeBFS {
  private boolean[] marked;
  private int[] edgeTo;
  private final int s;
  
  public DeluxeBFS(Digraph G, int s) {
    marked = new boolean[G.V()];
    edgeTo = new int[G.V()];
    this.s = s;
    bfs(G,s);
  }

  private void bfs(Digraph G, int s) {
    Queue<Integer> queue = new ArrayDeque<Integer>();
    marked[s] = true;
    queue.add(s);
    while(queue.peek() != null) {
      int v = queue.poll();
      for (int w : G.adj(v)) {
        if (!marked[w]) {
          edgeTo[w] = v;
          marked[w] = true;
          queue.add(w);
        }
      }
    }
  }

  public boolean hasPathTo(int v) {
    return marked[v];
  }

  public ArrayDeque<Integer> pathTo(int v) {
    if (!hasPathTo(v)) return null;
    ArrayDeque<Integer> path = new ArrayDeque<Integer>();
    for (int x = v; x != s; x = edgeTo[x]) {
      path.add(x);
    }
    path.add(s);
    return path;
  }
}
