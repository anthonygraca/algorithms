#ifndef ALGORITHMS_PRINCETON_UNDIRECTED_GRAPH_BREADTH_FIRST_SEARCH_H_
#define ALGORITHMS_PRINCETON_UNDIRECTED_GRAPH_BREADTH_FIRST_SEARCH_H_

#include <queue>
#include <stack>
#include <vector>

#include "graph/graph.h"

namespace algorithms {
class BreadthFirstPaths {
  public:
    BreadthFirstPaths() = delete;
    BreadthFirstPaths(Graph& g, int source_vertex) 
      : m_marked(g.vertices(), false), 
        m_edge_to(g.vertices(), -1), 
        m_source(source_vertex) { bfs(g, source_vertex); };
    bool hasPathTo(int v){return m_marked[v];};
    std::stack<int> pathTo(int v) {
      std::stack<int> stack;
      for (int x = v; x != m_source; x = m_edge_to[x]) {
        stack.push(x);
      }
      stack.push(m_source);
      return stack;
    }
  private:
    std::vector<bool> m_marked;
    std::vector<int> m_edge_to;
    const int m_source;
    std::queue<int> m_queue;
    void bfs(Graph& g, int s) {
      m_marked[s] = true;
      m_queue.push(s);
      while (!m_queue.empty()) {
        int v = m_queue.front();
        m_queue.pop();
        for (int w : g.adj(v)) {
          if (!m_marked[w]) {
            m_edge_to[w] = v;
            m_marked[w] = true;
            m_queue.push(w);
          }
        }
      }
    }
}; 
} // namespace algorithms
#endif
