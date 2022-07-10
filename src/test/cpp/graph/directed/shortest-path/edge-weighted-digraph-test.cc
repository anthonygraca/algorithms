#include <graph/directed/shortest-path/edge-weighted-digraph.h>

#include <gtest/gtest.h>

#include <graph/directed/shortest-path/directed-edge.h>

TEST(EdgeWeightedDigraph, DefaultEdgesIsZero) {
  algorithms::EdgeWeightedDigraph g(2);
  EXPECT_EQ(0, g.getNumberOfEdges());
}

TEST(EdgeWeightedDiraph, IncrementEdges) {
  int vertex_a{0};
  int vertex_b{1};
  double weight1{.50};
  algorithms::DirectedEdge e1(vertex_a, vertex_b, weight1);
  int vertices{2};
  algorithms::EdgeWeightedDigraph g(vertices);
  g.addEdge(e1);
  EXPECT_EQ(1, g.getNumberOfEdges());
}

TEST(EdgeWeightedDigraph, GetEdgeAdjacentToVertex) {
  int vertex_a{0};
  int vertex_b{1};
  double weight1{.50};
  algorithms::DirectedEdge e1(vertex_a, vertex_b, weight1);
  int vertex_c{1};
  int vertex_d{0};
  double weight2{.80};
  algorithms::DirectedEdge e2(vertex_c, vertex_d, weight2);
  int vertices{2};
  algorithms::EdgeWeightedDigraph g(vertices);
  g.addEdge(e1);
  g.addEdge(e2);
  auto adjacent_0 = g.adj(0);
  auto adjacent_1 = g.adj(1);
  EXPECT_TRUE(std::find(std::begin(adjacent_0), std::end(adjacent_0), e1)
              != std::end(adjacent_0));
  EXPECT_FALSE(std::find(std::begin(adjacent_0), std::end(adjacent_0), e2)
              != std::end(adjacent_0));
  EXPECT_FALSE(std::find(std::begin(adjacent_1), std::end(adjacent_1), e1)
              != std::end(adjacent_1));
  EXPECT_TRUE(std::find(std::begin(adjacent_1), std::end(adjacent_1), e2)
              != std::end(adjacent_1));
}
