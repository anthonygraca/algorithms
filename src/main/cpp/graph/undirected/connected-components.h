/*
 * Goal: Preprocess graph to answer queries of the form is v connected to w? in
 *       constant time
 */
#ifndef ALGORITHMS_PRINCETON_UNDIRECTED_GRAPH_CONNECTED_COMPONENTS_H_
#define ALGORITHMS_PRINCETON_UNDIRECTED_GRAPH_CONNECTED_COMPONENTS_H_

#include "graph/graph.h"

namespace algorithms {
class ConnectedComponents {
  public:
    ConnectedComponents() = delete;
    ConnectedComponents(Graph& g) // find connected components in g
      : m_marked(g.vertices(), false), m_id(g.vertices(), -1) {
      for (int i = 0; i < m_marked.size(); i++) {
        if (!m_marked[i]) {
          dfs(g, i);
          m_count++;
        }
      }
    };
    int count() { // number of connected components
      return m_count;
    }
    int id(int v) { // component identifier for v
      return m_id[v];
    }
    bool connected(int v, int w) { // are v and w connected?
      return m_id[v] == m_id[w];
    }
  private:
    std::vector<bool> m_marked;
    std::vector<int> m_id;
    int m_count = 0;
    void dfs(Graph& g, int v) {
      m_marked[v] = true;
      m_id[v] = m_count;
      for (int w : g.adj(v)) {
        if (!m_marked[w]) {
          dfs(g, w);
        }
      }
    }
}; 
} // namespace algorithms

#endif
