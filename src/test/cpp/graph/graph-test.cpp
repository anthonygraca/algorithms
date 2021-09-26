#include "graph/graph.h"

#include "gtest/gtest.h"

TEST(Graph, OnlyOneVertex) {
  algorithms::Graph g{1};
  ASSERT_EQ(1, g.vertices());
}
