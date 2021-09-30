#include "graph/directed/kosaraju-sharir.h"

#include "gtest/gtest.h"

#include "graph/digraph.h"

TEST(StronglyConnectedComponents, BookExample) {
  algorithms::Digraph g{13};
  g.addEdge(0, 1);
  g.addEdge(0, 5);
  g.addEdge(2, 0);
  g.addEdge(2, 3);
  g.addEdge(3, 2);
  g.addEdge(3, 5);
  g.addEdge(4, 3);
  g.addEdge(4, 2);
  g.addEdge(5, 4);
  g.addEdge(6, 0);
  g.addEdge(6, 4);
  g.addEdge(6, 8);
  g.addEdge(6, 9);
  g.addEdge(7, 6);
  g.addEdge(7, 9);
  g.addEdge(8, 6);
  g.addEdge(9, 10);
  g.addEdge(9, 11);
  g.addEdge(10, 12);
  g.addEdge(11, 4);
  g.addEdge(11, 12);
  g.addEdge(12, 9);
  algorithms::StronglyConnectedComponents algo{g};
  ASSERT_EQ(5, algo.count());
  ASSERT_TRUE(algo.stronglyConnected(0,2));
  ASSERT_FALSE(algo.stronglyConnected(0,1));
  ASSERT_TRUE(algo.stronglyConnected(2,3));
  ASSERT_TRUE(algo.stronglyConnected(3,4));
  ASSERT_TRUE(algo.stronglyConnected(4,5));
  ASSERT_FALSE(algo.stronglyConnected(6,5));
  ASSERT_TRUE(algo.stronglyConnected(6,8));
  ASSERT_FALSE(algo.stronglyConnected(7,8));
  ASSERT_TRUE(algo.stronglyConnected(9,10));
  ASSERT_TRUE(algo.stronglyConnected(10,11));
  ASSERT_TRUE(algo.stronglyConnected(11,12));
}

TEST(StronglyConnectedComponents, DifferentExample) {
  algorithms::Digraph g{13};
  g.addEdge(0, 1);
  g.addEdge(2, 0);
  g.addEdge(2, 3);
  g.addEdge(3, 2);
  g.addEdge(3, 5);
  g.addEdge(4, 3);
  g.addEdge(4, 2);
  g.addEdge(5, 4);
  g.addEdge(6, 0);
  g.addEdge(6, 4);
  g.addEdge(6, 8);
  g.addEdge(6, 9);
  g.addEdge(7, 6);
  g.addEdge(7, 9);
  g.addEdge(8, 6);
  g.addEdge(9, 10);
  g.addEdge(9, 11);
  g.addEdge(10, 12);
  g.addEdge(11, 4);
  g.addEdge(11, 12);
  g.addEdge(12, 9);
  algorithms::StronglyConnectedComponents algo{g};
  ASSERT_EQ(6, algo.count());
  ASSERT_FALSE(algo.stronglyConnected(0,2));
  ASSERT_FALSE(algo.stronglyConnected(0,1));
}
