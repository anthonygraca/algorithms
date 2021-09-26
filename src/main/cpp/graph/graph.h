#ifndef ALGORITHMS_PRINCETON_GRAPHS_H_
#define ALGORITHMS_PRINCETON_GRAPHS_H_

namespace algorithms {
class Graph {
  public:
    Graph(int v) : m_vertices(v) {};
    int vertices() {return m_vertices;};
  private:
    int m_vertices = -1;
};
} // namespace algorithms

#endif
