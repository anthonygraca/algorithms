#include <graph/undirected/minimum-spanning-tree/kruskal-mst.h>

#include <gtest/gtest.h>

TEST(KruskalMst, TinyEWG) {
  algorithms::EdgeWeightedGraph g(8);
  g.addEdge(algorithms::Edge(4, 5, 0.35));
  g.addEdge(algorithms::Edge(4, 7, 0.37));
  g.addEdge(algorithms::Edge(5, 7, 0.28));
  g.addEdge(algorithms::Edge(0, 7, 0.16));
  g.addEdge(algorithms::Edge(1, 5, 0.32));
  g.addEdge(algorithms::Edge(0, 4, 0.38));
  g.addEdge(algorithms::Edge(2, 3, 0.17));
  g.addEdge(algorithms::Edge(1, 7, 0.19));
  g.addEdge(algorithms::Edge(0, 2, 0.26));
  g.addEdge(algorithms::Edge(1, 2, 0.36));
  g.addEdge(algorithms::Edge(1, 3, 0.29));
  g.addEdge(algorithms::Edge(2, 7, 0.34));
  g.addEdge(algorithms::Edge(6, 2, 0.40));
  g.addEdge(algorithms::Edge(3, 6, 0.52));
  g.addEdge(algorithms::Edge(6, 0, 0.58));
  g.addEdge(algorithms::Edge(6, 4, 0.93));
  algorithms::KruskalMst mst(g);
  double weight = mst.getWeight();
  auto edges = mst.getEdges();
  EXPECT_NEAR(1.81, weight, 0.01);
  EXPECT_EQ(0, edges[0].either());
  EXPECT_EQ(7, edges[0].other(0));
  EXPECT_NEAR(0.16, edges[0].getWeight(), 0.01);
  EXPECT_EQ(2, edges[1].either());
  EXPECT_EQ(3, edges[1].other(2));
  EXPECT_NEAR(0.17, edges[1].getWeight(), 0.01);
  EXPECT_EQ(1, edges[2].either());
  EXPECT_EQ(7, edges[2].other(1));
  EXPECT_NEAR(0.19, edges[2].getWeight(), 0.01);
  EXPECT_EQ(0, edges[3].either());
  EXPECT_EQ(2, edges[3].other(0));
  EXPECT_NEAR(0.26, edges[3].getWeight(), 0.01);
  EXPECT_EQ(5, edges[4].either());
  EXPECT_EQ(7, edges[4].other(5));
  EXPECT_NEAR(0.28, edges[4].getWeight(), 0.01);
  EXPECT_EQ(4, edges[5].either());
  EXPECT_EQ(5, edges[5].other(4));
  EXPECT_NEAR(0.35, edges[5].getWeight(), 0.01);
  EXPECT_EQ(6, edges[6].either());
  EXPECT_EQ(2, edges[6].other(6));
  EXPECT_NEAR(0.40, edges[6].getWeight(), 0.01);
}
