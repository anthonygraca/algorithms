#include <graph/directed/shortest-path/directed-edge.h>

#include <gtest/gtest.h>

TEST(DirectedWeightedEdge, ConstructEdge) {
  algorithms::DirectedEdge edge(0, 1, 0.5);
  EXPECT_EQ(0, edge.from());
  EXPECT_EQ(1, edge.to());
  EXPECT_NEAR(0.5, edge.weight(), 0.01);
}

TEST(DirectedWeightedEdge, TwoEdges) {
  algorithms::DirectedEdge edge1(0, 1, 0.5);
  algorithms::DirectedEdge edge2(0, 2, 0.6);
  EXPECT_EQ(0, edge1.from());
  EXPECT_EQ(1, edge1.to());
  EXPECT_NEAR(0.5, edge1.weight(), 0.01);
  EXPECT_EQ(0, edge2.from());
  EXPECT_EQ(2, edge2.to());
  EXPECT_NEAR(0.6, edge2.weight(), 0.01);
}

TEST(DirectedWeightedEdge, GreaterThan) {
  algorithms::DirectedEdge edge1(0, 1, 0.5);
  algorithms::DirectedEdge edge2(0, 2, 0.4);
  EXPECT_GT(edge1, edge2);
}

TEST(DirectedWeightedEdge, LessThan) {
  algorithms::DirectedEdge edge1(0, 1, 0.5);
  algorithms::DirectedEdge edge2(0, 2, 0.4);
  EXPECT_FALSE(edge2 > edge1);
}
