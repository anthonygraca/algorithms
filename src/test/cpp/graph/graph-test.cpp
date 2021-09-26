#include "graph/graph.h"

#include "gtest/gtest.h"

TEST(Graph, NoVertices) {
  algorithms::Graph g{0};
  ASSERT_EQ(0, g.vertices());
}

TEST(Graph, NoVerticesNoEdges) {
  algorithms::Graph g{0};
  ASSERT_EQ(0, g.vertices());
}

TEST(Graph, OnlyOneVertex) {
  algorithms::Graph g{1};
  ASSERT_EQ(1, g.vertices());
}

TEST(Graph, OnlyOneVertexNoEdges) {
  algorithms::Graph g{1};
  ASSERT_EQ(0, g.edges());
}

TEST(Graph, AddEdge) {
  algorithms::Graph g{2};
  g.addEdge(0,1);
  ASSERT_EQ(2, g.vertices());
  ASSERT_EQ(1, g.edges());
}
