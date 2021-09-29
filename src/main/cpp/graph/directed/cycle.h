#ifndef ALGORITHMS_PRINCETON_DIRECTED_GRAPH_CYCLE_H_
#define ALGORITHMS_PRINCETON_DIRECTED_GRAPH_CYCLE_H_

#include <stack>
#include <vector>

#include "graph/digraph.h"

namespace algorithms {
class DirectedCycle {
public:
  DirectedCycle() = delete;
  DirectedCycle(Digraph& g) 
    : m_marked(g.vertices(), false),
      m_edge_to(g.vertices(), -1),
      m_on_stack(g.vertices(), false) {
    for (int i = 0; i < g.vertices(); i++) {
      if (!m_marked[i]) dfs(g, i);
    }
  };
  bool hasCycle() { return !m_cycle_path.empty(); };
  std::stack<int> cycle() { return m_cycle_path; };
private:
  std::vector<bool> m_marked;
  std::vector<int> m_edge_to;
  std::vector<bool> m_on_stack;
  std::stack<int> m_cycle_path;
  void dfs(Digraph& g, int v) {
    m_on_stack[v] = true;
    m_marked[v] = true;
    for (int w : g.adj(v)) {
      if (hasCycle()) return;
      else if (!m_marked[w]) {
        m_edge_to[w] = v;
        dfs(g, w);
      }
      else if (m_on_stack[w]) {
        m_cycle_path = std::stack<int>();
        for (int x = v; x != w; x = m_edge_to[x]) {
          m_cycle_path.push(x);
        }
        m_cycle_path.push(w);
        m_cycle_path.push(v);
      }
    }
    m_on_stack[v] = false;
  }
};
} // namespace algorithms
#endif
