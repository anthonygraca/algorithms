#include "graph/undirected/depth-first-paths.h"

#include "gtest/gtest.h"

#include "graph/graph.h"

TEST(DepthFirstPaths, VerifyHasPathTo) {
  algorithms::Graph g{7};
  g.addEdge(0, 5);
  g.addEdge(2, 4);
  g.addEdge(2, 3);
  g.addEdge(1, 2);
  g.addEdge(0, 1);
  g.addEdge(3, 4);
  g.addEdge(3, 5);
  g.addEdge(0, 2);
  algorithms::DepthFirstPaths algo{g, 0};
  ASSERT_TRUE(algo.hasPathTo(0));
  ASSERT_TRUE(algo.hasPathTo(1));
  ASSERT_TRUE(algo.hasPathTo(2));
  ASSERT_TRUE(algo.hasPathTo(3));
  ASSERT_TRUE(algo.hasPathTo(4));
  ASSERT_TRUE(algo.hasPathTo(5));
  ASSERT_TRUE(algo.hasPathTo(6));
}
