#ifndef ALGORITHMS_PRINCETON_DIGRAPH_H_
#define ALGORITHMS_PRINCETON_DIGRAPH_H_

#include <unordered_set>
#include <vector>

namespace algorithms {
class Digraph {
public:
  Digraph() = delete;
  Digraph(int v) : m_vertices(v) {
    for(int i = 0; i < v; i++) {
      std::unordered_set<int> stack;
      m_adjacency_list.push_back(stack);
    }
  }
  int vertices() { return m_vertices; };
  int edges() { return m_edges; };
  void addEdge(int v, int w) {
    m_adjacency_list[v].insert(w);
    m_edges++;
  }
  std::unordered_set<int> adj(int v) {
    return m_adjacency_list[v];
  }
private:
  int m_vertices = 0;
  int m_edges = 0;
  std::vector<std::unordered_set<int>> m_adjacency_list;
};
} // namespace algorithms
#endif
