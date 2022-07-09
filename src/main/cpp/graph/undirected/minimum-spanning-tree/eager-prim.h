#ifndef ALGORITHMS_PRINCETON_UNDIRECTED_WEIGHTED_GRAPH_MINIMUM_SPANNING_TREE_EAGER_PRIM_H_
#define ALGORITHMS_PRINCETON_UNDIRECTED_WEIGHTED_GRAPH_MINIMUM_SPANNING_TREE_EAGER_PRIM_H_

#include <queue>
#include <unordered_set>
#include <vector>

#include <graph/undirected/minimum-spanning-tree/edge-weighted-graph.h>
#include <graph/undirected/minimum-spanning-tree/edge.h>

namespace algorithms {
  class EagerPrim {
  public:
    EagerPrim(const EdgeWeightedGraph& g) : marked_(g.getVertices(), false) {
      visit(g, 0);
      while (pq_.size() > 0) {
	Edge e = pq_.top(); pq_.pop();
	int v = e.either(), w = e.other(v);
	if (marked_[v] && marked_[w]) continue;
	weight_ += e.getWeight();
	mst_.push_back(e);
	if (!marked_[v]) visit(g, v);
	if (!marked_[w]) visit(g, w);
      }
    }
    std::vector<Edge> getEdges() {
      return mst_;
    }
    double getWeight() const {
      return weight_;
    }
  private:
    std::vector<bool> marked_;
    std::priority_queue<Edge, std::vector<Edge>, std::greater<Edge>> pq_;
    std::vector<Edge> mst_;
    double weight_{0.0};
    void visit(const EdgeWeightedGraph& g, int v) {
      marked_[v] = true;
      for (auto e : g.adj(v)) {
        if (!marked_[e.other(v)]) pq_.push(e);
      }
    }
  };
} // namespace algorithms
#endif
