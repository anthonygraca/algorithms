#ifndef ALGORITHMS_PRINCETON_DIRECTED_GRAPH_TOPOLOGICAL_SORT_H_
#define ALGORITHMS_PRINCETON_DIRECTED_GRAPH_TOPOLOGICAL_SORT_H_

#include <stack>
#include <vector>

#include "graph/digraph.h"

namespace algorithms {
class TopologicalSort {
public:
  TopologicalSort() = delete;
  TopologicalSort(Digraph& g) : m_marked(g.vertices(), false) {
    for (int i = 0; i < g.vertices(); i++) {
      if (!m_marked[i]) dfs(g, i);
    }
  };
  std::stack<int> order() {
    return m_reverse_postorder;
  }
  void dfs(Digraph& g, int v) {
    m_marked[v] = true;
    for (int w : g.adj(v)) {
      if (!m_marked[w]) {
        dfs(g, w);
      }
    }
    m_reverse_postorder.push(v);
  }
private:
  std::vector<bool> m_marked;
  std::stack<int> m_reverse_postorder;
};
} // namespace algorithms

#endif
