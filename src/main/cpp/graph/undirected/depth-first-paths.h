#ifndef ALGORITHMS_PRINCETON_UNDIRECTED_GRAPHS_DEPTH_FIRST_SEARCH_PATH_FINDING_H_
#define ALGORITHMS_PRINCETON_UNDIRECTED_GRAPHS_DEPTH_FIRST_SEARCH_PATH_FINDING_H_

#include <vector>

#include "graph/graph.h"

namespace algorithms {
class DepthFirstPaths {
  public:
    DepthFirstPaths() = delete;
    DepthFirstPaths(Graph& g, const int source_vertex) 
      : m_marked(g.vertices(), false), 
        m_edge_to(g.vertices(), -1), 
        m_source(source_vertex) {
      dfs(g, source_vertex);
    };
    bool hasPathTo(int v) {return m_marked[v];};
  private:
    std::vector<bool> m_marked;
    std::vector<int> m_edge_to;
    const int m_source;
    void dfs(Graph& g, const int v) {
      m_marked[v] = true;
      for (int w : g.adj(v)) {
        if (!m_marked[w]) {
          m_edge_to[w] = v;
          dfs(g, w);
        }
      }
    };

}; 
} // namespace algorithms

#endif
