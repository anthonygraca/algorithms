#ifndef ALGORITHMS_PRINCETON_UNDIRECTED_GRAPHS_DEPTH_FIRST_SEARCH_PATH_FINDING_H_
#define ALGORITHMS_PRINCETON_UNDIRECTED_GRAPHS_DEPTH_FIRST_SEARCH_PATH_FINDING_H_

#include "graph/graph.h"

namespace algorithms {
class DepthFirstPaths {
  public:
    DepthFirstPaths() = delete;
    DepthFirstPaths(Graph& g, int source_vertex) {};
    bool hasPathTo(int v) {return true;};

}; 
} // namespace algorithms

#endif
