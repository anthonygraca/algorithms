#ifndef ALGORITHMS_PRINCETON_UNDIRECTED_EDGE_WEIGHTED_GRAPH_H_
#define ALGORITHMS_PRINCETON_UNDIRECTED_EDGE_WEIGHTED_GRAPH_H_

#include <vector>

#include <graph/undirected/minimum-spanning-tree/edge.h>

namespace algorithms {
  class EdgeWeightedGraph {
  public:
    EdgeWeightedGraph(int vertices) : vertices_{vertices} {
      for (int i = 0; i < vertices; i++) {
        std::vector<Edge> edges;
        adj_.push_back(edges);
      }
    }
    int getVertices() const { return vertices_; }
    int getEdges() const { return edges_; }
    void addEdge(const Edge e) {
      adj_[e.either()].push_back(e);
      adj_[e.other(e.either())].push_back(e);
      edges_++;
    }
    std::vector<Edge> adj(int v) const {
      return adj_[v];
    }
  private:
    int vertices_{0};
    int edges_{0};
    std::vector<std::vector<Edge>> adj_;
  };
}  // namespace algorithms
#endif
