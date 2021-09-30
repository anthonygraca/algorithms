#ifndef ALGORITHMS_PRINCETON_DIRECTED_GRAPH_KOSARAJU_SHARIR_STRONGLY_CONNECTED_COMPONENTS_H_
#define ALGORITHMS_PRINCETON_DIRECTED_GRAPH_KOSARAJU_SHARIR_STRONGLY_CONNECTED_COMPONENTS_H_
/*
 * Intuition:
 * 1.) If we reverse all the edges, we would get the same strong components.
 * 2.) Kernel DAG == contract each strong component into a single vertex.
 *
 * Idea:
 * 1.) Compute topological order (reverse postorder) in kernel DAG.
 * 2.) Run DFCS, considering vertices in reverse topological order
 *
 * DFS in reverse graph
 */

#include <vector>

#include "graph/digraph.h"

namespace algorithms {
class StronglyConnectedComponents {
public:
  StronglyConnectedComponents() = delete;
  StronglyConnectedComponents(Digraph& g) 
    : m_marked(g.vertices(), false) {};
  int count() {
    return 5;
  }
private:
  std::vector<int> m_marked;

};
} // namespace algorithms

#endif
