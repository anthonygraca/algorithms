#include <graph/directed/shortest-path/dijkstra.h>

#include <gtest/gtest.h>

#include <graph/directed/shortest-path/edge-weighted-digraph.h>
#include <graph/directed/shortest-path/directed-edge.h>

TEST(DijkstraShortestPath, NegativeWeights) {
  algorithms::EdgeWeightedDigraph g(4);
  g.addEdge(algorithms::DirectedEdge(0, 1, 4));
  g.addEdge(algorithms::DirectedEdge(1, 2, 6));
  g.addEdge(algorithms::DirectedEdge(2, 3, -9));
  g.addEdge(algorithms::DirectedEdge(0, 3, 2));
  algorithms::Dijkstra sp(g, 0);
  auto weight = sp.getWeight();
  auto edges = sp.getEdges();
  EXPECT_EQ(0, edges[1].from());
  EXPECT_EQ(1, edges[1].to());
  EXPECT_NEAR(4, weight[1], 0.01);
  EXPECT_EQ(1, edges[2].from());
  EXPECT_EQ(2, edges[2].to());
  EXPECT_NEAR(10, weight[2], 0.01);
  EXPECT_EQ(2, edges[3].from());
  EXPECT_EQ(3, edges[3].to());
  EXPECT_NEAR(1, weight[3], 0.01);
}

TEST(DijkstraShortestPath, TinyEWD) {
  algorithms::EdgeWeightedDigraph g(8);
  g.addEdge(algorithms::DirectedEdge(4, 5, 0.35));
  g.addEdge(algorithms::DirectedEdge(5, 4, 0.35));
  g.addEdge(algorithms::DirectedEdge(4, 7, 0.37));
  g.addEdge(algorithms::DirectedEdge(5, 7, 0.28));
  g.addEdge(algorithms::DirectedEdge(7, 5, 0.28));
  g.addEdge(algorithms::DirectedEdge(5, 1, 0.32));
  g.addEdge(algorithms::DirectedEdge(0, 4, 0.38));
  g.addEdge(algorithms::DirectedEdge(0, 2, 0.26));
  g.addEdge(algorithms::DirectedEdge(7, 3, 0.39));
  g.addEdge(algorithms::DirectedEdge(1, 3, 0.29));
  g.addEdge(algorithms::DirectedEdge(2, 7, 0.34));
  g.addEdge(algorithms::DirectedEdge(6, 2, 0.40));
  g.addEdge(algorithms::DirectedEdge(3, 6, 0.52));
  g.addEdge(algorithms::DirectedEdge(6, 0, 0.58));
  g.addEdge(algorithms::DirectedEdge(6, 4, 0.93));
  algorithms::Dijkstra sp(g, 0);
  auto weight = sp.getWeight();
  auto edges = sp.getEdges();
  EXPECT_EQ(0, edges[0].from());
  EXPECT_EQ(-1, edges[0].to());
  EXPECT_NEAR(0.0, edges[0].weight(), 0.01);
  EXPECT_NEAR(0.0, weight[0], 0.01);
  EXPECT_EQ(5, edges[1].from());
  EXPECT_EQ(1, edges[1].to());
  EXPECT_NEAR(0.32, edges[1].weight(), 0.01);
  EXPECT_NEAR(1.05, weight[1], 0.01);
  EXPECT_EQ(0, edges[2].from());
  EXPECT_EQ(2, edges[2].to());
  EXPECT_NEAR(0.26, edges[2].weight(), 0.01);
  EXPECT_NEAR(0.26, weight[2], 0.01);
  EXPECT_EQ(7, edges[3].from());
  EXPECT_EQ(3, edges[3].to());
  EXPECT_NEAR(0.39, edges[3].weight(), 0.01);
  EXPECT_NEAR(0.99, weight[3], 0.01);
  EXPECT_EQ(0, edges[4].from());
  EXPECT_EQ(4, edges[4].to());
  EXPECT_NEAR(0.38, edges[4].weight(), 0.01);
  EXPECT_NEAR(0.38, weight[4], 0.01);
  EXPECT_EQ(4, edges[5].from());
  EXPECT_EQ(5, edges[5].to());
  EXPECT_NEAR(0.35, edges[5].weight(), 0.01);
  EXPECT_NEAR(0.73, weight[5], 0.01);
  EXPECT_EQ(3, edges[6].from());
  EXPECT_EQ(6, edges[6].to());
  EXPECT_NEAR(0.52, edges[6].weight(), 0.01);
  EXPECT_NEAR(1.51, weight[6], 0.01);
  EXPECT_EQ(2, edges[7].from());
  EXPECT_EQ(7, edges[7].to());
  EXPECT_NEAR(0.34, edges[7].weight(), 0.01);
  EXPECT_NEAR(0.60, weight[7], 0.01);
}
