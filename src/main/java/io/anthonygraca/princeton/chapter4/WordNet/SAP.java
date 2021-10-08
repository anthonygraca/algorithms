package io.anthonygraca.princeton.chapter4.WordNet;

import edu.princeton.cs.algs4.Digraph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class SAP {
  private DeluxeBFS[] bfs = null;
  Digraph graph = null;
  int root = -1;
  public SAP(Digraph g) {
    if (g == null) {
      throw new IllegalArgumentException("SAP cannot have null input");
    }
    bfs = new DeluxeBFS[g.V()];
    for (int i = 0; i < g.V(); i++) {
      bfs[i] = null;
    }
    graph = g;
  }

  public int length(int v, int w) {
    validateBounds(v, w);
    checkCache(v,w);
    int root = getRoot(v);
    if (!(bfs[v].hasPathTo(root) && bfs[w].hasPathTo(root))) return -1;
    ArrayDeque<Integer> stack_v = bfs[v].pathTo(root);
    ArrayDeque<Integer> stack_w = bfs[w].pathTo(root);
    int ancestor = -1;
    while (stack_v.peekFirst() == stack_w.peekFirst()) {
      ancestor = stack_v.removeFirst();
      stack_w.removeFirst();
    }
    int count = 0;
    while (!stack_v.isEmpty()) {
      stack_v.removeFirst();
      count++;
    }
    while (!stack_w.isEmpty()) {
      stack_w.removeFirst();
      count++;
    }
    return count;
  }

  public int ancestor(int v, int w) {
    validateBounds(v, w);
    checkCache(v,w);
    int root = getRoot(v);
    if (!(bfs[v].hasPathTo(root) && bfs[w].hasPathTo(root))) return -1;
    ArrayDeque<Integer> stack_v = bfs[v].pathTo(root);
    ArrayDeque<Integer> stack_w = bfs[w].pathTo(root);
    int ancestor = -1;
    while (stack_v.peekFirst() == stack_w.peekFirst()) {
      ancestor = stack_v.removeFirst();
      stack_w.removeFirst();
    }
    return ancestor;
  }

  private void checkCache(int v, int w) {
    checkCacheForBfs(v);
    checkCacheForBfs(w);
  }

  private void checkCacheForBfs(int v) {
    if (bfs[v] == null) {
      bfs[v] = new DeluxeBFS(graph, v);
    }
  }

  private int getRoot(int v) {
    if (root == -1) {
      int vertex = v;
      while(hasParent(vertex)) {
        vertex = getParent(vertex);
      }
      return vertex;
    }
    return root;
  }
  
  private int getAncestor(Stack<Integer> path_a, Stack<Integer> path_b) {
    int ancestor = -1;
    while (path_b.peek() == path_a.peek()) {
      ancestor = path_b.pop();
      path_a.pop();
    }
    return ancestor;
  }

  private Stack<Integer> getPathToRoot(int v) {
    Stack<Integer> stack = new Stack<Integer>();
    int vertex = v;
    stack.push(vertex);
    while(hasParent(vertex)) {
      vertex = getParent(vertex);
      stack.push(vertex);
    }
    return stack;
  }

  private boolean hasParent(int v) {
    if(graph.adj(v).iterator().hasNext()) {
      return true;
    }
    return false;
  }

  private int getParent(int v) {
    if(hasParent(v)){
      return graph.adj(v).iterator().next();
    }
    return -1;
  }

  public int length(Iterable<Integer> v, Iterable<Integer> w) {
    if (v == null || w == null) {
      throw new IllegalArgumentException("Iterable can't be null");
    }
    return -1;
  }

  public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
    if (v == null || w == null) {
      throw new IllegalArgumentException("Iterable can't be null");
    }
    validateBounds(v, w);
    checkCache(v,w);
    int root = getRoot(v);
    if (!(bfs[v].hasPathTo(root) && bfs[w].hasPathTo(root))) return -1;
    ArrayDeque<Integer> stack_v = bfs[v].pathTo(root);
    ArrayDeque<Integer> stack_w = bfs[w].pathTo(root);
    int ancestor = -1;
    while (stack_v.peekFirst() == stack_w.peekFirst()) {
      ancestor = stack_v.removeFirst();
      stack_w.removeFirst();
    }
    return ancestor;
  }

  private void checkCache(Iterable<Integer> v, Iterable<Integer> w) {
    for (int vertex : v) {
      checkCacheForBfs(vertex);
    }
    for (int vertex : w) {
      checkCacheForBfs(vertex);
    }
  }

  private void validateBounds(int v, int w) {
    if(v < 0 || w < 0) {
      throw new IllegalArgumentException("Vertex can't be negative");
    }
    int max_vertices = graph.V();
    if (v >= max_vertices || w >= max_vertices) {
      throw new IllegalArgumentException("Vertex can't be above bounds");
    }
  }

  private void validateBounds(Iterable<Integer> v, Iterable<Integer> w) {
    int max_vertices = graph.V();
    for (int vertex : v) {
      if(vertex < 0) {
        throw new IllegalArgumentException("Vertex can't be negative");
      }
      if (vertex >= max_vertices) {
        throw new IllegalArgumentException("Vertex can't be above bounds");
      }
    }
    for (int vertex : w) {
      if(vertex < 0) {
        throw new IllegalArgumentException("Vertex can't be negative");
      }
      if (vertex >= max_vertices) {
        throw new IllegalArgumentException("Vertex can't be above bounds");
      }
    }
  }
}
