#include "graph/directed/depth-first-search.h"

#include <unordered_set>

#include "gtest/gtest.h"

#include "graph/digraph.h"

TEST(DirectedDFS, TinyDigraphBookExample) {
  algorithms::Digraph g{13};
  g.addEdge(4,2);
  g.addEdge(2,3);
  g.addEdge(3,2);
  g.addEdge(6,0);
  g.addEdge(0,1);
  g.addEdge(2,0);
  g.addEdge(11,12);
  g.addEdge(12,9);
  g.addEdge(9,10);
  g.addEdge(9,11);
  g.addEdge(7,9);
  g.addEdge(10,12);
  g.addEdge(11,4);
  g.addEdge(4,3);
  g.addEdge(3,5);
  g.addEdge(6,8);
  g.addEdge(8,6);
  g.addEdge(5,4);
  g.addEdge(0,5);
  g.addEdge(6,4);
  g.addEdge(6,9);
  g.addEdge(7,6);
  std::unordered_set<int> sources;
  sources.insert(1);
  algorithms::DirectedDepthFirstSearch algo(g, sources);
  ASSERT_FALSE(algo.marked(0));
  ASSERT_TRUE(algo.marked(1));
  ASSERT_FALSE(algo.marked(2));
  ASSERT_FALSE(algo.marked(3));
  ASSERT_FALSE(algo.marked(4));
  ASSERT_FALSE(algo.marked(5));
  ASSERT_FALSE(algo.marked(6));
  ASSERT_FALSE(algo.marked(7));
  ASSERT_FALSE(algo.marked(8));
  ASSERT_FALSE(algo.marked(9));
  ASSERT_FALSE(algo.marked(10));
  ASSERT_FALSE(algo.marked(11));
  ASSERT_FALSE(algo.marked(12));
}

TEST(DirectedDFS, DifferenceSource) {
  algorithms::Digraph g{13};
  g.addEdge(4,2);
  g.addEdge(2,3);
  g.addEdge(3,2);
  g.addEdge(6,0);
  g.addEdge(0,1);
  g.addEdge(2,0);
  g.addEdge(11,12);
  g.addEdge(12,9);
  g.addEdge(9,10);
  g.addEdge(9,11);
  g.addEdge(7,9);
  g.addEdge(10,12);
  g.addEdge(11,4);
  g.addEdge(4,3);
  g.addEdge(3,5);
  g.addEdge(6,8);
  g.addEdge(8,6);
  g.addEdge(5,4);
  g.addEdge(0,5);
  g.addEdge(6,4);
  g.addEdge(6,9);
  g.addEdge(7,6);
  std::unordered_set<int> sources;
  sources.insert(2);
  algorithms::DirectedDepthFirstSearch algo(g, sources);
  ASSERT_TRUE(algo.marked(0));
  ASSERT_TRUE(algo.marked(1));
  ASSERT_TRUE(algo.marked(2));
  ASSERT_TRUE(algo.marked(3));
  ASSERT_TRUE(algo.marked(4));
  ASSERT_TRUE(algo.marked(5));
  ASSERT_FALSE(algo.marked(6));
  ASSERT_FALSE(algo.marked(7));
  ASSERT_FALSE(algo.marked(8));
  ASSERT_FALSE(algo.marked(9));
  ASSERT_FALSE(algo.marked(10));
  ASSERT_FALSE(algo.marked(11));
  ASSERT_FALSE(algo.marked(12));
}

TEST(DirectedDFS, MultipleSources) {
  algorithms::Digraph g{13};
  g.addEdge(4,2);
  g.addEdge(2,3);
  g.addEdge(3,2);
  g.addEdge(6,0);
  g.addEdge(0,1);
  g.addEdge(2,0);
  g.addEdge(11,12);
  g.addEdge(12,9);
  g.addEdge(9,10);
  g.addEdge(9,11);
  g.addEdge(7,9);
  g.addEdge(10,12);
  g.addEdge(11,4);
  g.addEdge(4,3);
  g.addEdge(3,5);
  g.addEdge(6,8);
  g.addEdge(8,6);
  g.addEdge(5,4);
  g.addEdge(0,5);
  g.addEdge(6,4);
  g.addEdge(6,9);
  g.addEdge(7,6);
  std::unordered_set<int> sources;
  sources.insert(1);
  sources.insert(2);
  sources.insert(6);
  algorithms::DirectedDepthFirstSearch algo(g, sources);
  ASSERT_TRUE(algo.marked(0));
  ASSERT_TRUE(algo.marked(1));
  ASSERT_TRUE(algo.marked(2));
  ASSERT_TRUE(algo.marked(3));
  ASSERT_TRUE(algo.marked(4));
  ASSERT_TRUE(algo.marked(5));
  ASSERT_TRUE(algo.marked(6));
  ASSERT_FALSE(algo.marked(7));
  ASSERT_TRUE(algo.marked(8));
  ASSERT_TRUE(algo.marked(9));
  ASSERT_TRUE(algo.marked(10));
  ASSERT_TRUE(algo.marked(11));
  ASSERT_TRUE(algo.marked(12));
}
