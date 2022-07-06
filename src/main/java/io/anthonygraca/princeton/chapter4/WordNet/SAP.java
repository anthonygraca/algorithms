package io.anthonygraca.princeton.chapter4.WordNet;

import edu.princeton.cs.algs4.Digraph;

import java.util.Iterator;

public class SAP {
  private final Digraph graph;
  public SAP(Digraph g) {
    if (g == null) {
      throw new IllegalArgumentException("SAP cannot have null input");
    }
    graph = new Digraph(g);
  }

  public int length(int v, int w) {
    validateBounds(v, w);
    DeluxeBFS bfs_v = new DeluxeBFS(graph, v);
    DeluxeBFS bfs_w = new DeluxeBFS(graph, w);
    int[] distance = new int[graph.V()];
    for (int i = 0; i < graph.V(); i++) {
	distance[i] = 0;
    }
    bfs_v.transferDistance(distance);
    bfs_w.transferDistance(distance);
    int min = Integer.MAX_VALUE;
    
    for (int i = 0; i < distance.length; i++) {
	if (distance[i] < min) {
	    min = distance[i];
	}
    }
    return (min == Integer.MAX_VALUE) ? -1 : min;
  }

  public int ancestor(int v, int w) {
    validateBounds(v, w);
    DeluxeBFS bfs_v = new DeluxeBFS(graph, v);
    DeluxeBFS bfs_w = new DeluxeBFS(graph, w);
    int[] distance = new int[graph.V()];
    for (int i = 0; i < graph.V(); i++) {
	distance[i] = 0;
    }
    bfs_v.transferDistance(distance);
    bfs_w.transferDistance(distance);
    int min = Integer.MAX_VALUE;
    int ancestor = -1;
    for (int i = 0; i < distance.length; i++) {
	if (distance[i] < min) {
	    min = distance[i];
	    ancestor = i;
	}
    }
    return ancestor;
  }
    
  public int length(Iterable<Integer> v, Iterable<Integer> w) {
    if (v == null || w == null) {
      throw new IllegalArgumentException("Iterable can't be null");
    }
    validateBounds(v, w);
    DeluxeBFS bfs_v = new DeluxeBFS(graph, v);
    DeluxeBFS bfs_w = new DeluxeBFS(graph, w);
    int[] distance = new int[graph.V()];
    for (int i = 0; i < graph.V(); i++) {
      distance[i] = 0;
    }
    bfs_v.transferDistance(distance);
    bfs_w.transferDistance(distance);
    int min = Integer.MAX_VALUE;
    for(int i = 0; i < distance.length; i++) {
      if (distance[i] < min) {
	min = distance[i];
      }
    }
    return (min == Integer.MAX_VALUE) ? -1 : min;
  }

  public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
    if (v == null || w == null) {
      throw new IllegalArgumentException("Iterable can't be null");
    }
    validateBounds(v, w);
    DeluxeBFS bfs_v = new DeluxeBFS(graph, v);
    DeluxeBFS bfs_w = new DeluxeBFS(graph, w);
    int[] distance = new int[graph.V()];
    for (int i = 0; i < graph.V(); i++) {
	distance[i] = 0;
    }
    bfs_v.transferDistance(distance);
    bfs_w.transferDistance(distance);
    int min = Integer.MAX_VALUE;
    int ancestor = -1;
    for (int i = 0; i < graph.V(); i++) {
      if (distance[i] < min) {
	min = distance[i];
	ancestor = i;
      }
    }
    return ancestor;
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
    Iterator<Integer> iter = v.iterator();
    while (iter.hasNext()) {
      Integer vertex = iter.next();
      if (vertex == null) {
	throw new IllegalArgumentException("null");
      }
      if(vertex.intValue() < 0) {
        throw new IllegalArgumentException("Vertex can't be negative");
      }
      if (vertex.intValue() >= max_vertices) {
        throw new IllegalArgumentException("Vertex can't be above bounds");
      }
    }
    iter = w.iterator();
    while (iter.hasNext()) {
      Integer vertex = iter.next();
      if (vertex == null) {
	throw new IllegalArgumentException("null");
      }
      if(vertex.intValue() < 0) {
        throw new IllegalArgumentException("Vertex can't be negative");
      }
      if (vertex.intValue() >= max_vertices) {
        throw new IllegalArgumentException("Vertex can't be above bounds");
      }
    }
  }
}
