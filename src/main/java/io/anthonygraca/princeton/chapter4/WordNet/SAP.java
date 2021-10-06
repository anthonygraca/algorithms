package io.anthonygraca.princeton.chapter4.WordNet;

import edu.princeton.cs.algs4.Digraph;

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
    Stack<Integer> stack_v = new Stack<Integer>();
    Stack<Integer> stack_w = new Stack<Integer>();
    int vertex = v;
    stack_v.push(vertex);
    while (graph.adj(vertex).iterator().hasNext()) {
      vertex = graph.adj(vertex).iterator().next();
      stack_v.push(vertex);
    }
    vertex = w;
    stack_w.push(vertex);
    while (graph.adj(vertex).iterator().hasNext()) {
      vertex = graph.adj(vertex).iterator().next();
      stack_w.push(vertex);
    }
    int ancestor = -1;
    while (stack_w.peek() == stack_v.peek()) {
      ancestor = stack_w.pop();
      stack_v.pop();
    }
    if (ancestor == -1) return -1;
    int count = 0;
    while (!stack_v.isEmpty()) {
      stack_v.pop();
      count++;
    }
    while (!stack_w.isEmpty()) {
      stack_w.pop();
      count++;
    }
    return count;
  }

  public int ancestor(int v, int w) {
    validateBounds(v, w);
    Stack<Integer> stack_v = new Stack<Integer>();
    Stack<Integer> stack_w = new Stack<Integer>();
    int vertex = v;
    stack_v.push(vertex);
    while (graph.adj(vertex).iterator().hasNext()) {
      vertex = graph.adj(vertex).iterator().next();
      stack_v.push(vertex);
    }
    vertex = w;
    stack_w.push(vertex);
    while (graph.adj(vertex).iterator().hasNext()) {
      vertex = graph.adj(vertex).iterator().next();
      stack_w.push(vertex);
    }
    int ancestor = -1;
    while (stack_w.peek() == stack_v.peek()) {
      ancestor = stack_w.pop();
      stack_v.pop();
    }
    return ancestor;
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
