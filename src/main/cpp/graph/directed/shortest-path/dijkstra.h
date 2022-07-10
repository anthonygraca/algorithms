#ifndef ALGORITHMS_PRINCETON_DIRECTED_GRAPH_SHORTEST_PATH_DIJKSTRA_H_
#define ALGORITHMS_PRINCETON_DIRECTED_GRAPH_SHORTEST_PATH_DIJKSTRA_H_

#include <queue>
#include <vector>

#include <graph/directed/shortest-path/edge-weighted-digraph.h>
#include <graph/directed/shortest-path/directed-edge.h>

namespace algorithms {
class Dijkstra {
public:
  Dijkstra(const EdgeWeightedDigraph g, int source) {
    dist_to_ = std::vector<double>(g.getVertices(), std::numeric_limits<double>::max());
    for (int i = 0; i < g.getVertices(); i++) {
      edge_to_.push_back(DirectedEdge(i, -1, std::numeric_limits<double>::max()));
     }
    dist_to_[source] = 0.0;
    edge_to_[source] = DirectedEdge(source, -1, 0.0);
    for (auto e : g.adj(source)) {
      edge_to_[e.to()] = e;
      dist_to_[e.to()] = dist_to_[e.from()] + e.weight();
      min_pq_.push(e);
    }

    while (min_pq_.size() > 0) {
      DirectedEdge min = min_pq_.top(); min_pq_.pop();
      for (auto e : g.adj(min.to())) {
        if (dist_to_[e.to()] > dist_to_[e.from()] + e.weight()) {
          dist_to_[e.to()] = dist_to_[e.from()] + e.weight();
          edge_to_[e.to()] = e;
          min_pq_.push(e);
        }
      }
    }
  }
  std::vector<double> getWeight() const { return dist_to_; }
  std::vector<DirectedEdge> getEdges() const {
    return edge_to_;
  }
private:
  std::vector<DirectedEdge> edge_to_;
  std::vector<double> dist_to_;
  std::priority_queue<DirectedEdge, std::vector<DirectedEdge>,
      std::greater<DirectedEdge>> min_pq_;
};
} // namespace algorithms
#endif
