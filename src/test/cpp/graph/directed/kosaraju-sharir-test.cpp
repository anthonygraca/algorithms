#include "graph/directed/kosaraju-sharir.h"

#include "gtest/gtest.h"

#include "graph/digraph.h"

TEST(StronglyConnectedComponents, BookExample) {
  algorithms::Digraph g{13};
  g.addEdge(0, 1);
  g.addEdge(2, 0);
  g.addEdge(2, 3);
  g.addEdge(3, 2);
  g.addEdge(3, 5);
  g.addEdge(4, 3);
  g.addEdge(4, 2);
  g.addEdge(5, 4);
  g.addEdge(6, 0);
  g.addEdge(6, 0);
  g.addEdge(6, 4);
  g.addEdge(6, 8);
  g.addEdge(6, 9);
  g.addEdge(7, 6);
  g.addEdge(7, 9);
  g.addEdge(8, 6);
  g.addEdge(9, 10);
  g.addEdge(9, 11);
  g.addEdge(10, 12);
  g.addEdge(11, 4);
  g.addEdge(11, 12);
  g.addEdge(12, 9);
  algorithms::StronglyConnectedComponents algo{g};
  ASSERT_EQ(5, algo.count());
}
