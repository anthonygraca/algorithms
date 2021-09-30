#ifndef ALGORITHMS_PRINCETON_DIRECTED_GRAPH_KOSARAJU_SHARIR_STRONGLY_CONNECTED_COMPONENTS_H_
#define ALGORITHMS_PRINCETON_DIRECTED_GRAPH_KOSARAJU_SHARIR_STRONGLY_CONNECTED_COMPONENTS_H_
/*
 * Intuition:
 * 1.) If we reverse all the edges, we would get the same strong components.
 * 2.) Kernel DAG == contract each strong component into a single vertex.
 *
 * Idea:
 * 1.) Compute topological order (reverse postorder) in kernel DAG.
 * 2.) Run DFS, considering vertices in reverse topological order
 *
 * DFS in reverse graph
 */

#include <vector>

#include "graph/digraph.h"
#include "graph/directed/topological-sort.h"

namespace algorithms {
class StronglyConnectedComponents {
public:
  StronglyConnectedComponents() = delete;
  StronglyConnectedComponents(Digraph& g) 
    : m_marked(g.vertices(), false),
      m_strongly_connected_component(g.vertices(), -1) {
    TopologicalSort reverse_postorder{g.reverse()};
    std::stack<int> stack = reverse_postorder.order();
    while (!stack.empty()) {
      int w = stack.top(); stack.pop();
      if (!m_marked[w]) {
        dfs(g, w);
        m_count++;
      }
    }
  };
  int count() {
    return m_count;
  }
  bool stronglyConnected(int v, int w) {
    int component_v = m_strongly_connected_component[v];
    int component_w = m_strongly_connected_component[w];
    if (component_v == -1 || component_w == -1) {
      return false;
    }
    return component_v == component_w;
  }
private:
  std::vector<int> m_marked;
  std::vector<int> m_strongly_connected_component;
  int m_count = 0;
  void dfs(Digraph& g, int v) {
    m_marked[v] = true;
    m_strongly_connected_component[v] = m_count;
    for (int w : g.adj(v)) {
      if (!m_marked[w]) {
        dfs(g, w);
      }
    }
  }
};
} // namespace algorithms

#endif
