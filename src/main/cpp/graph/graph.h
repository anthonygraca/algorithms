#ifndef ALGORITHMS_PRINCETON_GRAPHS_H_
#define ALGORITHMS_PRINCETON_GRAPHS_H_

#include <vector>

namespace algorithms {
class Graph {
  public:
    Graph() = delete;
    Graph(int v) : m_vertices(v) {
      for(int i = 0; i < v; i++) {
        std::vector<int> stack;
        m_adjacency_list.push_back(stack);
      }
    };
    int vertices() {return m_vertices;};
    int edges() {return m_edges;};
    void addEdge(int v, int w) {
      m_adjacency_list[v].push_back(w);
      m_adjacency_list[w].push_back(v);
      m_edges++;
    }
    std::vector<int> adj(int v) {
      return m_adjacency_list[v];
    }
  private:
    int m_vertices = 0;
    int m_edges = 0;
    std::vector<std::vector<int>> m_adjacency_list;
};
} // namespace algorithms

#endif
