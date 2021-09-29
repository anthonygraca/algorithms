#ifndef ALGORITHMS_PRINCETON_UNDIRECTED_GRAPH_BREADTH_FIRST_SEARCH_H_
#define ALGORITHMS_PRINCETON_UNDIRECTED_GRAPH_BREADTH_FIRST_SEARCH_H_
/*
 * put s into a FIFO queue, and mark s as visited
 * repeat until the queue is empty:
 *  - remove the least recently added vertex v
 *  - for each unmarked vertex pointing from v:
 *    add to queue and mark as visited
 */

#include <queue>
#include <stack>
#include <unordered_set>

#include "graph/digraph.h"

namespace algorithms {
class DirectedBreadthFirstSearch {
public:
  DirectedBreadthFirstSearch() = delete;
  DirectedBreadthFirstSearch(Digraph& g, std::unordered_set<int> sources) 
    : m_marked(g.vertices(), false), 
      m_edge_to(g.vertices(), -1),
      m_sources(sources) {
    for (int s : sources) {
      bfs(g, s);
    }
  };
  bool hasPathTo(int v) { return m_marked[v]; };
  std::stack<int> pathTo(int v) {
    std::stack<int> stack;
    for (int x = v; !m_sources.contains(x); x = m_edge_to[x]) {
      stack.push(x);
    }
    stack.push(m_edge_to[stack.top()]);
    return stack;
  }
private:
  std::vector<bool> m_marked;
  std::vector<int> m_edge_to;
  std::queue<int> m_queue;
  std::unordered_set<int> m_sources;
  void bfs(Digraph& g, int s) {
    m_marked[s] = true;
    m_queue.push(s);
    while (!m_queue.empty()) {
      int v = m_queue.front();
      m_queue.pop();
      for (int w : g.adj(v)) {
        if (!m_marked[w]) {
          m_edge_to[w] = v;
          m_queue.push(w);
          m_marked[w] = true;
        }
      }
    }
  }
};
} // namespace algorithms

#endif
