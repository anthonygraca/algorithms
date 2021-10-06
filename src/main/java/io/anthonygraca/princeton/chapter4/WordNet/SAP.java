package io.anthonygraca.princeton.chapter4.WordNet;

import edu.princeton.cs.algs4.Digraph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class SAP {
  Digraph graph = null;
  public SAP(Digraph g) {
    if (g == null) {
      throw new IllegalArgumentException("SAP cannot have null input");
    }
    graph = g;
  }

  public int length(int v, int w) {
    validateBounds(v, w);
    DeluxeBFS bfs_v = new DeluxeBFS(graph, v);
    DeluxeBFS bfs_w = new DeluxeBFS(graph, w);
    int root = getRoot(v);
    if (!(bfs_v.hasPathTo(root) && bfs_w.hasPathTo(root))) return -1;
    ArrayDeque<Integer> stack_v = bfs_v.pathTo(root);
    ArrayDeque<Integer> stack_w = bfs_w.pathTo(root);
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
    DeluxeBFS bfs_v = new DeluxeBFS(graph, v);
    DeluxeBFS bfs_w = new DeluxeBFS(graph, w);
    int root = getRoot(v);
    if (!(bfs_v.hasPathTo(root) && bfs_w.hasPathTo(root))) return -1;
    ArrayDeque<Integer> stack_v = bfs_v.pathTo(root);
    ArrayDeque<Integer> stack_w = bfs_w.pathTo(root);
    int ancestor = -1;
    while (stack_v.peekFirst() == stack_w.peekFirst()) {
      ancestor = stack_v.removeFirst();
      stack_w.removeFirst();
    }
    return ancestor;
  }


  private int getRoot(int v) {
    int vertex = v;
    while(hasParent(vertex)) {
      vertex = getParent(vertex);
    }
    return vertex;
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
    return -1;
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
}
