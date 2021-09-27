#ifndef ALGORITHMS_PRINCETON_UNDIRECTED_GRAPHS_DEPTH_FIRST_SEARCH_H_
#define ALGORITHMS_PRINCETON_UNDIRECTED_GRAPHS_DEPTH_FIRST_SEARCH_H_

#include <string>

#include "graph/graph.h"

namespace algorithms {
class DepthFirstSearch {
  public:
    DepthFirstSearch(Graph& g, int source_vertex) 
      : m_marked(g.vertices(), false) {
      dfs(g, source_vertex);
    }
    bool marked(int source_vertex) {
      return m_marked[source_vertex];
    }
    void dfs(Graph& g, int v) {
      m_marked[v] = true;
      m_count++;
      for (int w : g.adj(v)) {
        if (!m_marked[w]) dfs(g,w);
      }
    }
    int count() {return m_count;};
  private:
    std::vector<bool> m_marked;
    int m_count = 0;
};
} // namespace algorithms
#endif
