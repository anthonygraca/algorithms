package io.anthonygraca.princeton.chapter4.WordNet;

import edu.princeton.cs.algs4.Digraph;

import java.util.ArrayDeque;
import java.util.Queue;

public class DeluxeBFS {
  private boolean[] marked;
  private int[] edgeTo;
  private int[] distTo;
  
  public DeluxeBFS(Digraph G, int s) {
    marked = new boolean[G.V()];
    edgeTo = new int[G.V()];
    distTo = new int[G.V()];
    for (int i = 0; i < G.V(); i++) {
      distTo[i] = Integer.MAX_VALUE;
    }
    bfs(G,s);
  }

  public DeluxeBFS(Digraph G, Iterable<Integer> sources) {
    marked = new boolean[G.V()];
    edgeTo = new int[G.V()];
    distTo = new int[G.V()];
    for (int i = 0; i < G.V(); i++) {
      distTo[i] = Integer.MAX_VALUE;
    }
    bfs(G,sources);
  }

  private void bfs(Digraph G, int s) {
    Queue<Integer> queue = new ArrayDeque<Integer>();
    marked[s] = true;
    distTo[s] = 0;
    queue.add(s);
    while(queue.peek() != null) {
      int v = queue.poll();
      for (int w : G.adj(v)) {
        if (!marked[w]) {
          edgeTo[w] = v;
          distTo[w] = distTo[v] + 1;
          marked[w] = true;
          queue.add(w);
        }
      }
    }
  }

  private void bfs(Digraph G, Iterable<Integer> sources) {
    Queue<Integer> queue = new ArrayDeque<Integer>();
    for (int v : sources) {
      marked[v] = true;
      distTo[v] = 0;
      queue.add(v);
    }
    while(queue.peek() != null) {
      int v = queue.poll();
      for (int w : G.adj(v)) {
        if (!marked[w]) {
          edgeTo[w] = v;
          distTo[w] = distTo[v] + 1;
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
    int x;
    for (x = v; distTo[x] != 0; x = edgeTo[x]) {
      path.add(x);
    }
    path.add(x);
    return path;
  }

  public void transferDistance(int[] ancestor_distance) {
    for (int i = 0; i < distTo.length; i++) {
      if (hasPathTo(i) && ancestor_distance[i] != Integer.MAX_VALUE) {
        ancestor_distance[i] += distTo[i];
      }
      else {
	ancestor_distance[i] = Integer.MAX_VALUE;
      }
    }
  }

  public int getDistance(int v) {
    return distTo[v];
  }
}
