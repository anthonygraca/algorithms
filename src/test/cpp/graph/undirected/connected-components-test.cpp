#include "graph/undirected/connected-components.h"

#include "gtest/gtest.h"

#include "graph/graph.h"

TEST(ConnectedComponents, FirstExample) {
  algorithms::Graph g{6};
  g.addEdge(0, 5);
  g.addEdge(2, 4);
  g.addEdge(2, 3);
  g.addEdge(1, 2);
  g.addEdge(0, 1);
  g.addEdge(3, 4);
  g.addEdge(3, 5);
  g.addEdge(0, 2);
  algorithms::ConnectedComponents cc{g};
  ASSERT_EQ(1, cc.count());
}

TEST(ConnectedComponents, FirstExampleId) {
  algorithms::Graph g{6};
  g.addEdge(0, 5);
  g.addEdge(2, 4);
  g.addEdge(2, 3);
  g.addEdge(1, 2);
  g.addEdge(0, 1);
  g.addEdge(3, 4);
  g.addEdge(3, 5);
  g.addEdge(0, 2);
  algorithms::ConnectedComponents cc{g};
  ASSERT_EQ(0, cc.id(0));
  ASSERT_EQ(0, cc.id(1));
  ASSERT_EQ(0, cc.id(2));
  ASSERT_EQ(0, cc.id(3));
  ASSERT_EQ(0, cc.id(4));
  ASSERT_EQ(0, cc.id(5));
}

TEST(ConnectedComponents, FirstExampleSameComponent) {
  algorithms::Graph g{6};
  g.addEdge(0, 5);
  g.addEdge(2, 4);
  g.addEdge(2, 3);
  g.addEdge(1, 2);
  g.addEdge(0, 1);
  g.addEdge(3, 4);
  g.addEdge(3, 5);
  g.addEdge(0, 2);
  algorithms::ConnectedComponents cc{g};
  ASSERT_TRUE(cc.connected(0,1));
  ASSERT_TRUE(cc.connected(1,2));
  ASSERT_TRUE(cc.connected(2,3));
  ASSERT_TRUE(cc.connected(3,4));
  ASSERT_TRUE(cc.connected(4,5));
  ASSERT_TRUE(cc.connected(5,0));
}

TEST(ConnectedComponents, TwoComponents) {
  algorithms::Graph g{7};
  g.addEdge(0, 5);
  g.addEdge(2, 4);
  g.addEdge(2, 3);
  g.addEdge(1, 2);
  g.addEdge(0, 1);
  g.addEdge(3, 4);
  g.addEdge(3, 5);
  g.addEdge(0, 2);
  algorithms::ConnectedComponents cc{g};
  ASSERT_EQ(2, cc.count());
}

TEST(ConnectedComponents, TwoComponentsId) {
  algorithms::Graph g{7};
  g.addEdge(0, 5);
  g.addEdge(2, 4);
  g.addEdge(2, 3);
  g.addEdge(1, 2);
  g.addEdge(0, 1);
  g.addEdge(3, 4);
  g.addEdge(3, 5);
  g.addEdge(0, 2);
  algorithms::ConnectedComponents cc{g};
  ASSERT_EQ(1, cc.id(6));
}

TEST(ConnectedComponents, TwoComponentsDifferent) {
  algorithms::Graph g{7};
  g.addEdge(0, 5);
  g.addEdge(2, 4);
  g.addEdge(2, 3);
  g.addEdge(1, 2);
  g.addEdge(0, 1);
  g.addEdge(3, 4);
  g.addEdge(3, 5);
  g.addEdge(0, 2);
  algorithms::ConnectedComponents cc{g};
  ASSERT_FALSE(cc.connected(0, 6));
}

TEST(ConnectedComponents, ThreeComponents) {
  algorithms::Graph g{8};
  g.addEdge(0, 5);
  g.addEdge(2, 4);
  g.addEdge(2, 3);
  g.addEdge(1, 2);
  g.addEdge(0, 1);
  g.addEdge(3, 4);
  g.addEdge(3, 5);
  g.addEdge(0, 2);
  algorithms::ConnectedComponents cc{g};
  ASSERT_EQ(3, cc.count());
}

TEST(ConnectedComponents, ThreeComponentsId) {
  algorithms::Graph g{8};
  g.addEdge(0, 5);
  g.addEdge(2, 4);
  g.addEdge(2, 3);
  g.addEdge(1, 2);
  g.addEdge(0, 1);
  g.addEdge(3, 4);
  g.addEdge(3, 5);
  g.addEdge(0, 2);
  algorithms::ConnectedComponents cc{g};
  ASSERT_EQ(2, cc.id(7));
}

TEST(ConnectedComponents, ThreeComponentsDifferent) {
  algorithms::Graph g{8};
  g.addEdge(0, 5);
  g.addEdge(2, 4);
  g.addEdge(2, 3);
  g.addEdge(1, 2);
  g.addEdge(0, 1);
  g.addEdge(3, 4);
  g.addEdge(3, 5);
  g.addEdge(0, 2);
  algorithms::ConnectedComponents cc{g};
  ASSERT_FALSE(cc.connected(6, 7));
  ASSERT_FALSE(cc.connected(5, 6));
  ASSERT_FALSE(cc.connected(5, 7));
}
