#include "graph/undirected/depth-first-search.h"

#include "gtest/gtest.h"

TEST(DepthFirstSearch, OnlyOneVertex) {
  algorithms::Graph g{1};
  algorithms::DepthFirstSearch algo;
  ASSERT_EQ("1", algo.dfs(g));
}

TEST(DepthFirstSearch, DISABLED_BasicExampleWithTwoVertices) {
  /*
  algorithms::Graph g1{1};
  algorithms::Graph g2{2, g1};
  g1.connect(g2);
  algorithms::DepthFirstSearch algo;
  ASSERT_EQ("1 2", algo.dfs(g1));
  */
}
