#ifndef ALGORITHMS_PRINCETON_DIRECTED_GRAPHS_SHORTEST_PATH_EDGE_WEIGHTED_DIGRAPH_H_
#define ALGORITHMS_PRINCETON_DIRECTED_GRAPHS_SHORTEST_PATH_EDGE_WEIGHTED_DIGRAPH_H_

#include <vector>

#include <graph/directed/shortest-path/directed-edge.h>

namespace algorithms {
class EdgeWeightedDigraph {
public:
  EdgeWeightedDigraph(int vertices) : vertices_{vertices} {
    for (int i = 0; i < vertices; i++) {
      std::vector<DirectedEdge> edges;
      adj_.push_back(edges);
    }
  }
  void addEdge(DirectedEdge e) {
    adj_[e.from()].push_back(e);
    edges_++;
  }
  std::vector<DirectedEdge> adj(int v) const {
    return adj_[v];
  }
  int getNumberOfEdges() const { return edges_; }
  int getVertices() const { return vertices_; }
private:
  int vertices_{0};
  int edges_{0};
  std::vector<std::vector<DirectedEdge>> adj_;
};
} // namespace algorithms

#endif
