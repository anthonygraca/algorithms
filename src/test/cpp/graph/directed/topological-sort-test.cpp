#include "graph/directed/topological-sort.h"

#include "gtest/gtest.h"

#include "graph/digraph.h"

TEST(TopologicalSort, CourseraExample) {
  algorithms::Digraph g{7};
  g.addEdge(0,5);
  g.addEdge(0,2);
  g.addEdge(0,1);
  g.addEdge(3,6);
  g.addEdge(3,5);
  g.addEdge(3,4);
  g.addEdge(5,2);
  g.addEdge(6,4);
  g.addEdge(6,0);
  g.addEdge(3,2);
  g.addEdge(1,4);
  algorithms::TopologicalSort algo{g};

}
