#ifndef ALGORITHMS_PRINCETON_DIRECTED_GRAPH_DEPTH_FIRST_SEARCH_H_
#define ALGORITHMS_PRINCETON_DIRECTED_GRAPH_DEPTH_FIRST_SEARCH_H_

#include <unordered_set>

#include "graph/digraph.h"

namespace algorithms {
class DirectedDepthFirstSearch {
public:
  DirectedDepthFirstSearch() = delete;
  DirectedDepthFirstSearch(Digraph& g, std::unordered_set<int> sources) 
    : m_marked(g.vertices(), false) {
    for(int s : sources) {
      dfs(g, s);
    }
  };
  bool marked(int v) {
    return m_marked[v];
  }
private:
  std::vector<bool> m_marked;
  void dfs(Digraph& g, int v) {
    m_marked[v] = true;
    for (int w : g.adj(v)) {
      if (!m_marked[w]) {
        dfs(g, w);
      }
    }
  }

};
} // namespace algorithms

#endif
