package io.anthonygraca.princeton.chapter4.WordNet;

import edu.princeton.cs.algs4.Digraph;

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
    return -1;
  }

  public int ancestor(int v, int w) {
    validateBounds(v, w);
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
