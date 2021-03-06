#include <graph/undirected/minimum-spanning-tree/edge.h>
#include <graph/undirected/minimum-spanning-tree/edge-weighted-graph.h>

#include <stdexcept>

#include <gtest/gtest.h>

TEST(EdgeWeightedGraph, GetWeight) {
  int vertex_a{1};
  int vertex_b{2};
  double weight{.50};
  algorithms::Edge e(vertex_a, vertex_b, weight);
  EXPECT_NEAR(weight, e.getWeight(), 0.01);
}

TEST(EdgeWeightedGraph, GetVertexA) {
  int vertex_a{1};
  int vertex_b{2};
  double weight{.50};
  algorithms::Edge e(vertex_a, vertex_b, weight);
  EXPECT_EQ(vertex_a, e.either());
}

TEST(EdgeWeightedGraph, GetOtherVertexB) {
  int vertex_a{1};
  int vertex_b{2};
  double weight{.50};
  algorithms::Edge e(vertex_a, vertex_b, weight);
  EXPECT_EQ(vertex_b, e.other(vertex_a));
}

TEST(EdgeWeightedGraph, GetOtherVertexA) {
  int vertex_a{1};
  int vertex_b{2};
  double weight{.50};
  algorithms::Edge e(vertex_a, vertex_b, weight);
  EXPECT_EQ(vertex_a, e.other(vertex_b));
}

TEST(EdgeWeightedGraph, GetOtherInvalidVertex) {
  int vertex_a{1};
  int vertex_b{2};
  double weight{.50};
  algorithms::Edge e(vertex_a, vertex_b, weight);
  EXPECT_THROW(e.other(100), std::invalid_argument);
}

TEST(EdgeWeightedGraph, GreaterThan) {
  int vertex_a{1};
  int vertex_b{2};
  double weight1{.50};
  algorithms::Edge e1(vertex_a, vertex_b, weight1);
  int vertex_c{3};
  int vertex_d{4};
  double weight2{.20};
  algorithms::Edge e2(vertex_c, vertex_d, weight2);
  EXPECT_GT(e1, e2);
}

TEST(EdgeWeightedGraph, LessThan) {
  int vertex_a{1};
  int vertex_b{2};
  double weight1{.50};
  algorithms::Edge e1(vertex_a, vertex_b, weight1);
  int vertex_c{3};
  int vertex_d{4};
  double weight2{.20};
  algorithms::Edge e2(vertex_c, vertex_d, weight2);
  EXPECT_LT(e2, e1);
}

TEST(EdgeWeightedGraph, Equal) {
  int vertex_a{1};
  int vertex_b{2};
  double weight1{.50};
  algorithms::Edge e1(vertex_a, vertex_b, weight1);
  int vertex_c{3};
  int vertex_d{4};
  double weight2{.50};
  algorithms::Edge e2(vertex_c, vertex_d, weight2);
  EXPECT_EQ(e2, e1);
}

TEST(EdgeWeightedGraph, GreaterThanOrEqual) {
  int vertex_a{1};
  int vertex_b{2};
  double weight1{.50};
  algorithms::Edge e1(vertex_a, vertex_b, weight1);
  int vertex_c{3};
  int vertex_d{4};
  double weight2{.50};
  algorithms::Edge e2(vertex_c, vertex_d, weight2);
  EXPECT_GE(e2, e1);
}

TEST(EdgeWeightedGraph, LessThanOrEqual) {
  int vertex_a{1};
  int vertex_b{2};
  double weight1{.50};
  algorithms::Edge e1(vertex_a, vertex_b, weight1);
  int vertex_c{3};
  int vertex_d{4};
  double weight2{.50};
  algorithms::Edge e2(vertex_c, vertex_d, weight2);
  EXPECT_LE(e2, e1);
}

TEST(EdgeWeightedGraph, InitializeEdgeWeightedGraph) {
  int vertices{2};
  algorithms::EdgeWeightedGraph g(vertices);
  EXPECT_EQ(vertices, g.getVertices());
}

TEST(EdgeWeightedGraph, DefaultEdgesIsZero) {
  int vertices{2};
  algorithms::EdgeWeightedGraph g(vertices);
  EXPECT_EQ(0, g.getNumberOfEdges());
}

TEST(EdgeWeightedGraph, IncrementEdges) {
  int vertex_a{0};
  int vertex_b{1};
  double weight1{.50};
  algorithms::Edge e1(vertex_a, vertex_b, weight1);
  int vertices{2};
  algorithms::EdgeWeightedGraph g(vertices);
  g.addEdge(e1);
  EXPECT_EQ(1, g.getNumberOfEdges());
}

TEST(EdgeWeightedGraph, GetEdgeAdjacentToVertex) {
  int vertex_a{0};
  int vertex_b{1};
  double weight1{.50};
  algorithms::Edge e1(vertex_a, vertex_b, weight1);
  int vertex_c{1};
  int vertex_d{0};
  double weight2{.80};
  algorithms::Edge e2(vertex_c, vertex_d, weight2);
  int vertices{2};
  algorithms::EdgeWeightedGraph g(vertices);
  g.addEdge(e1);
  g.addEdge(e2);
  auto adjacent_0 = g.adj(0);
  auto adjacent_1 = g.adj(1);
  EXPECT_TRUE(std::find(std::begin(adjacent_0), std::end(adjacent_0), e1)
              != std::end(adjacent_0));
  EXPECT_TRUE(std::find(std::begin(adjacent_0), std::end(adjacent_0), e2)
              != std::end(adjacent_0));
  EXPECT_TRUE(std::find(std::begin(adjacent_1), std::end(adjacent_1), e1)
              != std::end(adjacent_1));
  EXPECT_TRUE(std::find(std::begin(adjacent_1), std::end(adjacent_1), e2)
              != std::end(adjacent_1));
}

TEST(EdgeWeightedGraph, TestScoping) {
  int vertices{2};
  algorithms::EdgeWeightedGraph g(vertices);
  {
    int vertex_a{0};
    int vertex_b{1};
    double weight1{.50};
    algorithms::Edge e1(vertex_a, vertex_b, weight1);
    int vertex_c{1};
    int vertex_d{0};
    double weight2{.80};
    algorithms::Edge e2(vertex_c, vertex_d, weight2);
    g.addEdge(e1);
    g.addEdge(e2);
  }
  auto adjacent_0 = g.adj(0);
  for (auto e : adjacent_0) {
    EXPECT_GE(1, e.either());
  }
}
