#ifndef ALGORITHMS_PRINCETON_UNDIRECTED_WEIGHTED_GRAPH_MINIMUM_SPANNING_TREE_KRUSKAL_H_
#define ALGORITHMS_PRINCETON_UNDIRECTED_WEIGHTED_GRAPH_MINIMUM_SPANNING_TREE_KRUSKAL_H_

#include <queue>
#include <vector>

#include <graph/undirected/minimum-spanning-tree/edge.h>
#include <graph/undirected/minimum-spanning-tree/edge-weighted-graph.h>

namespace algorithms {

class UnionFind {
public:
  UnionFind(int vertices) {
    for (int i = 0; i < vertices; i++) {
      connected_component_.push_back(i);
    }
  }
  bool isConnected(int v, int w) {
    return connected_component_[v] == connected_component_[w];
  }
  void unionComponents(int v, int w) {
    if (!isConnected(v, w)) {
      int replaced_component = connected_component_[w];
      for (int i = 0; i < connected_component_.size(); i++) {
        if (connected_component_[i] == replaced_component) {
          connected_component_[i] = connected_component_[v];
        }
      }
    }
  }
private:
  std::vector<int> connected_component_;
};
  
class KruskalMst {
public:
  KruskalMst(const EdgeWeightedGraph& g) : uf_(g.getVertices()) {
    for (auto e : g.getEdges()) {
      min_pq_.push(e);
    }
    while ((min_pq_.size() > 0) && (mst_.size() < g.getVertices() - 1)) {
      Edge e = min_pq_.top(); min_pq_.pop();
      int v = e.either();
      int w = e.other(v);
      if (!uf_.isConnected(v, w)) {
        uf_.unionComponents(v, w);
        mst_.push_back(e);
      }
    }
  }
  double getWeight() const {
    double sum = 0.0;
    for (auto e : mst_) { sum += e.getWeight(); }
    return sum;
  }
  std::vector<Edge> getEdges() const {
    return mst_;
  }
private:
  UnionFind uf_;
  std::priority_queue<Edge, std::vector<Edge>, std::greater<Edge>> min_pq_;
  std::vector<Edge> mst_;
};
} // namespace algorithms

#endif
