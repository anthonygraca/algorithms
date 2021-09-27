#include "graph/undirected/depth-first-search.h"

#include "gtest/gtest.h"

TEST(DepthFirstSearch, VerifyNodesAreMarked) {
  algorithms::Graph g{7};
  g.addEdge(0, 5);
  g.addEdge(2, 4);
  g.addEdge(2, 3);
  g.addEdge(1, 2);
  g.addEdge(0, 1);
  g.addEdge(3, 4);
  g.addEdge(3, 5);
  g.addEdge(0, 2);
  algorithms::DepthFirstSearch algo(g, 0);
  ASSERT_TRUE(algo.marked(0));
  ASSERT_TRUE(algo.marked(1));
  ASSERT_TRUE(algo.marked(2));
  ASSERT_TRUE(algo.marked(3));
  ASSERT_TRUE(algo.marked(4));
  ASSERT_TRUE(algo.marked(5));
  ASSERT_FALSE(algo.marked(6));
}
