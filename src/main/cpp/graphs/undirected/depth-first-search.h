#ifndef ALGORITHMS_PRINCETON_UNDIRECTED_GRAPHS_DEPTH_FIRST_SEARCH_H_
#define ALGORITHMS_PRINCETON_UNDIRECTED_GRAPHS_DEPTH_FIRST_SEARCH_H_

#include <string>

namespace algorithms {
class Graph {
  public:
    Graph(uint8_t i) : m_element{i} {};
  private:
    uint8_t m_element = 0xFF;
    //std::stack<Graph> 
}; 
class DepthFirstSearch {
  public:
    std::string dfs(Graph& g) {
      return "1";
    }
};
} // namespace algorithms
#endif
