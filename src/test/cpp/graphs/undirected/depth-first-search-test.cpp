#include "graphs/undirected/depth-first-search.h"

#include "gtest/gtest.h"

TEST(DepthFirstSearch, NullExample) {
  algorithms::DepthFirstSearch algo;
  ASSERT_EQ("", algo.dfs(nullptr));
}
